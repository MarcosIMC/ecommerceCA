package org.example.ecommerceca.item.infraestructure.controller.POJOs

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

data class ItemResponseDTO @OptIn(ExperimentalUuidApi::class) constructor(
    val id: Uuid,
    val name: String,
    val description: String,
    val price: Double
)
