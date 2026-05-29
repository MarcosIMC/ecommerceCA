package org.example.ecommerceca.item.infraestructure.persistence

import org.example.ecommerceca.item.domain.ItemRepository
import org.example.ecommerceca.item.domain.model.Item
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class InMemoryRepository: ItemRepository  {
    @OptIn(ExperimentalUuidApi::class)
    var items: MutableMap<Uuid, Item> = mutableMapOf()

    @OptIn(ExperimentalUuidApi::class)
    override fun fetch(id: Uuid): Item? {
        items[id]?.let {
            return it
        }
        return null
    }

    @OptIn(ExperimentalUuidApi::class)
    override fun save(item: Item) {
        items.put(item.id, item)
    }

    @OptIn(ExperimentalUuidApi::class)
    override fun delete(id: Uuid) {
        items.remove(id)
    }

    @OptIn(ExperimentalUuidApi::class)
    override fun update(id: Uuid, item: Item) {
        if (items[id] == null) {
            items.put(id, item)
        } else {
            items[id] = item
        }
    }

    @OptIn(ExperimentalUuidApi::class)
    override fun findAll(): List<Item> {
        return items.values.toList()
    }
}