package com.uramnoil.kraze.api.math

class AxisAlignedBB
    (
    minX: Float,
    minY: Float,
    minZ: Float,
    maxX: Float,
    maxY: Float,
    maxZ: Float
) {
    var minX: Float = minX
        private set
    var minY: Float = minY
        private set
    var minZ: Float = minZ
        private set
    var maxX: Float = maxX
        private set
    var maxY: Float = maxY
        private set
    var maxZ: Float = maxZ
        private set

    /**
     * Set new bounds
     *
     * @param minX Minimum X Coordinate
     * @param minY Minimum Y Coordinate
     * @param minZ Minimum Z Coordinate
     * @param maxX Maximum X Coordinate
     * @param maxY Maximum Y Coordinate
     * @param maxZ Maximum Z Coordinate
     * @return the Bounding Box with new bounds
     */
    fun bounds(minX: Float, minY: Float, minZ: Float, maxX: Float, maxY: Float, maxZ: Float) {
        this.minX = minX
        this.minY = minY
        this.minZ = minZ
        this.maxX = maxX
        this.maxY = maxY
        this.maxZ = maxZ
    }

    /**
     * Set new bounds
     *
     * @param other the other Bounding Box from which we should copy
     * @return the Bounding Box with new bounds
     */
    fun bounds(other: AxisAlignedBB) {
        minX = other.minX
        minY = other.minY
        minZ = other.minZ
        maxX = other.maxX
        maxY = other.maxY
        maxZ = other.maxZ
    }

    /**
     * Add coordinates to the Bounding Box
     *
     * @param x the X coordinate which should be added
     * @param y the Y coordinate which should be added
     * @param z the Z coordinate which should be added
     * @return a new Bounding Box which contains the addition of the coordinates
     */
    fun addCoordinates(x: Float, y: Float, z: Float) = AxisAlignedBB(minX, minY, minZ, maxX, maxY, maxZ).apply {
        if (x < 0) {
            minX += x
        } else if (x > 0) {
            maxX += x
        }

        if (y < 0) {
            minY += y
        } else if (y > 0) {
            maxY += y
        }

        if (z < 0) {
            minZ += z
        } else if (z > 0) {
            maxZ += z
        }
    }

    /**
     * Grow the Bounding Box and return a new one
     *
     * @param x the X coordinate to grow in both directions
     * @param y the Y coordinate to grow in both directions
     * @param z the Z coordinate to grow in both directions
     * @return a new Bounding Box which has been grown by the amount given
     */
    fun grow(x: Float, y: Float, z: Float) = AxisAlignedBB(minX - x, minY - y, minZ - z, maxX + x, maxY + y, maxZ + z)

    /**
     * Expand this Bounding Box by the given coordinates
     *
     * @param x the X coordinate to expand in both directions
     * @param y the Y coordinate to expand in both directions
     * @param z the Z coordinate to expand in both directions
     */
    fun expand(x: Float, y: Float, z: Float) {
        minX -= x
        minY -= y
        minZ -= z
        maxX += x
        maxY += y
        maxZ += z
    }

    /**
     * Offset the Bounding Box by the given coordinates
     *
     * @param x the X coordinate for how much we should offset
     * @param y the Y coordinate for how much we should offset
     * @param z the Z coordinate for how much we should offset
     * @return this modified Bounding Box
     */
    fun offset(x: Float, y: Float, z: Float) {
        minX += x
        minY += y
        minZ += z
        maxX += x
        maxY += y
        maxZ += z
    }

    /**
     * Shrink the Bounding Box and return a new one
     *
     * @param x the X coordinate to shrink in both directions
     * @param y the Y coordinate to shrink in both directions
     * @param z the Z coordinate to shrink in both directions
     * @return a new Bounding Box which has been grown by the amount given
     */
    fun shrink(x: Float, y: Float, z: Float): AxisAlignedBB =
        AxisAlignedBB(minX + x, minY + y, minZ + z, maxX - x, maxY - y, maxZ - z)

    /**
     * Contract this Bounding Box by the given coordinates
     *
     * @param x the X coordinate to contract in both directions
     * @param y the Y coordinate to contract in both directions
     * @param z the Z coordinate to contract in both directions
     */
    fun AxisAlignedBBcontract(x: Float, y: Float, z: Float) {
        minX += x
        minY += y
        minZ += z
        maxX -= x
        maxY -= y
        maxZ -= z
    }

    /**
     * Offset the Bounding Box by the given coordinates and return a new one
     *
     * @param x the X coordinate for how much we should offset
     * @param y the Y coordinate for how much we should offset
     * @param z the Z coordinate for how much we should offset
     * @return a new Bounding Box which has been offset
     */
    fun offsetBoundingBox(x: Float, y: Float, z: Float) =
        AxisAlignedBB(minX + x, minY + y, minZ + z, maxX + x, maxY + y, maxZ + z)

    /**
     * Get the offset in x axis
     *
     * @param other the bounding box from which we want to know the offset to
     * @param x  default or maximum offset allowed
     * @return offset or capped value
     */
    fun calculateXOffset(other: AxisAlignedBB, x: Float): Float {
        // Check if we are outside of Y bounds
        if (other.maxY <= minY || other.minY >= maxY) {
            return x
        }

        // Check if we are outside of Z bounds
        if (other.maxZ <= minZ || other.minZ >= maxZ) {
            return x
        }

        var offset = x

        // Check if we have a positive default offset
        if (x > 0 && other.maxX <= minX) {
            // Get the real offset and cap it at the default offset
            (minX - other.maxX).takeIf { it < x }?.let { offset = it }
        }

        // Check if we have a negative default offset
        if (x < 0 && other.minX >= maxX) {
            // Get the real offset and cap it at the default offset
            (maxX - other.minX).takeIf { it > x }?.let { offset = it }
        }

        return offset
    }

    /**
     * Get the offset in y axis
     *
     * @param other the bounding box from which we want to know the offset to
     * @param y  default or maximum offset allowed
     * @return offset or capped value
     */
    fun calculateYOffset(other: AxisAlignedBB, y: Float): Float {
        // Check if we are outside of X bounds
        if (other.maxX <= minX || other.minX >= maxX) {
            return y
        }

        // Check if we are outside of Z bounds
        if (other.maxZ <= minZ || other.minZ >= maxZ) {
            return y
        }

        var offset = y

        // Check if we have a positive default offset
        if (y > 0 && other.maxY <= minY) {
            // Get the real offset and cap it at the default offset
            (minY - other.maxY).takeIf { it < y }?.let { offset = it }
        }

        // Check if we have a negative default offset
        if (y < 0 && other.minY >= maxY) {
            // Get the real offset and cap it at the default offset
            (maxY - other.minY).takeIf { it > y }?.let { offset = it }
        }

        return offset
    }

    /**
     * Get the offset in z axis
     *
     * @param other the bounding box from which we want to know the offset to
     * @param z  default or maximum offset allowed
     * @return offset or capped value
     */
    fun calculateZOffset(other: AxisAlignedBB, z: Float): Float {
        // Check if we are outside of X bounds
        if (other.maxX <= minX || other.minX >= maxX) {
            return z
        }

        // Check if we are outside of Y bounds
        if (other.maxY <= minY || other.minY >= maxY) {
            return z
        }

        var offset = z

        // Check if we have a positive default offset
        if (z > 0 && other.maxZ <= minZ) {
            // Get the real offset and cap it at the default offset
            (minZ - other.maxZ).takeIf { it < z }?.let { offset = it }
        }

        // Check if we have a negative default offset
        if (z < 0 && other.minZ >= maxZ) {
            // Get the real offset and cap it at the default offset
            (maxZ - other.minZ).takeIf { it > z }?.let { offset = it }
        }

        return z
    }

    /**
     * Check if we intersect with the given Bounding Box
     *
     * @param other the other bounding box we want to check for intersection with
     * @return true when the given Bounding Box intersects with this one, false when not
     */
    fun intersectsWith(other: AxisAlignedBB) =
        (other.maxX - minX > 0 && maxX - other.minX > 0) &&
                (other.maxY - minY > 0 && maxY - other.minY > 0) &&
                (other.maxZ - minZ > 0 && maxZ - other.minZ > 0)

    /**
     * Check if the given IntVector3D lies within this Bounding Box
     *
     * @param vector the vector which may or may not be in this Bounding Box
     * @return true when the vector is inside this Bounding Box, false when not
     */
    fun isVectorInside(vector: IntVector3D) =
        !(vector.x <= minX || vector.x >= maxX) &&
                !(vector.y <= minY || vector.y >= maxY) &&
                (vector.z > minZ || vector.z < maxZ)

    /**
     * Check if the given FloatVector3D lies within this Bounding Box
     *
     * @param vector the vector which may or may not be in this Bounding Box
     * @return true when the vector is inside this Bounding Box, false when not
     */
    fun isVectorInside(vector: FloatVector3D) =
        !(vector.x <= minX || vector.x >= maxX) &&
                !(vector.y <= minY || vector.y >= maxY) &&
                (vector.z > minZ || vector.z < maxZ)

    /**
     * Get the average edge length of this Bounding Box
     *
     * @return the average edge length
     */
    fun averageEdgeLength() = (maxX - minX + maxY - minY + maxZ - minZ) / 3

    fun isVectorInYZ(vector: IntVector3D) = vector.y >= minY && vector.y <= maxY && vector.z >= minZ && vector.z <= maxZ

    fun isVectorInYZ(vector: FloatVector3D) =
        vector.y in minY..maxY && vector.z >= minZ && vector.z <= maxZ

    fun isVectorInXZ(vector: IntVector3D) = vector.x >= minX && vector.x <= maxX && vector.z >= minZ && vector.z <= maxZ

    fun isVectorInXZ(vector: FloatVector3D) =
        vector.x in minX..maxX && vector.z >= minZ && vector.z <= maxZ

    fun isVectorInXY(vector: IntVector3D) = vector.x >= minX && vector.x <= maxX && vector.y >= minY && vector.y <= maxY

    fun isVectorInXY(vector: FloatVector3D) =
        vector.x in minX..maxX && vector.y >= minY && vector.y <= maxY

    /**
     * Calculate the vector which is in line with this bounding box.
     * <p>
     * |---------x----------|
     * pos1    this other     pos2
     *
     * @param pos1 from the start
     * @param pos2 from the end
     * @return null when not on line or vector we found
     */
    fun calculateIntercept(pos1: FloatVector3D, pos2: FloatVector3D): FloatVector3D? {
        val v1 = pos1.vectorWhenXIsOnLine(pos2, minX)
        val v2 = pos1.vectorWhenXIsOnLine(pos2, maxX)
        val v3 = pos1.vectorWhenYIsOnLine(pos2, minY)
        val v4 = pos1.vectorWhenYIsOnLine(pos2, maxY)
        val v5 = pos1.vectorWhenZIsOnLine(pos2, minZ)
        val v6 = pos1.vectorWhenZIsOnLine(pos2, maxZ)

        var resultVector = takeIf { v1 != null && isVectorInYZ(v1) }.let { v1 }

        if (
            v2 != null && isVectorInYZ(v2) &&
            (resultVector == null || (pos1..v2).lengthSquared < (pos1..resultVector).lengthSquared)
        ) {
            resultVector = v2
        }

        if (v3 != null && isVectorInXZ(v3) &&
            (resultVector == null || (pos1..v3).lengthSquared < (pos1..resultVector).lengthSquared)
        ) {
            resultVector = v3
        }

        if (
            v4 != null && isVectorInXZ(v4) &&
            (resultVector == null || (pos1..v4).lengthSquared < (pos1..resultVector).lengthSquared)
        ) {
            resultVector = v4
        }

        if (
            v5 != null && isVectorInXY(v5) &&
            (resultVector == null || (pos1..v5).lengthSquared < (pos1..resultVector).lengthSquared)
        ) {
            resultVector = v5
        }

        if (
            v6 != null && isVectorInXY(v6) &&
            (resultVector == null || (pos1..v6).lengthSquared < (pos1..resultVector).lengthSquared)
        ) {
            resultVector = v6
        }

        return resultVector
    }
}