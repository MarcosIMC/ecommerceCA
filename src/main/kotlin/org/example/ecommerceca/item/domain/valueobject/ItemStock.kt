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
        this.stock--
    }

    fun newStock(newStock: Int) {
        this.stock = newStock
    }
}