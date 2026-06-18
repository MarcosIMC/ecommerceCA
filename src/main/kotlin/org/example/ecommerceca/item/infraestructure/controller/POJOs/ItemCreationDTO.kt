package org.example.ecommerceca.item.infraestructure.controller.POJOs

import kotlin.uuid.ExperimentalUuidApi

data class ItemCreationDTO @OptIn(ExperimentalUuidApi::class) constructor(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val stock: Int
)