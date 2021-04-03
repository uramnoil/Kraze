package com.uramnoil.kraze.api.math

data class FloatVector3D(var x: Float, var y: Float, var z: Float) {
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