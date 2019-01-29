@file:JvmName("IdUtils")

package com.xzm.tyb.utils

import java.security.SecureRandom
import java.util.*

/**
 * Created with IntelliJ IDEA.
 * Description: 分布式ID生成
 * User: Cuiyalei
 * Date: 2018-07-24
 * Time: 13:30
 */
class Identity(private val machineCode: Int, initDate: Date = "2018-08-01".parse("yyyy-MM-dd")) {
    private val timeMillis: Long

    init {
        if (machineCode > 63) {
            throw RuntimeException("machineCode max value 63")
        }
        timeMillis = initDate.time
    }

    companion object {
        /**
         * 修改预留数据库号0-16
         */
        fun modifyDatabaseCode(id:Long,code: Int):Long {
            if (code > 15) {
                throw RuntimeException("machineCode max value 15")
            }
            return id shr 4 shl 4 or code.toLong()
        }

        /**
         * 获取数据库号0-16
         */
        fun databaseCode(id:Long):Int{
            return (id and 15).toInt()
        }
    }


    private var lastId: Long = 0
    /**
     * 前42位max:‭4398046511103‬时间戳最大可用139年
     * 12位增加并发最大4096/ms
     * 6位机器号最大64/台
     * 4位预留数据库号16/台
     */
    @Synchronized
    fun nextId(): Long {
        val current = System.currentTimeMillis() - timeMillis
        var count = 0
        if (current == lastId shr 22) {
            val temp = (lastId shr 10 and 4095).toInt()
            if (temp >= 4095) {
                Thread.sleep(1)
                return nextId()
            }
            count = temp + 1
        }
        lastId = current shl 12 or count.toLong() shl 6 or machineCode.toLong() shl 4 or 0
        return lastId
    }
}

private val numberGenerator = SecureRandom()
fun uuid(): String {
    val randomBytes = ByteArray(16)
    numberGenerator.nextBytes(randomBytes)
    return randomBytes.hex()!!
}