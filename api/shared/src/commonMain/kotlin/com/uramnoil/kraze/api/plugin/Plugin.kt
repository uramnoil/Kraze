package com.uramnoil.kraze.api.plugin

import kotlinx.coroutines.*

abstract class Plugin : CoroutineScope {
    private val job = SupervisorJob()

    val coroutineScope = CoroutineScope(
        job + Dispatchers.Main.immediate + CoroutineExceptionHandler { _, throwable ->
            //ロギング
            isEnabled = false
        }
    )

    /**
     * Plugin's name.
     */
    abstract val name: String

    abstract val version: Version

    /**
     * Whether the plugin is enabled or not.
     */
    var isEnabled: Boolean = false
        internal set(value) {
            if (!value) {
                job.cancel(CancellationException("Plugin($name) has been disabled"))
                field = value
            }
        }

    open fun onLoaded() {}

    open suspend fun launchOnLoaded() {}

    open fun onEnabled() {}

    open suspend fun launchOnEnabled() {}

    open fun onDisabled() {}

    open fun launchOnDisabled() {}
}