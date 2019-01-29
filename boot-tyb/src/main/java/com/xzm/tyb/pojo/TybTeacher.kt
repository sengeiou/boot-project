package com.xzm.tyb.pojo

import javax.persistence.Id
import java.util.Date

class TybTeacher {
    @Id
     var id: Int? = null
     var thumb: String? = null
     var teacherName: String? = null
     var dianZanCount: Int? = null
     var hdcgl: Float? = null
     var profit: Float? = null
     var genDanCount: String? = null
     var pinZhong: String? = null
     var cangWei: Float? = null
     var dianWei: Float? = null
     var shouYi: Float? = null
     var content: String? = null
     val createTime: Date? = null
     val updataTime: Date? = null


}