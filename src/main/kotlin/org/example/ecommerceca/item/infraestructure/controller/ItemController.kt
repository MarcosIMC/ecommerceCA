package org.example.ecommerceca.item.infraestructure.controller

import org.example.ecommerceca.item.application.usecase.CreateItemUseCase
import org.example.ecommerceca.item.application.usecase.ListItemUseCase
import org.example.ecommerceca.item.application.usecase.UpdateItemUseCase
import org.example.ecommerceca.item.infraestructure.controller.POJOs.ItemCreationDTO
import org.example.ecommerceca.item.infraestructure.controller.POJOs.ItemResponseDTO
import org.example.ecommerceca.item.infraestructure.controller.POJOs.Mapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@RestController
@RequestMapping("/items")
class ItemController(
    private val listUseCase: ListItemUseCase,
    private val createItemUseCase: CreateItemUseCase,
    private val updateItemUseCase: UpdateItemUseCase,
    private val mapper: Mapper
) {
    @OptIn(ExperimentalUuidApi::class)
    @GetMapping
    @ResponseBody
    fun get(): List<ItemResponseDTO> {
        return listUseCase.execute().stream().map { mapper.toDto(it) }.toList()
    }

    @PostMapping("/newItem")
    fun post(@RequestBody itemCreation: ItemCreationDTO) {
        return createItemUseCase.execute(mapper.toItem(itemCreation))
    }

    @OptIn(ExperimentalUuidApi::class)
    @PutMapping("/updateItem/{id}")
    fun put(@PathVariable id: Uuid, @RequestBody item: ItemCreationDTO) {
        val itemToUpdate = mapper.toItem(item)
        return updateItemUseCase.execute(id, itemToUpdate.name, itemToUpdate.description, itemToUpdate.price, )
    }
}