package com.uramnoil.kraze.api.entity

import com.uramnoil.kraze.api.component.ComponentHolder
import com.uramnoil.kraze.api.math.FloatVector3D
import com.uramnoil.kraze.api.world.Location

interface Entity : ComponentHolder {
    /**
     * Location with the entity.
     */
    val location: Location

    /**
     * The direction in which the body is facing.
     */
    val direction: FloatVector3D

    /**
     * 1tick movement.
     */
    val movement: FloatVector3D

    /**
     * Age of this entity.
     */
    val age: Long

    /**
     * Whether the entity is visible to others.
     */
    var isVisible: Boolean

    /**
     * Whether collision is possible in collision box.
     */
    var canCollide: Boolean

    /**
     * Whether it is grounded or not.
     */
    val onGround: Boolean

    /**
     * Entity size.
     */
    var scale: Float

    /**
     * Teleport to [to] in the same world.
     *
     * @param to
     */
    fun teleport(to: FloatVector3D)

    /**
     * Teleport to [to].
     *
     * @param to
     */
    fun teleport(to: Location)
}

/**
 * Move to [to] relative to the speed of [speed].
 *
 * @param to
 * @param speed meter per tick
 */
fun Entity.moveRelativelyTo(to: FloatVector3D, speed: Float) {
    TODO()
}

/**
 * Move to [to] absolute to the speed of [speed].
 *
 * @param to
 * @param speed meter per tick
 */
fun Entity.moveAbsolutelyTo(to: FloatVector3D, speed: Float) {
    TODO()
}