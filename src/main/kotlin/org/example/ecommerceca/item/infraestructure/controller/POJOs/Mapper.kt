package org.example.ecommerceca.item.infraestructure.controller.POJOs

import org.example.ecommerceca.item.domain.model.Item
import org.example.ecommerceca.item.domain.valueobject.ItemDescription
import org.example.ecommerceca.item.domain.valueobject.ItemName
import org.example.ecommerceca.item.domain.valueobject.ItemPrice
import org.example.ecommerceca.item.domain.valueobject.ItemStock
import org.springframework.stereotype.Component
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Component
class Mapper {
    @OptIn(ExperimentalUuidApi::class)
    fun toDto(item: Item): ItemResponseDTO {
        return ItemResponseDTO(
            id = item.id.toString(),
            name = item.name.name,
            description = item.description.description,
            price = item.price.price,
        )
    }

    @OptIn(ExperimentalUuidApi::class)
    fun toItem(itemCreationDTO: ItemCreationDTO): Item {
        return Item(
            id = Uuid.random(),
            name = ItemName(itemCreationDTO.name),
            description = ItemDescription(itemCreationDTO.description),
            price = ItemPrice(itemCreationDTO.price),
            stock = ItemStock(itemCreationDTO.stock)
        )
    }
    
    @OptIn(ExperimentalUuidApi::class)
    fun toUpdateItem(id: Uuid, itemUpdateDTO: ItemUpdateDTO): Item {
        return Item(
            id = id,
            name = ItemName(itemUpdateDTO.name),
            description = ItemDescription(itemUpdateDTO.description),
            price = ItemPrice(itemUpdateDTO.price),
            stock = ItemStock(itemUpdateDTO.stock),
        )
    }
}