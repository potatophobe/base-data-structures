package ru.potatophobe.basedatastructures.queue

import ru.potatophobe.basedatastructures.array.FactorDynamicArray

class FactorPriorityQueue<T>(private val factor: Int = 2) : PriorityQueue<T> {
    private val priorityQueue: FactorDynamicArray<Pair<Int, Queue<T>>> = FactorDynamicArray(factor)

    override fun enqueue(priority: Int, element: T) {
        if (priorityQueue.isEmpty()) addToEnd(priority, element)
        else {
            var added = false
            for (i in priorityQueue.indices) {
                val (queuePriority, queue) = priorityQueue.get(i)

                if (priority == queuePriority) {
                    queue.enqueue(element)
                    added = true
                    break
                } else if (priority < queuePriority) {
                    addToIndex(i, priority, element)
                    added = true
                    break
                }
            }
            if (!added) addToEnd(priority, element)
        }
    }

    override fun hasNext(): Boolean {
        return priorityQueue.notEmpty()
    }

    override fun dequeue(): T {
        val queue = priorityQueue.get(priorityQueue.indices.last).second
        val poll = queue.dequeue()
        if (!queue.hasNext()) {
            priorityQueue.removeAt(priorityQueue.indices.last)
        }
        return poll
    }

    private fun addToIndex(index: Int, priority: Int, element: T) {
        priorityQueue.add(index, priority to FactorQueue<T>(factor).apply { enqueue(element) })
    }

    private fun addToEnd(priority: Int, element: T) {
        priorityQueue.add(priority to FactorQueue<T>(factor).apply { enqueue(element) })
    }
}
