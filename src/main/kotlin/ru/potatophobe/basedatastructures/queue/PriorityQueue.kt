package ru.potatophobe.basedatastructures.queue

interface PriorityQueue<T> : Queue<T> {

    override fun enqueue(element: T) = enqueue(DEFAULT_PRIORITY, element)

    fun enqueue(priority: Int, element: T)

    companion object {
        const val DEFAULT_PRIORITY = 0
    }
}
