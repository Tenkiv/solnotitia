package com.tenkiv.support.solnotitia

import com.jme3.material.Material
import com.jme3.math.Vector3f
import com.jme3.scene.Geometry
import com.jme3.scene.shape.Box
import com.jme3.texture.Texture

data class SpatialData(
        val mesh: Box,
        val geometry: Geometry,
        val material: Material,
        val texture: Texture
)




//    val cube1 = run {
//        val cube1Mat = Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
//        val cube1Tex = assetManager.loadTexture("Textures/Monkey.jpg")
//        cube1Mat.setTexture("ColorMap", cube1Tex)
//        cube1Geo.material = cube1Mat
//
//        SpatialData(box, Geometry("My Textured Box", box))
//    }

