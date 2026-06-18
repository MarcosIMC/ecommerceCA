package org.example.ecommerceca.item.infraestructure.config

import org.example.ecommerceca.item.application.usecase.CreateItemUseCase
import org.example.ecommerceca.item.application.usecase.ListItemUseCase
import org.example.ecommerceca.item.domain.ItemRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ItemUseCaseConfig {
    @Bean
    open fun listItemUseCase(repository: ItemRepository) = ListItemUseCase(repository)

    @Bean
    open fun createItemUseCase(repository: ItemRepository) = CreateItemUseCase(repository)
}