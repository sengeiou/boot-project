package com.xzm.tyb.pojo

import javax.persistence.Id
import java.io.Serializable
import java.util.Date

//@Table(name = "sys_role")
class TybImportantMessage : Serializable {

    @Id
    var id: Long? = null

    var time: Date? = null

    var autoid: String? = null

    var prevalue: String? = null

    var day: String? = null

    var name: String? = null

    var importence: String? = null

    var question: String? = null

    var annvalue: String? = null

    var imageurl: String? = null

    var goodpers: Int? = null

    var badpers: Int? = null

    var createTime: Date? = null

    var updataTime: Date? = null


    constructor(id: Long?) {
        this.id = id
    }


}