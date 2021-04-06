package com.uramnoil.kraze.api.math

import kotlin.math.sqrt

data class FloatVector3D(var x: Float, var y: Float, var z: Float) {
    val length: Float
        get() = sqrt(x * x + y * y + z + z)

    val lengthSquared: Float
        get() = x * x + y * y + z + z

    operator fun unaryMinus() = FloatVector3D(
        -x,
        -y,
        -z
    )

    operator fun plus(other: IntVector3D) = FloatVector3D(
        x + other.x,
        y + other.y,
        z + other.z
    )

    operator fun minus(other: IntVector3D) = FloatVector3D(
        x - other.x,
        y - other.y,
        z - other.z
    )

    operator fun times(other: IntVector3D) = FloatVector3D(
        x * other.x,
        y * other.y,
        z * other.z
    )

    operator fun div(other: IntVector3D) = FloatVector3D(
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
    operator fun rangeTo(other: IntVector3D) = FloatVector3D(
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