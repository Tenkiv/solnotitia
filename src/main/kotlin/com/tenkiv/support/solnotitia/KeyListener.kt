package com.tenkiv.support.solnotitia

import com.jme3.input.controls.ActionListener
import com.jme3.input.controls.AnalogListener
import com.jme3.scene.Geometry

class KeyListener(private val listenNode: Geometry,
                  private val speed: Float) : AnalogListener, ActionListener {

    override fun onAnalog(name: String?, value: Float, tpf: Float) {
        if (Storage.isRunning) {
            when (name) {
                "rotate" -> {
                    println("rotate")
                    listenNode.rotate(0f, value * speed, 0f)
                }
                "right" -> {
                    println("right")
                    val v = listenNode.localTranslation
                    listenNode.setLocalTranslation(v.x + value * speed, v.y,
                            v.z)
                }
                "left" -> {
                    println("left")
                    val v = listenNode.localTranslation
                    listenNode.setLocalTranslation(v.x - value * speed, v.y, v.z)
                }
            }
        } else {
            println("Press P to unpause.")
        }
    }

    override fun onAction(name: String?, keyPressed: Boolean, tpf: Float) {
        if ( name == "pause" && !keyPressed ) {
            Storage.isRunning = !Storage.isRunning
        }
    }
}