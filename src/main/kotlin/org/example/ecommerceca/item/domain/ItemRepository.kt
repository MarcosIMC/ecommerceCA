package org.example.ecommerceca.item.domain

import org.example.ecommerceca.item.domain.model.Item
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

interface ItemRepository {
    @OptIn(ExperimentalUuidApi::class)
    fun fetch(id: Uuid): Item?
    fun save(item: Item)
    @OptIn(ExperimentalUuidApi::class)
    fun delete(id: Uuid)
    @OptIn(ExperimentalUuidApi::class)
    fun update(id: Uuid, item: Item)
    fun findAll(): List<Item>
}