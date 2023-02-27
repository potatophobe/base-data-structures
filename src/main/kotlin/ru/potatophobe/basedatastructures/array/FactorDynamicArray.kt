package ru.potatophobe.basedatastructures.array

class FactorDynamicArray<T>(private val factor: Int = 2) : DynamicArray<T> {
    override var size: Int = 0

    private var array: Array<Any?> = Array(factor) {}

    override fun add(index: Int, element: T) {
        if (size == array.size) {
            array = array.copyOf(array.size * factor)
        }
        if (index < size) {
            array.moveRight(index, 1)
        }
        set(index, element)
        size++
    }

    override fun set(index: Int, element: T) {
        if (index > size) throw ArrayIndexOutOfBoundsException(index)
        array[index] = element
    }

    override fun get(index: Int): T {
        @Suppress("UNCHECKED_CAST")
        return array[index] as T
    }

    override fun removeAt(index: Int) {
        array.moveLeft(index + 1, 1)
        size--
    }
}
