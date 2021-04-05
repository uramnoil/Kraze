package com.uramnoil.kraze.api.event

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch

class EventSource<E : Event> {
    private val lowestEventChannel = Channel<E>()

    val lowestEventReceiveChannel: ReceiveChannel<E>
        get() = lowestEventChannel

    private val lowEventChannel = Channel<E>()

    val lowEventReceiveChannel: ReceiveChannel<E>
        get() = lowEventChannel

    private val normalEventChannel = Channel<E>()

    val normalEventReceiveChannel: ReceiveChannel<E>
        get() = normalEventChannel

    private val highEventChannel = Channel<E>()

    val highEventReceiveChannel: ReceiveChannel<E>
        get() = highEventChannel

    private val highestEventChannel = Channel<E>()

    val highestEventReceiveChannel: ReceiveChannel<E>
        get() = highestEventChannel

    private val monitorEventChannel = Channel<E>()

    val monitorEventReceiveChannel: ReceiveChannel<E>
        get() = monitorEventChannel

    fun publish(event: E) {
        CoroutineScope(Dispatchers.Main.immediate).launch {
            lowestEventChannel.send(event)
            lowEventChannel.send(event)
            normalEventChannel.send(event)
            highEventChannel.send(event)
            highestEventChannel.send(event)
            monitorEventChannel.send(event)
        }
    }
}
