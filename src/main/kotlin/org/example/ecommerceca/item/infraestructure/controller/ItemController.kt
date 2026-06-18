package org.example.ecommerceca.item.infraestructure.controller

import org.example.ecommerceca.item.application.usecase.CreateItemUseCase
import org.example.ecommerceca.item.application.usecase.DeleteItemUseCase
import org.example.ecommerceca.item.application.usecase.ListItemUseCase
import org.example.ecommerceca.item.application.usecase.UpdateItemUseCase
import org.example.ecommerceca.item.infraestructure.controller.POJOs.ItemCreationDTO
import org.example.ecommerceca.item.infraestructure.controller.POJOs.ItemResponseDTO
import org.example.ecommerceca.item.infraestructure.controller.POJOs.ItemUpdateDTO
import org.example.ecommerceca.item.infraestructure.controller.POJOs.Mapper
import org.springframework.web.bind.annotation.DeleteMapping
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
    private val deleteItemUseCase: DeleteItemUseCase,
    private val mapper: Mapper
) {
    @OptIn(ExperimentalUuidApi::class)
    @GetMapping
    @ResponseBody
    fun get(): List<ItemResponseDTO> {
        return listUseCase.execute().stream().map { mapper.toDto(it) }.toList()
    }

    @PostMapping()
    fun post(@RequestBody itemCreation: ItemCreationDTO) {
        return createItemUseCase.execute(mapper.toItem(itemCreation))
    }

    @OptIn(ExperimentalUuidApi::class)
    @PutMapping("/{id}")
    fun put(@PathVariable id: String, @RequestBody item: ItemUpdateDTO) {
        val uuid = Uuid.parse(id)
        val itemToUpdate = mapper.toUpdateItemCommand(item)
        return updateItemUseCase.execute(uuid, itemToUpdate)
    }

    @OptIn(ExperimentalUuidApi::class)
    @DeleteMapping("{id}")
    fun delete(@PathVariable id: String) {
        val uuid = Uuid.parse(id)
        return deleteItemUseCase.execute(uuid)
    }
}