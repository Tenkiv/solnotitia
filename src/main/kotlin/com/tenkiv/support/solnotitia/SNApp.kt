package com.tenkiv.support.solnotitia

import com.jme3.app.SimpleApplication
import com.jme3.material.Material
import com.jme3.math.ColorRGBA
import com.jme3.math.Vector3f
import com.jme3.scene.Geometry
import com.jme3.scene.shape.Box

class SNApp : SimpleApplication() {

    override fun simpleInitApp() {
        createBoxes()
        flyCam.isEnabled = false
        cam.location = Vector3f(0f, -25f, 2f)
        cam.lookAt(rootNode.getChild("FG_OBJECT").localTranslation, Vector3f(0f, 1f, 0f))
    }

    private fun createBoxes() {
        val bgBox1 = createGeometry(2f, 2f, 2f,
                "BG_OBJECT1",
                -6f, 0f, 0f)
        val box1Mat = createMaterial()
        bgBox1.material = box1Mat
        rootNode.attachChild(bgBox1)

        val bgBox2 = createGeometry(2f, 2f, 2f,
                "BG_OBJECT2",
                6f, 0f, 0f)
        val box2Mat = createMaterial()
        bgBox2.material = box2Mat
        rootNode.attachChild(bgBox2)

        val fgBox = createGeometry(2f, 2f, 2f,
                "FG_OBJECT",
                0f, 0f, 0f)
        val fgBoxMat = createMaterial()
        fgBox.material = fgBoxMat
        rootNode.attachChild(fgBox)
    }

    private fun createGeometry(
            boxX: Float,
            boxY: Float,
            boxZ: Float,
            geoName: String,
            ltX: Float,
            ltY: Float,
            ltZ: Float
    ): Geometry {
        val b = Box(boxX, boxY, boxZ)
        val g = Geometry(geoName, b)
        g.localTranslation = Vector3f(ltX, ltY, ltZ)
        return g
    }

    private fun createMaterial(): Material {
        val m = Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
        m.setColor("Color", ColorRGBA.randomColor())
        return m
    }

    @Override
    override fun simpleUpdate(tpf: Float) {
    }
}