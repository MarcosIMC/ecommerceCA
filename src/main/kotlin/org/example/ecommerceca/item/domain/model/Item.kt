package org.example.ecommerceca.item.domain.model

import org.example.ecommerceca.item.domain.valueobject.ItemDescription
import org.example.ecommerceca.item.domain.valueobject.ItemName
import org.example.ecommerceca.item.domain.valueobject.ItemPrice
import org.example.ecommerceca.item.domain.valueobject.ItemStock
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class Item @OptIn(ExperimentalUuidApi::class) constructor(
    val id: Uuid,
    var name: ItemName,
    var description: ItemDescription,
    var price: ItemPrice,
    val stock: ItemStock,
) {

}
