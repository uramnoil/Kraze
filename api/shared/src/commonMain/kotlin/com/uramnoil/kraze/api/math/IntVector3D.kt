package com.uramnoil.kraze.api.math

import com.uramnoil.kraze.api.component.Component


/**
 * Integer three-dimensional vector.
 *
 * @property x
 * @property y
 * @property z
 */
data class IntVector3D(var x: Int, var y: Int, var z: Int) : Component {
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

    operator fun rangeTo(other: IntVector3D) = IntVector3D(
        other.x - x,
        other.y - y,
        other.z - y
    )
}