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
            stock = item.stock.stock
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
    fun toUpdateItemCommand(itemUpdateDTO: ItemUpdateDTO): UpdateItemCommand {
        return UpdateItemCommand(
            name = itemUpdateDTO.name?.let { ItemName(it) },
            description = itemUpdateDTO.description?.let { ItemDescription(it) },
            price = itemUpdateDTO.price?.let { ItemPrice(it) },
            stock = itemUpdateDTO.stock?.let { ItemStock(it) }
        )
    }
}