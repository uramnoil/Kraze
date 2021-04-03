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

    fun vectorWhenXIsOnLine(other: FloatVector3D, x: Float): FloatVector3D? {
        val xDiff: Float = other.x - this.x
        val yDiff: Float = other.y - y
        val zDiff: Float = other.z - z
        return ((x - this.x) / xDiff)
            .takeIf { it in 0f..1f }
            ?.let { FloatVector3D(this.x + xDiff * it, y + yDiff * it, z + zDiff * it) }
    }

    /**
     * Get a new vector with the y axis set to the y parameter when the y parameter is
     * on a line with this and the vector other
     *
     * @param other to check with
     * @param y     which may on the line or not
     * @return vector with y set or null when y is not on a line with this and the other vector
     */
    fun vectorWhenYIsOnLine(other: FloatVector3D, y: Float): FloatVector3D? {
        val xDiff: Float = other.x - x
        val yDiff: Float = other.y - this.y
        val zDiff: Float = other.z - z
        return ((y - this.y) / yDiff)
            .takeIf { it in 0f..1f }?.let { FloatVector3D(x + xDiff * it, this.y + yDiff * it, z + zDiff * it) }
    }

    /**
     * Get a new vector with the z axis set to the z parameter when the z parameter is
     * on a line with this and the vector other
     *
     * @param other to check with
     * @param z     which may on the line or not
     * @return vector with y set or null when y is not on a line with this and the other vector
     */
    fun vectorWhenZIsOnLine(other: FloatVector3D, z: Float): FloatVector3D? {
        val xDiff: Float = other.x - x
        val yDiff: Float = other.y - y
        val zDiff: Float = other.z - this.z
        return (z - this.z / zDiff)
            .takeIf { it in 0f..1f }
            ?.let { FloatVector3D(x + xDiff * it, y + yDiff * it, this.z + zDiff * it) }
    }
}