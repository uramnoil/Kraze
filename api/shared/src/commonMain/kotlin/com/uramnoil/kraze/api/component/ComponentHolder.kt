package com.uramnoil.kraze.api.component

/**
 * Interface to indicate that a component can be possessed.
 *
 */
interface ComponentHolder {
    val components: Set<Component>
}

inline fun <reified T: Component> ComponentHolder.get() = components.filterIsInstance<T>().first()

inline fun <reified T: Component> ComponentHolder.getOrNull() = components.filterIsInstance<T>().firstOrNull()