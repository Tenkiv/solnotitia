package com.tenkiv.support.solnotitia

import com.jme3.animation.AnimChannel
import com.jme3.animation.AnimControl
import com.jme3.animation.LoopMode
import com.jme3.app.SimpleApplication
import com.jme3.input.KeyInput
import com.jme3.input.MouseInput
import com.jme3.input.controls.ActionListener
import com.jme3.input.controls.KeyTrigger
import com.jme3.input.controls.MouseButtonTrigger
import com.jme3.light.DirectionalLight
import com.jme3.material.Material
import com.jme3.material.RenderState
import com.jme3.math.ColorRGBA
import com.jme3.math.Vector3f
import com.jme3.renderer.queue.RenderQueue
import com.jme3.scene.Geometry
import com.jme3.scene.Node
import com.jme3.scene.debug.SkeletonDebugger
import com.jme3.scene.shape.Box
import com.jme3.scene.shape.Sphere
import com.jme3.util.TangentBinormalGenerator

class NinjaTown: SimpleApplication() {
    //TODO: Ask zack about these
//    private val control: AnimControl by lazy {
//        player.getControl(AnimControl::class.java)
//    }
//    private val channel: AnimChannel by lazy {
//        control.createChannel()
//    }
//    private val player: Node by lazy {
//        assetManager.loadModel("Models/Oto/Oto.mesh.xml") as Node
//    }

    override fun simpleInitApp() {
//        viewPort.backgroundColor = ColorRGBA.LightGray
//        initKeys()
//
//        val dl = DirectionalLight()
//        dl.direction = Vector3f(-0.1f, -1f, -1f).normalizeLocal()
//        rootNode.addLight(dl)
//
//        player.setLocalScale(0.5f)
//        rootNode.attachChild(player)
//
//        control.addListener(this)
//
//        channel.setAnim("stand")
//
//        control.animationNames.forEach {
//            println(it)
//        }

//        val skeletonDebug = SkeletonDebugger("skeleton", control.skeleton)
//        val skeleMat = Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
//        skeleMat.setColor("Color", ColorRGBA.Green)
//        skeleMat.additionalRenderState.isDepthTest = false
//        skeletonDebug.setMaterial(skeleMat)
//        player.attachChild(skeletonDebug)

//        inputManager.addMapping("pause", KeyTrigger(KeyInput.KEY_P))
//        inputManager.addMapping("left", KeyTrigger(KeyInput.KEY_J))
//        inputManager.addMapping("right", KeyTrigger(KeyInput.KEY_K))
//        inputManager.addMapping("rotate", KeyTrigger(KeyInput.KEY_SPACE),
//                MouseButtonTrigger(MouseInput.BUTTON_LEFT))
//
//        inputManager.addListener(KeyListener(Storage.geometries.bluePlayer,
//                speed), "pause", "left", "right", "rotate")

//        val cube1Mesh = Box(1f, 1f, 1f)
//        val cube1Geo = Geometry("My Textured Box", cube1Mesh)
//        cube1Geo.localTranslation = Vector3f(-3f, 1.1f, 0f)
//        val cube1Mat = Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
//        val cube1Tex = assetManager.loadTexture("Textures/Monkey.jpg")
//        cube1Mat.setTexture("ColorMap", cube1Tex)
//        cube1Geo.material = cube1Mat
//        rootNode.attachChild(cube1Geo)
//
//        val cube2Mesh = Box(1f, 1f, 0.01f)
//        val cube2Geo = Geometry("window frame", cube2Mesh)
//        val cube2Mat = Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
//        cube2Mat.setTexture("ColorMap",
//                assetManager.loadTexture("Textures/MonkeyColoredTex.png"))
//        cube2Mat.additionalRenderState.blendMode = RenderState.BlendMode.Alpha
//        cube2Geo.queueBucket = RenderQueue.Bucket.Transparent
//        cube2Geo.material = cube2Mat
//        rootNode.attachChild(cube2Geo)
//
//        val sphereMesh = Sphere(32, 32, 2f)
//        val sphereGeo = Geometry("Shiny Rock", sphereMesh)
//        sphereMesh.textureMode = Sphere.TextureMode.Projected
//        TangentBinormalGenerator.generate(sphereMesh)
//        val sphereMat = Material(assetManager, "Common/MatDefs/Light/Lighting.j3md")
//        sphereMat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/Pond.jpg"))
//        sphereMat.setTexture("NormalMap", assetManager.loadTexture("Textures/Pond_normal.png"))
//        sphereMat.setBoolean("UseMaterialColors", true)
//        sphereMat.setColor("Diffuse", ColorRGBA.White)
//        sphereMat.setColor("Specular", ColorRGBA.White)
//        sphereMat.setFloat("Shininess", 64f)
//        sphereGeo.material = sphereMat
//        sphereGeo.localTranslation = Vector3f(0f, 2f, -2f)
//        sphereGeo.rotate(1.6f, 0f, 0f)
//        rootNode.attachChild(sphereGeo)
//
//        val sun = DirectionalLight()
//        sun.direction = Vector3f(1f, 0f, -2f).normalizeLocal()
//        sun.color = ColorRGBA.White
//        rootNode.addLight(sun)

        //        val playerMat = Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
//        playerMat.setColor("Color", ColorRGBA.Blue)
//        Storage.geometries.bluePlayer.material = playerMat
//        rootNode.attachChild(Storage.geometries.bluePlayer)
//        initKeys()

        //        //blue box
//        val box1 = Box(1f, 1f, 1f)
//        val bluePlayer = Geometry("Blue Cube", box1)
//        bluePlayer.localTranslation = Vector3f(1f, -1f, 1f)
//        val mat = Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
//        mat.setColor("Color", ColorRGBA.Blue)
//        bluePlayer.material = mat
//
//        //red box
//        val box2 = Box(1f, 1f, 1f)
//        val redGeom = Geometry("Box", box2)
//        redGeom.localTranslation = Vector3f(1f, 1f, 1f)
//        val mat2 = Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
//        mat2.setColor("Color", ColorRGBA.Red)
//        redGeom.material = mat2
//
//        //pivot node
//        val boxGroup = Node("pivot")
//        rootNode.attachChild(boxGroup)
//
//        //attach two boxes to pivot node
//        boxGroup.attachChild(blueGeom)
//        boxGroup.attachChild(redGeom)
//
//        //messing with pivot node group
//        //moves it to specific coordinates
//        boxGroup.move(5f, 5f, 5f)
//        boxGroup.rotate(.4f, .4f, 0f)
//        boxGroup.scale(.5f, .5f, .5f)
//
//        //give node custom properties!!!
//        boxGroup.setUserData("box_feelings", "sad")
//        //have to specify bc kotlin can't infer type of property
//        println(boxGroup.getUserData<String>("box_feelings"))
//
//        //load a model
//        //a simple teapot
//        val teapot = assetManager.loadModel("Models/Teapot.obj")
//        val matTeapot = Material(assetManager, "Common/MatDefs/Misc/ShowNormals.j3md")
//        teapot.setMaterial(matTeapot)
//        rootNode.attachChild(teapot)
//
//        //a wall
//        val box = Box(2.5f, 2.5f, 1.0f)
//        val wall: Spatial = Geometry("Box", box)
//        val matWall = Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
//        matWall.setTexture("ColorMap", assetManager.loadTexture("Textures/BrickWall.jpg"))
//        wall.setMaterial(matWall)
//        wall.setLocalTranslation(2.0f, -2.5f, 0f)
//        rootNode.attachChild(wall)
//
//        //display some text
//        //clears the gui
//        guiNode.detachAllChildren()
//        guiFont = assetManager.loadFont("Fonts/aurulent-sans-16.fnt")
//        val helloText = BitmapText(guiFont, false)
//        helloText.size = 10f
//        helloText.text = "Whats Up My Dudes"
//        helloText.color = ColorRGBA.White
//        helloText.setLocalTranslation(300f, helloText.lineHeight, 0f)
//        guiNode.attachChild(helloText)
//
//        //load a super cool ninja
//        val ninja: Spatial = assetManager.loadModel("Models/Ninja.mesh.xml")
//        ninja.scale(0.05f, 0.05f, 0.05f)
//        ninja.rotate(0.0f, -3.0f, 0.0f)
//        ninja.setLocalTranslation(0.0f, -5.0f, -2.0f)
//        rootNode.attachChild(ninja)
//        //add a light to see the model
//        val sun = DirectionalLight()
//        sun.direction = Vector3f(-0.1f, -0.7f, -1.0f)
//        rootNode.addLight(sun)
//
//        //add a town using zip thing
//        assetManager.registerLocator("town.zip", ZipLocator::class.java)
//        val gameLevel: Spatial = assetManager.loadModel("main.scene")
//        gameLevel.setLocalTranslation(0f, -5.2f, 0f)
//        gameLevel.setLocalScale(2f)
//        rootNode.attachChild(gameLevel)
    }

//    private val actionListener = ActionListener { name, keyPressed, tpf ->
//        if (name == "Walk" && !keyPressed) {
//            if (channel.animationName != "Walk") {
//                channel.setAnim("Walk", 0.50f)
//                channel.loopMode = LoopMode.Loop
//            }
//        }
//
//        if (name == "Dodge" && !keyPressed) {
//            if (channel.animationName != "Dodge") {
//                channel.setAnim("Dodge", 0.50f)
//                channel.loopMode = LoopMode.Loop
//            }
//        }
//    }

//    val something = object: ActionListener {
//        override fun onAction(name: String?, isPressed: Boolean, tpf: Float) {
//        }
//    }

}