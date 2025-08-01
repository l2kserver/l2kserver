package org.l2kserver.game.model.item

import org.l2kserver.game.extensions.model.item.toItem
import org.l2kserver.game.domain.ItemEntity
import org.l2kserver.game.model.stats.Stats

/**
 * In-game item instance
 *
 * @property id Item id
 * @property templateId Item template id (for example Squire's Shirt's itemTemplateId is 1146)
 * @property ownerId Identifier of a character, that owns this item
 * @property amount Items amount (in stack)
 * @property isEquipped Is this item equipped
 * @property name Item name
 * @property type Item type - weapon or armor part, slots to equip, etc.
 * @property grade Item grade
 * @property weight Item weight
 * @property price Item price, when selling it to NPC. Don't forget about taxes!
 * @property isSellable If true, this item can be sold to NPC
 * @property isDroppable If true, this item can be dropped on the ground
 * @property isDestroyable If true, this item can be destroyed
 * @property isExchangeable If true, this item can be exchanged with other players
 * @property category Item category
 * @property group Item group
 */
sealed interface Item {
     val id: Int
     val templateId: Int
     var ownerId: Int
     var amount: Int
     var equippedAt: Slot?
     var enchantLevel: Int
     var augmentationId: Int
     val name: String
     val type: ItemType
     val grade: Grade
     val weight: Int
     val price: Int
     val isSellable: Boolean
     val isDroppable: Boolean
     val isDestroyable: Boolean
     val isExchangeable: Boolean
     val isStackable: Boolean
     val category: ItemCategory
     val group: ItemGroup

    val isEquipped: Boolean get() = equippedAt != null

    companion object {
        fun findById(id: Int) = requireNotNull(ItemEntity.findById(id)?.toItem()) { "No item was found by id='$id'" }
    }
}

/**
 * In-game item instance, that can be equipped
 *
 * @property stats Stats that will be given to the character when equipping the item
 */
sealed interface EquippableItem : Item {
    val stats: Stats

    override val isStackable: Boolean get() = false
}

/**
 * In-game item instance, that can be used
 */
sealed interface UsableItem: Item

/**
 * In-game item that can be crystallized
 *
 * @property crystalCount How many crystals will be given for this item crystallization
 */
sealed interface CrystallizableItem: Item {
    val crystalCount: Int
}
