package com.xzm.tyb.pojo.entity
import com.xzm.tyb.utils.identity
import java.util.Date
open class TybLiveTop {

//    @JvmStatic
//    fun main(args: Array<String>) {
//
//        //        identit
//        println(uuid)
//    }
//     var id: Long = identity.nextId()
    var id: Long = 0

    var title: String? = null

    var liveUrl: String? = null

    var dianZanCount: Int? = null

    var adText: String? = null

    var adUrl: String? = null

    var onlineCount: Int? = null

    var handanRate: Float? = null

    var yingLi: Float? = null

    var mainImg: String? = null

    var subImg: String? = null

    var createTime: Date? = null

    var updataTime: Date? = null


}