package org.example.ecommerceca.item.domain.valueobject

class ItemPrice {
    var price: Double

    constructor(price: Double) {
        if (price < 0) {
            throw IllegalArgumentException("Item price cannot be negative")
        }
        this.price = price
    }

    fun increase(newPrice: Double) {
        this.price += newPrice
    }

    fun decrease(newPrice: Double) {
        if (newPrice < 0) {
            throw IllegalArgumentException("Item price cannot be negative")
        }
        this.price -= newPrice
    }
}