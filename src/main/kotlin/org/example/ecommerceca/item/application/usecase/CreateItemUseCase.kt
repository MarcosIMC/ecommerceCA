package org.example.ecommerceca.item.application.usecase

import org.example.ecommerceca.item.domain.ItemRepository
import org.example.ecommerceca.item.domain.model.Item

class CreateItemUseCase(private val repository: ItemRepository) {
    fun execute(item: Item) {
        repository.save(item)
    }
}