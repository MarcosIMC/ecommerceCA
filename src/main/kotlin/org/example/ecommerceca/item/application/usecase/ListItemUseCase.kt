package org.example.ecommerceca.item.application.usecase

import org.example.ecommerceca.item.domain.ItemRepository

class ListItemUseCase(private val repository: ItemRepository) {
    fun execute(): List<ItemDTO> {
        return repository.findAll().map { item ->
            ItemDTO(
                id = item.id.toString(),
                name = item.name.name,
                description = item.description.description,
                price = item.price.amount
            )
        }
    }
}