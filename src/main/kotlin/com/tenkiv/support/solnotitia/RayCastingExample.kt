package com.tenkiv.support.solnotitia

import com.jme3.app.SimpleApplication
import com.jme3.collision.CollisionResults
import com.jme3.font.BitmapText
import com.jme3.input.KeyInput
import com.jme3.input.MouseInput
import com.jme3.input.controls.ActionListener
import com.jme3.input.controls.KeyTrigger
import com.jme3.input.controls.MouseButtonTrigger
import com.jme3.light.DirectionalLight
import com.jme3.material.Material
import com.jme3.math.ColorRGBA
import com.jme3.math.Ray
import com.jme3.math.Vector3f
import com.jme3.scene.Geometry
import com.jme3.scene.Node
import com.jme3.scene.Spatial
import com.jme3.scene.shape.Box
import com.jme3.scene.shape.Sphere

class RayCastingExample : SimpleApplication() {
    private val brain = Brain()

    private val shootables: Node by lazy {
        Node("Shootables")
    }

    private lateinit var mark: Geometry

    override fun simpleInitApp() {
        inputManager.isCursorVisible = true
        flyCam.isEnabled = false
//        initCrosshairs()
        initKeys()
        initMark()

        rootNode.attachChild(shootables)
        shootables.attachChild(makeCube("a Dragon", -2f, 0f, 1f))
        shootables.attachChild(makeCube("a tin can", 1f, -2f, 0f))
        shootables.attachChild(makeCube("the Sheriff", 0f, 1f, -2f))
        shootables.attachChild(makeCube("the Deputy", 1f, 0f, -4f))
        shootables.attachChild(makeFloor())
        shootables.attachChild(makeCharacter())
    }

    private fun initCrosshairs() {
        setDisplayStatView(false)
        guiFont = assetManager.loadFont("Fonts/aurulent-sans-16.fnt")
        val ch = BitmapText(guiFont, false)
        ch.size = guiFont.charSet.renderedSize * 2f
        ch.text = "+"
        ch.setLocalTranslation(settings.width / 2 - ch.lineWidth / 2, settings.height / 2
                + ch.lineHeight / 2, 0f)
        guiNode.attachChild(ch)
    }

    private fun initKeys() {
        inputManager.addMapping("Shoot", KeyTrigger(KeyInput.KEY_SPACE),
                MouseButtonTrigger(MouseInput.BUTTON_LEFT))
        inputManager.addListener(actionListener, "Shoot")
    }

    private val actionListener = ActionListener { name, keyPressed, float ->
        if (name == "Shoot" && !keyPressed) {
            val results = CollisionResults()

            val click2d = inputManager.cursorPosition.clone()
            val click3d = cam.getWorldCoordinates(click2d, 0f).clone()
            val dir = cam.getWorldCoordinates(click2d, 1f).
                    subtractLocal(click3d).normalizeLocal()
            val ray = Ray(click3d, dir)

//            val ray = Ray(cam.location, cam.direction)
            shootables.collideWith(ray, results)

            println("----- Collisions? ${results.size()} -----")
            for (i in 0 until results.size()) {
                val dist: Float = results.getCollision(i).distance
                val pt = Vector3f(results.getCollision(i).contactPoint)
                val hit = results.getCollision(i).geometry.name
                println("* Collision # $i")
                println("   You shot $hit at $pt, $dist wu away.")
            }

            if (results.size() > 0) {
                val closest = results.closestCollision
                val selectedGeo = closest.geometry
                selectedGeo.material.setColor("Color", ColorRGBA.Red)
                mark.localTranslation = closest.contactPoint
                rootNode.attachChild(mark)
            } else {
                rootNode.detachChild(mark)
            }
        }
    }

    private fun initMark() {
        val sphere = Sphere(30, 30, 0.2f)
        mark = Geometry("BOOM!", sphere)
        val markMat = Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
        markMat.setColor("Color", ColorRGBA.Red)
        mark.material = markMat
    }

    private fun makeCube(name: String, x: Float, y: Float, z: Float): Geometry {
        val box = Box(1f, 1f, 1f)
        val cube = Geometry(name, box)
        cube.setLocalTranslation(x, y, z)
        val mat1 = Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
        mat1.setColor("Color", ColorRGBA.randomColor())
        cube.material = mat1
        return cube
    }

    private fun makeFloor(): Geometry {
        val box = Box(15f, .2f, 15f)
        val floor = Geometry("the Floor", box)
        floor.setLocalTranslation(0f, -4f, -5f)
        val mat1 = Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
        mat1.setColor("Color", ColorRGBA.Gray)
        floor.material = mat1
        return floor
    }

    private fun makeCharacter(): Spatial {
        val golem = assetManager.loadModel("Models/Oto/Oto.mesh.xml")
        golem.scale(0.5f)
        golem.setLocalTranslation(-1.0f, -1.5f, -0.6f)
        val sun = DirectionalLight()
        sun.direction = Vector3f(-0.1f, -0.7f, -1.0f)
        golem.addLight(sun)
        return golem
    }

//    @Override override fun simpleUpdate(tpf: Float) {
//        super.simpleUpdate(tpf)
//        //tpf = time per frame
//        storage.playerList.find { it.name == "blue cube" }?.rotate(0f, 2f*tpf, 0f)
//        //2f*tpf means the cube rotates twice per frame
//    }
}