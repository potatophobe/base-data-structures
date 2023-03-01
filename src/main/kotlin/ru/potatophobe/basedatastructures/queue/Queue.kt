package ru.potatophobe.basedatastructures.queue

interface Queue<T> {

    fun enqueue(element: T)

    fun hasNext(): Boolean

    fun dequeue(): T
}
