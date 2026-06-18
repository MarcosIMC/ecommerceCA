package org.example.ecommerceca.item.application.usecase;

import org.example.ecommerceca.item.domain.ItemRepository
import org.example.ecommerceca.item.domain.valueobject.ItemDescription
import org.example.ecommerceca.item.domain.valueobject.ItemName
import org.example.ecommerceca.item.domain.valueobject.ItemPrice
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class UpdateItemUseCase(private val repository: ItemRepository) {
    @OptIn(ExperimentalUuidApi::class)
    fun execute(itemId: Uuid, name: ItemName?, description: ItemDescription?, price: ItemPrice?) {
        val item = repository.fetch(itemId) ?: throw IllegalArgumentException("Item not found")
        name?.let { item.name = it }
        description?.let { item.description = it }
        price?.let { item.price = it }
        repository.update(itemId, item)
    }
}
