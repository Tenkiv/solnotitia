package com.tenkiv.support.solnotitia

import com.gluonhq.charm.down.Platform
import com.interactivemesh.jfx.importer.obj.ObjModelImporter
import javafx.application.Application
import javafx.scene.paint.Color
import javafx.scene.paint.PhongMaterial
import javafx.scene.shape.Box
import javafx.stage.Screen
import javafx.stage.Stage
import javafx.event.EventHandler
import javafx.scene.*
import com.interactivemesh.jfx.importer.ImportException
import com.interactivemesh.jfx.importer.obj.ObjImportOption
import javafx.scene.transform.Rotate

class SolNotitia : Application() {
    private val root = Group()
    private val world = Xform()
    private val axisGroup = Xform()
    private val houseMeshGroup = Xform()
    private val camera = PerspectiveCamera(true)
    private val cameraXform = Xform()
    private val cameraXform2 = Xform()
    private val cameraXform3 = Xform()
    private var mousePosX: Double = 0.0
    private var mousePosY: Double = 0.0
    private var mouseOldX: Double = 0.0
    private var mouseOldY: Double = 0.0
    private var mouseDeltaX: Double = 0.0
    private var mouseDeltaY: Double = 0.0
    private val controlMultplier = 0.1
    private val shiftMultiplier = 10.0
    private val mouseSpeed = 0.1
    private val rotationSpeed = 2.0
    private val trackSpeed = 0.3

    private fun buildCamera() {
        root.children.add(cameraXform)
        cameraXform.children.add(cameraXform2)
        cameraXform2.children.add(cameraXform3)
        cameraXform3.children.add(camera)
        cameraXform3.setRotateZ(180.0)

        camera.nearClip = cameraNearClip
        camera.farClip = cameraFarClip
        camera.translateZ = cameraInitialDistance
        cameraXform.ry.angle = cameraInitialYAngle
        cameraXform.rx.angle = cameraInitialXAngle
    }

    private fun createGeometry() {
        val redMaterial = PhongMaterial()
        redMaterial.diffuseColor = Color.DARKRED
        redMaterial.specularColor = Color.RED

        val greenMaterial = PhongMaterial()
        greenMaterial.diffuseColor = Color.DARKGREEN
        greenMaterial.specularColor = Color.GREEN

        val blueMaterial = PhongMaterial()
        blueMaterial.diffuseColor = Color.DARKBLUE
        blueMaterial.specularColor = Color.BLUE

        val xAxis = Box(axisLength, 1.0, 1.0)
        val yAxis = Box(1.0, axisLength, 1.0)
        val zAxis = Box(1.0, 1.0, axisLength)

        xAxis.material = redMaterial
        yAxis.material = greenMaterial
        zAxis.material = blueMaterial

        axisGroup.children.addAll(xAxis, yAxis, zAxis)
        axisGroup.isVisible = true
        world.children.addAll(axisGroup)
    }

    private fun handleMouse(scene: Scene, root: Node) {
        scene.onMousePressed = EventHandler { me ->
            mousePosX = me.sceneX
            mousePosY = me.sceneY
            mouseOldX = me.sceneX
            mouseOldY = me.sceneY
        }
        scene.onMouseDragged = EventHandler { me ->
            mouseOldX = mousePosX
            mouseOldY = mousePosY
            mousePosX = me.sceneX
            mousePosY = me.sceneY
            mouseDeltaX = mousePosX - mouseOldX
            mouseDeltaY = mousePosY - mouseOldY

            var modifier = 1.0

            if (me.isControlDown) {
                modifier = controlMultplier
            }
            if (me.isShiftDown) {
                modifier = shiftMultiplier
            }
            when {
                me.isPrimaryButtonDown -> {
                    cameraXform.ry.angle = cameraXform.ry.angle - mouseDeltaX * mouseSpeed * modifier * rotationSpeed
                    cameraXform.rx.angle = cameraXform.rx.angle + mouseDeltaY * mouseSpeed * modifier * rotationSpeed
                }
                me.isSecondaryButtonDown -> {
                    val z = camera.translateZ
                    val newZ = z + mouseDeltaX * mouseSpeed * modifier
                    camera.translateZ = newZ
                }
                me.isMiddleButtonDown -> {
                    cameraXform2.t.x = cameraXform2.t.x + mouseDeltaX * mouseSpeed * modifier * trackSpeed
                    cameraXform2.t.y = cameraXform2.t.y + mouseDeltaY * mouseSpeed * modifier * trackSpeed
                }
            }
        }
    }

    override fun start(stage: Stage) {
        root.children.add(world)

        buildCamera()
        createGeometry()

        val scene = Scene(root, 1920.0, 1080.0, true, SceneAntialiasing.BALANCED)
        scene.fill = Color.GREY
        handleMouse(scene, world)

        //add models here
        val objImporter = ObjModelImporter()
        objImporter.setOptions(ObjImportOption.GENERATE_NORMALS)
        try {
            val modelUrl = ClassLoader.getSystemResource("house_model.obj")
            objImporter.read(modelUrl)
        } catch (e: ImportException) {
            // handle exception
            println(e.message)
        }

        val houseMesh = objImporter.import

        houseMeshGroup.isVisible = true
        houseMesh.forEach {
            //set scale of each MeshView
            it.scaleX = 0.1
            it.scaleY = 0.1
            it.scaleZ = 0.1
            it.transforms.setAll(Rotate(60.0, Rotate.Y_AXIS), Rotate(-90.0, Rotate.X_AXIS))

            //add MeshView to group
            houseMeshGroup.children.add(it)
        }

        //add group to world Xform
        world.children.addAll(houseMeshGroup)

        val primaryScreenBounds = Screen.getPrimary().visualBounds

        if (Platform.isAndroid()) {
            //set Stage boundaries to visible bounds of the main screen
            stage.x = primaryScreenBounds.minX
            stage.y = primaryScreenBounds.minY
            stage.width = primaryScreenBounds.width
            stage.height = primaryScreenBounds.height
        } else {
            stage.maxWidth = 1920.0
            stage.maxHeight = 1080.0
            stage.minWidth = 1920.0
            stage.minHeight = 1080.0
        }

        stage.scene = scene
        stage.show()

        scene.camera = camera
    }

    companion object {
        val axisLength: Double = 250.0
        val cameraNearClip = 0.1
        val cameraFarClip = 10000.0
        val cameraInitialDistance = -450.0
        val cameraInitialXAngle = 70.0
        val cameraInitialYAngle = 320.0
    }
}