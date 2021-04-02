package com.uramnoil.kraze.api.math

import com.uramnoil.kraze.api.component.Component


/**
 * Three-dimensional vector.
 *
 * @property x
 * @property y
 * @property z
 */
data class Vector3D<T : Number>(var x: T, var y: T, var z: T) : Component