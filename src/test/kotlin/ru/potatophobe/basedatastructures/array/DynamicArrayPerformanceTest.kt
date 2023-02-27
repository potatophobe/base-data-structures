package ru.potatophobe.basedatastructures.array

import org.junit.jupiter.api.Test
import org.junit.platform.commons.logging.LoggerFactory
import ru.potatophobe.basedatastructures.test.Timer

class DynamicArrayPerformanceTest {
    private val log = LoggerFactory.getLogger(DynamicArrayPerformanceTest::class.java)

    @Test
    fun add() {
        val arrayListDynamicArray = ArrayListDynamicArray<Int>()
        val factorDynamicArray = FactorDynamicArray<Int>()
        val vectorDynamicArray = VectorDynamicArray<Int>()
        val singleDynamicArray = SingleDynamicArray<Int>()

        var n = 10
        repeat(4) {
            n *= 10
            log.info { "############################ $n operations ############################" }
            Timer.measure { repeat(n) { arrayListDynamicArray.add(1) } }
                .also { log.info { "ArrayListDynamicArray - $it" } }
            Timer.measure { repeat(n) { factorDynamicArray.add(1) } }
                .also { log.info { "FactorDynamicArray - $it" } }
            Timer.measure { repeat(n) { vectorDynamicArray.add(1) } }
                .also { log.info { "VectorDynamicArray - $it" } }
            Timer.measure { repeat(n) { singleDynamicArray.add(1) } }
                .also { log.info { "SingleDynamicArray - $it" } }
        }
    }
}
