package org.example.ecommerceca.item.application.usecase;

import org.example.ecommerceca.item.domain.ItemRepository
import org.example.ecommerceca.item.domain.valueobject.ItemDescription
import org.example.ecommerceca.item.domain.valueobject.ItemName
import org.example.ecommerceca.item.domain.valueobject.ItemPrice
import org.example.ecommerceca.item.infraestructure.controller.POJOs.UpdateItemCommand
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class UpdateItemUseCase(private val repository: ItemRepository) {
    @OptIn(ExperimentalUuidApi::class)
    fun execute(itemId: Uuid, itemCommand: UpdateItemCommand) {
        val item = repository.fetch(itemId) ?: throw IllegalArgumentException("Item not found")
        itemCommand.name?.let { item.rename(it) }
        itemCommand.description?.let { item.changeDescription(it) }
        itemCommand.price?.let { item.changePrice(it) }
        itemCommand.stock?.let { item.changeStock(it) }
        repository.update(itemId, item)
    }
}
