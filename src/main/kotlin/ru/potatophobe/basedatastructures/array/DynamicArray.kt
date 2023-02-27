package ru.potatophobe.basedatastructures.array

interface DynamicArray<T> {
    val size: Int

    fun add(element: T) = add(size, element)

    fun add(index: Int, element: T)

    fun set(index: Int, element: T)

    fun get(index: Int): T

    fun removeAt(index: Int)

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
