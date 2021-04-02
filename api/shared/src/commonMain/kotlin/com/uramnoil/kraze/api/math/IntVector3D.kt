package com.uramnoil.kraze.api.math

import com.uramnoil.kraze.api.component.Component


/**
 * Integer three-dimensional vector.
 *
 * @property x
 * @property y
 * @property z
 */
data class IntVector3D(var x: Int = 0, var y: Int = 0, var z: Int = 0) : Component