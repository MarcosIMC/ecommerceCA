package org.example.ecommerceca.item.domain.valueobject

class ItemDescription {
    val description: String

    constructor(description: String) {
        if (description.isBlank()) {
            throw IllegalArgumentException("Item description cannot be blank")
        }
        this.description = description
    }
}