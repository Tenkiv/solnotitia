package com.tenkiv.support.solnotitia

import javafx.scene.text.Font
import tornadofx.Stylesheet

class SNStyles : Stylesheet() {
    companion object {
        val replica : Font? = SNStyles::class.java.getResourceAsStream("/header_font.ttf").use { Font.loadFont(it, 48.0)}
        val din : Font? = SNStyles::class.java.getResourceAsStream("/din.ttf").use { Font.loadFont(it, 48.0)}
    }
    init {
    }
}