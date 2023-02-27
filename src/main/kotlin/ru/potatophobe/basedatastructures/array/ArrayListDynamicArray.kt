package ru.potatophobe.basedatastructures.array

class ArrayListDynamicArray<T> : DynamicArray<T> {
    override val size: Int get() = delegate.size

    private val delegate: ArrayList<T> = ArrayList()

    override fun add(index: Int, element: T) {
        delegate.add(index, element)
    }

    override fun set(index: Int, element: T) {
        delegate[index] = element
    }

    override fun get(index: Int): T {
        return delegate[index]
    }

    override fun removeAt(index: Int) {
        delegate.removeAt(index)
    }
}
