package org.example.ecommerceca.item.infraestructure.controller.POJOs

import org.example.ecommerceca.item.domain.model.Item
import org.example.ecommerceca.item.domain.valueobject.ItemDescription
import org.example.ecommerceca.item.domain.valueobject.ItemName
import org.example.ecommerceca.item.domain.valueobject.ItemPrice
import org.springframework.stereotype.Component
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Component
class Mapper {
    fun toDto(item: Item): ItemResponseDTO {
        return ItemResponseDTO(
            name = item.name.name,
            description = item.description.description,
            price = item.price.price
        )
    }

    /*@OptIn(ExperimentalUuidApi::class)
    fun toItem(itemDto: ItemResponseDTO): Item {
        return Item(
            id = Uuid.randomUUID(),
            name = ItemName(itemDto.name),
            description = ItemDescription(itemDto.description),
            price = ItemPrice(itemDto.price),
            stock = null!!
        )
    }*/
}