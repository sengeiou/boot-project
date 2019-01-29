package com.xzm.tyb.pojo.entity

import com.xzm.tyb.utils.identity
import java.util.Date

//@Data
class TybUser {
    var id: Long? = 0
//    var id: Long = identity.nextId()
    var nickName: String? = null

    var phone: String? = null

    var password: String? = null

    var phoneUrl: String? = null

    var pushStatus: Int? = null

    var createTime: Date? = null

    var updataTime: Date? = null

}