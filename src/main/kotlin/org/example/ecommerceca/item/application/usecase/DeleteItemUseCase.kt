package org.example.ecommerceca.item.application.usecase;

import org.example.ecommerceca.item.domain.ItemRepository
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class DeleteItemUseCase(private val repository: ItemRepository) {
    @OptIn(ExperimentalUuidApi::class)
    fun execute(itemId: Uuid) {
        repository.delete(itemId)
    }
}
