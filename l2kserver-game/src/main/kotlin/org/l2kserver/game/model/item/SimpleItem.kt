package org.l2kserver.game.model.item

import org.l2kserver.game.domain.ItemEntity

class SimpleItem(
    itemEntity: ItemEntity,
    itemTemplate: SimpleItemTemplate
): Item {
    override val id: Int = itemEntity.id.value

    override val templateId by itemEntity::templateId
    override var ownerId by itemEntity::ownerId
    override var amount by itemEntity::amount
    override var equippedAt by itemEntity::equippedAt
    override var enchantLevel by itemEntity::enchantLevel
    override var augmentationId by itemEntity::augmentationId

    override val name = itemTemplate.name
    override val type = itemTemplate.type
    override val grade = itemTemplate.grade
    override val weight = itemTemplate.weight
    override val price = itemTemplate.price
    override val isSellable = itemTemplate.isSellable
    override val isDroppable = itemTemplate.isDroppable
    override val isDestroyable = itemTemplate.isDestroyable
    override val isExchangeable = itemTemplate.isExchangeable
    override val isStackable = true

    override val category = itemTemplate.category
    override val group = ItemGroup.ETC

    override fun toString() = "Item(name=$name id=$id amount=$amount)"
}
