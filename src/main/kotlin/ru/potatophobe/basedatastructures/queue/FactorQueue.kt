package ru.potatophobe.basedatastructures.queue

import ru.potatophobe.basedatastructures.array.FactorDynamicArray

class FactorQueue<T>(factor: Int = 2) : Queue<T> {
    private val queue: FactorDynamicArray<T> = FactorDynamicArray(factor)

    override fun enqueue(element: T) {
        queue.add(element)
    }

    override fun hasNext(): Boolean {
        return queue.notEmpty()
    }

    override fun dequeue(): T {
        val element = queue.get(0)
        queue.removeAt(0)
        return element
    }
}
