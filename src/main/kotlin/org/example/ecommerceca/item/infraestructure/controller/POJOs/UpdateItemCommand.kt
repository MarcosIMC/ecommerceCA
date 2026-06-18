package org.example.ecommerceca.item.infraestructure.controller.POJOs

import org.example.ecommerceca.item.domain.valueobject.ItemDescription
import org.example.ecommerceca.item.domain.valueobject.ItemName
import org.example.ecommerceca.item.domain.valueobject.ItemPrice
import org.example.ecommerceca.item.domain.valueobject.ItemStock

data class UpdateItemCommand(
    val name: ItemName?,
    val description: ItemDescription?,
    val price: ItemPrice?,
    val stock: ItemStock?,
)
