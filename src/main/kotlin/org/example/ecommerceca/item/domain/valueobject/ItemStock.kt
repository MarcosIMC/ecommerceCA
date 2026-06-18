package org.example.ecommerceca.item.domain.valueobject

class ItemStock {
    var stock: Int

    constructor(stock: Int) {
        if (stock < 0) {
            throw IllegalArgumentException("Item stock cannot be negative")
        }
        this.stock = stock
    }

    fun increase() {
        this.stock++
    }

    fun decrease() {
        if (this.stock == 0) {
            throw IllegalArgumentException("Item stock cannot be negative")
        }
        this.stock--
    }

    fun newStock(newStock: Int) {
        if (newStock < 0) {
            throw IllegalArgumentException("Item stock cannot be negative")
        }
        this.stock = newStock
    }
}