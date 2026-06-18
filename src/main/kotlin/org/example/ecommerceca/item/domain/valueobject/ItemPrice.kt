package org.example.ecommerceca.item.domain.valueobject

class ItemPrice {
    var price: Double

    constructor(price: Double) {
        if (price < 0) {
            throw IllegalArgumentException("Item price cannot be negative")
        }
        this.price = price
    }

    private fun applyDiscount(discount: Double) : Double {
        val newPrice = (this.price * discount) / 100

        if (newPrice < 0) {
            throw IllegalArgumentException("The new price cannot be negative")
        }
        return newPrice
    }
}