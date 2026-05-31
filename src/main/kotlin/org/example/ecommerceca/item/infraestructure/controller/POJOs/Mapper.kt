package org.example.ecommerceca.item.infraestructure.controller.POJOs

import org.example.ecommerceca.item.domain.model.Item
import org.springframework.stereotype.Component
import kotlin.uuid.ExperimentalUuidApi

@Component
class Mapper {
    @OptIn(ExperimentalUuidApi::class)
    fun toDto(item: Item): ItemResponseDTO {
        return ItemResponseDTO(
            id = item.id,
            name = item.name.name,
            description = item.description.description,
            price = item.price.price,
        )
    }

    @OptIn(ExperimentalUuidApi::class)
    fun toItem(itemCreationDTO: ItemCreationDTO): Item {
        return Item(
            id = itemCreationDTO.id,
            name = itemCreationDTO.name,
            description = itemCreationDTO.description,
            price = itemCreationDTO.price,
            stock = itemCreationDTO.stock
        )
    }
}