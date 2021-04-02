package com.uramnoil.kraze.api.component

/**
 * Interface to indicate that a component can be possessed.
 *
 */
interface ComponentHolder {
    /**
     * A set of components.
     *
     * The concrete class has MutableList.
     */
    val components: Set<Component>

    /**
     * Add a component.
     *
     * @param T Component type.
     * @param component Components to add.
     */
    fun <T : Component> add(component: T)

    operator fun Component.unaryPlus() {
        add(this)
    }
}

/**
 * Returns a component that is instances of specified type parameter R
 *
 * @param T
 */
inline fun <reified T : Component> ComponentHolder.get() = components.filterIsInstance<T>().first()

/**
 * Returns a component that is instances of specified type parameter R, or null if there are no components.
 *
 * @param T
 */
inline fun <reified T : Component> ComponentHolder.getOrNull() = components.filterIsInstance<T>().firstOrNull()