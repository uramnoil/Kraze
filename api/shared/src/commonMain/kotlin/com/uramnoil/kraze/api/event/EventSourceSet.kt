package com.uramnoil.kraze.api.event

import kotlin.reflect.KClass

class EventSourceSet {
    private val map = mutableMapOf<KClass<out Event>, EventSource<in Event>>()

    fun <E : Event> add(klass: KClass<out Event>) {
        map[klass] = EventSource()
    }

    inline fun <reified E : Event> add() {
        add<E>(E::class)
    }

    internal operator fun get(event: Event) = map.filterKeys { it.isInstance(event) }.values.firstOrNull()
}