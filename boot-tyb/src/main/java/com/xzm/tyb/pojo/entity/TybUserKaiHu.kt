package com.xzm.tyb.pojo.entity

import com.xzm.tyb.utils.identity
import java.util.*

//@Data
class TybUserKaiHu {
    var id: Long =  0;
//    var id: Long = identity.nextId()

    var userName: String? = null

    var idCard: String? = null

    var phone: String? = null

    var platformCode: String? = null

    var platformName: String? = null

    var createTime: Date? = null

    var updataTime: Date? = null

}