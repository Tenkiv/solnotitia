package com.tenkiv.support.solnotitia

import com.jme3.app.SimpleApplication
import com.jme3.asset.plugins.ZipLocator
import com.jme3.bullet.BulletAppState
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape
import com.jme3.bullet.control.CharacterControl
import com.jme3.bullet.control.RigidBodyControl
import com.jme3.bullet.util.CollisionShapeFactory
import com.jme3.input.KeyInput
import com.jme3.input.controls.ActionListener
import com.jme3.input.controls.KeyTrigger
import com.jme3.light.AmbientLight
import com.jme3.light.DirectionalLight
import com.jme3.math.ColorRGBA
import com.jme3.math.Vector3f

class BulletSim : SimpleApplication(), ActionListener {
    private val brain = Brain()

    private val sceneModel by lazy { assetManager.loadModel("main.scene") }
    private val bulletAppState by lazy { BulletAppState() }
    private lateinit var landscape: RigidBodyControl
    private lateinit var player: CharacterControl
    private val walkDirection by lazy { Vector3f() }
    private val camDir by lazy { Vector3f() }
    private val camLeft by lazy { Vector3f() }
    private var left = false
    private var right = false
    private var up = false
    private var down = false

    override fun simpleInitApp() {
        stateManager.attach(bulletAppState)
        bulletAppState.isDebugEnabled = true
        viewPort.backgroundColor = ColorRGBA(0.7f, 0.8f, 1f, 1f)
        flyCam.moveSpeed = 100f
        setupKeys()
        setupLight()

        assetManager.registerLocator("town.zip", ZipLocator::class.java)
        sceneModel.setLocalScale(2f)

        val sceneShape = CollisionShapeFactory.createMeshShape(sceneModel)
        landscape = RigidBodyControl(sceneShape, 0f)
        sceneModel.addControl(landscape)

        val capsuleShape = CapsuleCollisionShape(1.5f, 6f, 1)
        player = CharacterControl(capsuleShape, 0.05f)
        player.jumpSpeed = 20f
        player.fallSpeed = 30f
        player.gravity = 30f
        player.physicsLocation = Vector3f(0f, 10f, 0f)

        rootNode.attachChild(sceneModel)
        bulletAppState.physicsSpace.add(landscape)
        bulletAppState.physicsSpace.add(player)
    }

    private fun setupKeys() {
        inputManager.addMapping("left", KeyTrigger(KeyInput.KEY_A))
        inputManager.addMapping("right", KeyTrigger(KeyInput.KEY_D))
        inputManager.addMapping("up", KeyTrigger(KeyInput.KEY_W))
        inputManager.addMapping("down", KeyTrigger(KeyInput.KEY_S))
        inputManager.addMapping("jump", KeyTrigger(KeyInput.KEY_SPACE))
        inputManager.addListener(this, "left")
        inputManager.addListener(this, "right")
        inputManager.addListener(this, "up")
        inputManager.addListener(this, "down")
        inputManager.addListener(this, "jump")
    }

    override fun onAction(binding: String, isPressed: Boolean, tpf: Float) {
        when (binding) {
            "left" -> {
                left = isPressed
            }
            "right" -> {
                right = isPressed
            }
            "down" -> {
                down = isPressed
            }
            "up" -> {
                up = isPressed
            }
            "jump" -> {
                if (isPressed) player.jump()
            }
            else -> {
                println("Something went wrong with switch case on actionListener.")
            }
        }
    }

    private fun setupLight() {
        val al = AmbientLight()
        al.color = ColorRGBA.White.mult(1.3f)
        rootNode.addLight(al)

        val dl = DirectionalLight()
        dl.color = ColorRGBA.White
        dl.direction = Vector3f(2.8f, -2.8f, -2.8f).normalizeLocal()
        rootNode.addLight(dl)
    }

    override fun simpleUpdate(tpf: Float) {
        camDir.set(cam.direction.multLocal(0.6f))
        camLeft.set(cam.left.multLocal(0.4f))
        walkDirection.set(0f, 0f, 0f)
        if (left) walkDirection.addLocal(camLeft)
        if (right) walkDirection.addLocal(camLeft.negate())
        if (up) walkDirection.addLocal(camDir)
        if (down) walkDirection.addLocal(camDir.negate())
        player.walkDirection = walkDirection
        cam.location = player.physicsLocation
    }

}