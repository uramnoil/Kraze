package com.uramnoil.kraze.api.math

import com.uramnoil.kraze.api.component.Component
import kotlin.math.sqrt


/**
 * Integer three-dimensional vector.
 *
 * @property x
 * @property y
 * @property z
 */
data class IntVector3D(val x: Int, val y: Int, val z: Int) : Component {
    val length: Float
        get() = sqrt((x * x + y * y + z + z).toFloat())

    val lengthSquared: Int
        get() = x * x + y * y + z + z

    operator fun unaryMinus() = IntVector3D(
        -x,
        -y,
        -z
    )

    operator fun plus(other: IntVector3D) = IntVector3D(
        x + other.x,
        y + other.y,
        z + other.z
    )

    operator fun minus(other: IntVector3D) = IntVector3D(
        x - other.x,
        y - other.y,
        z - other.z
    )

    operator fun times(other: IntVector3D) = IntVector3D(
        x * other.x,
        y * other.y,
        z * other.z
    )

    operator fun div(other: IntVector3D) = IntVector3D(
        x / other.x,
        y / other.y,
        z / other.z
    )

    operator fun plus(other: FloatVector3D) = FloatVector3D(
        x + other.x,
        y + other.y,
        z + other.z
    )

    operator fun minus(other: FloatVector3D) = FloatVector3D(
        x - other.x,
        y - other.y,
        z - other.z
    )

    operator fun times(other: FloatVector3D) = FloatVector3D(
        x * other.x,
        y * other.y,
        z * other.z
    )

    operator fun div(other: FloatVector3D) = FloatVector3D(
        x / other.x,
        y / other.y,
        z / other.z
    )

    /**
     * IntVector3D from its own vector to the [other] vector.
     *
     * @param other
     */
    operator fun rangeTo(other: IntVector3D) = IntVector3D(
        other.x - x,
        other.y - y,
        other.z - z
    )

    /**
     * FloatVector3D from its own vector to the [other] vector.
     *
     * @param other
     */
    operator fun rangeTo(other: FloatVector3D) = FloatVector3D(
        other.x - x,
        other.y - y,
        other.z - z
    )
}