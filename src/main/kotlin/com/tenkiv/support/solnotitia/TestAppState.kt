package com.tenkiv.support.solnotitia

import com.jme3.app.Application
import com.jme3.app.state.BaseAppState

class TestAppState : BaseAppState() {
    override fun initialize(app: Application?) {
        //called when AppState is initialized
    }

    override fun cleanup(app: Application?) {
        //called when AppState is REMOVED
    }

    override fun onEnable() {
        //called when the AppState is running
        //call with testAppState.enabled = true
    }

    override fun onDisable() {
        //called when the AppState is paused
        //call with testAppState.enabled = false
    }

    override fun update(tpf: Float) {
        //call things while AppState is running to tie into the SimpleUpdate loop
        //only called while Enabled
    }
}