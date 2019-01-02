package com.xzm.modules.tyb.vo;


import com.xzm.modules.tyb.pojo.TybTeacher;

public class TybTeacherDetailVo  {
    private  TeacherDetail object;

    public TeacherDetail getObject() {
        return object;
    }

    public void setObject(TeacherDetail object) {
        this.object = object;
    }

    public  static  class   TeacherDetail extends TybTeacher {
        private  int status;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }

}
