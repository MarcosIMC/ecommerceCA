package org.example.ecommerceca.item.infraestructure.controller.POJOs

import kotlin.uuid.ExperimentalUuidApi

data class ItemUpdateDTO @OptIn(ExperimentalUuidApi::class) constructor(
    val name: String?,
    val description: String?,
    val price: Double?,
    val stock: Int?
)