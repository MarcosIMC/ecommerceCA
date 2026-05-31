package org.example.ecommerceca.item.application.usecase

import org.example.ecommerceca.item.domain.ItemRepository
import org.example.ecommerceca.item.domain.model.Item
import org.example.ecommerceca.item.infraestructure.controller.POJOs.ItemResponseDTO
import org.springframework.stereotype.Service
import kotlin.uuid.ExperimentalUuidApi

@Service
class ListItemUseCase(private val repository: ItemRepository) {
    @OptIn(ExperimentalUuidApi::class)
    fun execute(): List<Item> {
        return repository.findAll()
    }
}