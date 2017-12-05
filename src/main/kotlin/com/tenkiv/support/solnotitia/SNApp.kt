package com.tenkiv.support.solnotitia

import com.jme3.app.SimpleApplication
import com.jme3.material.Material
import com.jme3.math.ColorRGBA
import com.jme3.scene.Geometry
import com.jme3.scene.shape.Box

class SNApp : SimpleApplication() {
    override fun simpleInitApp() {
        val box = Box(1f, 1f, 1f)
        val geom = Geometry("Box", box)
        val mat = Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
        mat.setColor("Color", ColorRGBA.Blue)
        geom.material = mat
        rootNode.attachChild(geom)
    }
}