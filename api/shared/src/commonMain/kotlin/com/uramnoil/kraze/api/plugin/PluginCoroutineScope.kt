package com.uramnoil.kraze.api.plugin

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

abstract class PluginCoroutineScope : CoroutineScope {
    internal abstract val plugin: Plugin

    public fun launchWhenLoaded(block: suspend CoroutineScope.() -> Unit): Job = launch {
        plugin.block()
    }
}

class PluginCoroutineScopeImpl (
    override val plugin: Plugin,
    override val coroutineContext: CoroutineContext
) : PluginCoroutineScope() {
    init {
        if (plugin.isEnabled) {

        }
    }
}