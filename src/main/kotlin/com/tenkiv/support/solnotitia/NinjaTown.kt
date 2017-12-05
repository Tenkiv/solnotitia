package com.tenkiv.support.solnotitia

import com.jme3.app.SimpleApplication

class NinjaTown: SimpleApplication() {
    override fun simpleInitApp() {
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

}