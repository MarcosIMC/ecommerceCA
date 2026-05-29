package org.example.ecommerceca.item.infraestructure.controller

import org.example.ecommerceca.item.domain.ItemRepository
import org.example.ecommerceca.item.domain.model.Item
import org.example.ecommerceca.item.infraestructure.controller.POJOs.Mapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@RestController
@RequestMapping("/items")
class ItemController() {//Mirar el mapper y el DI

    @OptIn(ExperimentalUuidApi::class)
    @GetMapping("/items/{id}")
    @ResponseBody
    fun get(@PathVariable("id") id: Uuid): Item {

    }
}