package com.tenkiv.support.solnotitia

import com.jme3.scene.Geometry
import com.jme3.scene.shape.Box

class Brain {
    fun createPlayer(name: String, box: Box): Geometry {
        return Geometry(name, box)
    }
}