package com.tenkiv.support.solnotitia

import com.jme3.scene.Geometry
import com.jme3.scene.shape.Box

object Storage {
    private val brain = Brain()

    var isRunning = true

    private val testBox = Box(1f, 1f, 1f)

    //data class of geometries, extend when adding new geometry or custom model
    data class Geometries(val bluePlayer: Geometry)

    //initialize data class in storage object
    val geometries = Geometries(brain.createPlayer("blue player", testBox))
}