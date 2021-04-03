package com.uramnoil.kraze.api.entity

import com.uramnoil.kraze.api.world.Location

interface Entity {
    /**
     * Location with the entity.
     */
    var location: Location

    /**
     * Location where the Entity will spawn.
     */
    var spawnLocation: Location

    /**
     * Tags that appear above the entity
     */
    var nameTag: String

    /**
     * Whether to display the [nameTag] above the entity.
     */
    var isNameTagVisible: Boolean

    /**
     * Whether the entity is visible to others.
     */
    var isVisible: Boolean

    /**
     * Whether the entity is immovable or not.
     */
    var isImmobile: Boolean

    /**
     * Whether collision is possible in collision box.
     */
    var canCollide: Boolean
}