package org.example.ecommerceca.item.domain.valueobject

class ItemName {
    val name: String

    constructor(name: String) {
        if (name.isBlank()) {
            throw IllegalArgumentException("Item name cannot be blank")
        }
        this.name = name
    }
}