package com.uramnoil.kraze.api.entity

import com.uramnoil.kraze.api.component.ComponentHolder
import com.uramnoil.kraze.api.math.FloatVector2D
import com.uramnoil.kraze.api.math.FloatVector3D
import com.uramnoil.kraze.api.world.Location

interface Entity : ComponentHolder {
    /**
     * Location with the entity.
     */
    var location: Location

    /**
     * The direction in which the body is facing.
     */
    var direction: FloatVector2D

    /**
     * 1tick movement.
     */
    var movement: FloatVector3D

    /**
     * Age of this entity.
     */
    @OptIn(ExperimentalUnsignedTypes::class)
    val age: ULong

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
}