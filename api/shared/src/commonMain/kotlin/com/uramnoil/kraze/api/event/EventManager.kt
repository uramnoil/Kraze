package com.uramnoil.kraze.api.event

object EventManager {
    val set = EventSourceSet()

    fun <E : Event> publish(event: E) {
        ((set[event] ?: throw Exception("")) as EventSource<E>).publish(event)
    }
}