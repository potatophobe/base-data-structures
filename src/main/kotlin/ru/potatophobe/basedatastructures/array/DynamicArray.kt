package ru.potatophobe.basedatastructures.array

interface DynamicArray<T> : Iterable<T> {
    val size: Int

    val indices get() = 0 until size

    fun isEmpty() = size == 0

    fun notEmpty() = !isEmpty()

    fun add(element: T) = add(size, element)

    fun add(index: Int, element: T)

    fun set(index: Int, element: T)

    fun get(index: Int): T

    fun removeAt(index: Int)

    override fun iterator() = DynamicArrayIterator(this)

    fun Array<Any?>.moveLeft(startIndex: Int, step: Int) {
        for (i in startIndex..lastIndex) {
            set(i - step, get(i))
            set(i, null)
        }
    }

    fun Array<Any?>.moveRight(startIndex: Int, step: Int) {
        for (i in lastIndex downTo startIndex) {
            set(i + step, get(i))
            set(i, null)
        }
    }
}

class DynamicArrayIterator<T>(private val dynamicArray: DynamicArray<T>) : Iterator<T> {
    private var currentIndex = 0

    override fun hasNext() = currentIndex < dynamicArray.size

    override fun next() = dynamicArray.get(currentIndex++)
}
