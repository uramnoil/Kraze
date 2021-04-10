package com.uramnoil.kraze.api.entity

interface Living : Entity {
    /**
     * Maximum health.
     */
    var maxHealth: Float

    /**
     * Current health.
     */
    var health: Float
}