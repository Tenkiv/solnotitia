package com.tenkiv.support.solnotitia

import com.gluonhq.charm.down.Platform
import com.tenkiv.support.solnotitia.views.GlobeView
import javafx.stage.Screen
import javafx.stage.Stage
import tornadofx.App
import tornadofx.reloadStylesheetsOnFocus

class SolNotitia : App(GlobeView::class, SNStyles::class) {
    init {
        reloadStylesheetsOnFocus()
    }

    override fun start(stage: Stage) {
        super.start(stage)
        stage.show()

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
    }
}