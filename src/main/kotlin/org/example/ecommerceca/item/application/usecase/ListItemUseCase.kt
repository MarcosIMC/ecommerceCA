package org.example.ecommerceca.item.application.usecase

import org.example.ecommerceca.item.domain.ItemRepository
import org.example.ecommerceca.item.domain.model.Item
import kotlin.uuid.ExperimentalUuidApi

class ListItemUseCase(private val repository: ItemRepository) {
    @OptIn(ExperimentalUuidApi::class)
    fun execute(): List<Item> {
        return repository.findAll()
    }
}