package com.tenkiv.support.solnotitia

import com.jme3.app.SimpleApplication
import com.jme3.input.KeyInput
import com.jme3.input.MouseInput
import com.jme3.input.controls.KeyTrigger
import com.jme3.input.controls.MouseButtonTrigger
import com.jme3.light.DirectionalLight
import com.jme3.material.Material
import com.jme3.material.RenderState
import com.jme3.math.ColorRGBA
import com.jme3.math.Vector3f
import com.jme3.renderer.queue.RenderQueue
import com.jme3.scene.Geometry
import com.jme3.scene.shape.Box
import com.jme3.scene.shape.Sphere
import com.jme3.texture.Texture
import com.jme3.util.TangentBinormalGenerator

class SNApp : SimpleApplication() {

    private val brain = Brain()

    override fun simpleInitApp() {
        val cube1Mesh = Box(1f, 1f, 1f)
        val cube1Geo = Geometry("My Textured Box", cube1Mesh)
        cube1Geo.localTranslation = Vector3f(-3f, 1.1f, 0f)
        val cube1Mat = Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
        val cube1Tex = assetManager.loadTexture("Textures/Monkey.jpg")
        cube1Mat.setTexture("ColorMap", cube1Tex)
        cube1Geo.material = cube1Mat
        rootNode.attachChild(cube1Geo)

        val cube2Mesh = Box(1f, 1f, 0.01f)
        val cube2Geo = Geometry("window frame", cube2Mesh)
        val cube2Mat = Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
        cube2Mat.setTexture("ColorMap",
                assetManager.loadTexture("Textures/MonkeyColoredTex.png"))
        cube2Mat.additionalRenderState.blendMode = RenderState.BlendMode.Alpha
        cube2Geo.queueBucket = RenderQueue.Bucket.Transparent
        cube2Geo.material = cube2Mat
        rootNode.attachChild(cube2Geo)

        val sphereMesh = Sphere(32, 32, 2f)
        val sphereGeo = Geometry("Shiny Rock", sphereMesh)
        sphereMesh.textureMode = Sphere.TextureMode.Projected
        TangentBinormalGenerator.generate(sphereMesh)
        val sphereMat = Material(assetManager, "Common/MatDefs/Light/Lighting.j3md")
        sphereMat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/Pond.jpg"))
        sphereMat.setTexture("NormalMap", assetManager.loadTexture("Textures/Pond_normal.png"))
        sphereMat.setBoolean("UseMaterialColors", true)
        sphereMat.setColor("Diffuse", ColorRGBA.White)
        sphereMat.setColor("Specular", ColorRGBA.White)
        sphereMat.setFloat("Shininess", 64f)
        sphereGeo.material = sphereMat
        sphereGeo.localTranslation = Vector3f(0f, 2f, -2f)
        sphereGeo.rotate(1.6f, 0f, 0f)
        rootNode.attachChild(sphereGeo)

        val sun = DirectionalLight()
        sun.direction = Vector3f(1f, 0f, -2f).normalizeLocal()
        sun.color = ColorRGBA.White
        rootNode.addLight(sun)
    }

    @Override override fun simpleUpdate(tpf: Float) {
        super.simpleUpdate(tpf)
        //tpf = time per frame
//        storage.playerList.find { it.name == "blue cube" }?.rotate(0f, 2f*tpf, 0f)
        //2f*tpf means the cube rotates twice per frame
    }

    private fun initKeys() {
        inputManager.addMapping("pause", KeyTrigger(KeyInput.KEY_P))
        inputManager.addMapping("left", KeyTrigger(KeyInput.KEY_J))
        inputManager.addMapping("right", KeyTrigger(KeyInput.KEY_K))
        inputManager.addMapping("rotate", KeyTrigger(KeyInput.KEY_SPACE),
                MouseButtonTrigger(MouseInput.BUTTON_LEFT))

        inputManager.addListener(KeyListener(Storage.geometries.bluePlayer,
                speed), "pause", "left", "right", "rotate")
    }
}