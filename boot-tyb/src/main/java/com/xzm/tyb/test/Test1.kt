package com.xzm.tyb.test

import io.netty.util.internal.MathUtil
import java.math.BigDecimal
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

//import kotlin.coroutines.experimental.*
@ExperimentalContracts
open  class Test1 {

    open fun test1() { }
    fun test2() {  }
    // 在后台线程池中运行该代码
//    fun asyncOverlay() = async(CommonPool) {
//        // 启动两个异步操作
//        val original = asyncLoadImage("original")
//        val overlay = asyncLoadImage("overlay")
//        // 然后应用叠加到两个结果
//        applyOverlay(original.await(), overlay.await())
//    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            bar(null)
            bar("42")
        }

        fun bar(x: String?) {
//            if (!x.isNullOrEmpty()) {
//                println("length of '$x' is ${x.length}") // 哇，已经智能转换为非空！
//            }
//            for (x in 9 downTo 0 step 3) {
//                print(x)
//            }

            val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
            fruits.filter { it == "222" }
                    .sortedBy { it }
//                    .map { it.toUpperCase() }
                    .forEach { println(it) }
            loop@ for (i in 1..100) {
                // ……
            }


            loop@ for (i in 1..100) {
                for (j in 1..100) {
                }
            }

        }

        val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
        val isEmpty: Boolean get() = fruits.size == 0

//        fun main() {
//            bar(null)
//            bar("42")
//        }
    }
//    fun String?.isNullOrEmpty(): Boolean {
//        contract {
//            returns(false) implies (this@isNullOrEmpty != null)
//        }
//        return this == null || isEmpty()
//    }

}