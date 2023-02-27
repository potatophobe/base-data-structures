package ru.potatophobe.basedatastructures.array

class SingleDynamicArray<T> : DynamicArray<T> {
    override val size: Int get() = array.size

    private var array: Array<Any?> = Array(0) {}

    override fun add(index: Int, element: T) {
        array = array.copyOf(array.size + 1)
        if (index < array.lastIndex) {
            array.moveRight(index, 1)
        }
        set(index, element)
    }

    override fun set(index: Int, element: T) {
        array[index] = element
    }

    override fun get(index: Int): T {
        @Suppress("UNCHECKED_CAST")
        return array[index] as T
    }

    override fun removeAt(index: Int) {
        array.moveLeft(index + 1, 1)
        array = array.copyOf(array.size - 1)
    }
}
