<%--
  Created by IntelliJ IDEA.
  User: xuzongmeng
  Date: 2017/7/5
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<html>
<head>
    <title>员工列表</title>
    <script type="text/javascript" src="/static/js/jquery-1.12.4.min.js"></script>
    <link href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <style>
        /*div{*/
        /*border: 1px solid red;*/
        /*}*/
    </style>
</head>
<body>

<!-- 添加员工模态框（Modal） -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加员工信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="empName_add_input" class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <input type="text" name="empName" class="form-control" id="empName_add_input"
                                   placeholder="empName(请输入员工姓名)">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_add_input" class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="text" name="email" class="form-control" id="email_add_input"
                                   placeholder="email(请输入员工邮箱)">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1_add_input" value="M" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2_add_input" value="F"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">
                            <!-- 部门提交部门id即可 -->
                            <select class="form-control" name="dId" id="dept_add_select">
                                <%--<option>软件部</option>--%>
                                <%--<option>测试部</option>--%>
                            </select>
                        </div>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- 编辑员工模态框（Modal） -->
<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">员工修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="empName_add_input" class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <%--<input type="text" name="empName" class="form-control" id="empName_update_input"--%>
                                   <%--placeholder="empName(请输入员工姓名)">--%>
                            <%--<span class="help-block"></span>--%>
                                <p class="form-control-static" id="empName_update_static"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_add_input" class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="text" name="email" class="form-control" id="email_update_input"
                                   placeholder="email(请输入员工邮箱)">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1_update_input" value="M" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2_update_input" value="F"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">
                            <!-- 部门提交部门id即可 -->
                            <select class="form-control" name="dId" id="dept_update_select">
                                <%--<option>软件部</option>--%>
                                <%--<option>测试部</option>--%>
                            </select>
                        </div>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<div class="container ">
    <%--标题--%>
    <div class="row">
        <div class=".col-md-12">
            <h1>SSM-CRUD</h1>
        </div>
    </div>
    <%--按钮--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary" id="emp_add_modal_btn">新增</button>
            <button class="btn btn-danger" id="emp_delete_all_btn">删除</button>
        </div>
    </div>
    <%--显示表格--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>deptName</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>

        </div>
    </div>
    <%--显示分页--%>
    <div class="row">
        <%--分页文信息--%>
        <div class="col-md-6" id="page_info_area">
            <%--当前${pageInfo.pageNum}页，总共${pageInfo.pages}页，总共${pageInfo.total}--%>
        </div>
        <%--分页条信息--%>
        <div class="col-md-6" id="page_nav_area">

        </div>
    </div>
</div>

<script>
    var totalRecord;

    $(function () {
        to_page(1)
    });


    function to_page(pn) {
//        alert("传递"+pn)

        $.ajax({
            url: "/emp/emps",
            data: "pn=" + pn,
            type: "GET",
            success: function (result) {
//                console.log("==" + result)
                //1、解析并显示员工数据
                build_emps_table(result);
                //2、解析并显示分页信息
                build_page_info(result);
                //3、解析显示分页条数据
                build_page_nav(result);
            }
        });
    }
    function build_emps_table(result) {
        //清空数据
        $("#emps_table tbody").empty();//jQuery掏空元素滴方法
        var emps = result.extend.pageInfo.list;
        //遍历集合  jQuery提供
        $.each(emps, function (index, item) {
//            var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
            var empIdTd = $("<td></td>").append(item.empId);
            var empNameTd = $("<td></td>").append(item.empName);
            var genderTd = $("<td></td>").append(item.gender == 'M' ? "男" : "女");
            var emailTd = $("<td></td>").append(item.email);
            var deptNameTd = $("<td></td>").append(item.department.deptName);
            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm  edit_btn").append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("编辑");
            //未编辑按钮添加一个自定义属性 来表示当前员工ID
            editBtn.attr("edit-id",item.empId);
            var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn").append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
            var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
            //$("#emps_table tbody")和#emps_table tbody效果一样
            $("<tr></tr>").append(empIdTd).append(empNameTd).append(genderTd).append(emailTd).append(deptNameTd).append(btnTd)
                .appendTo($("#emps_table tbody"));

        });

    }

    function build_page_info(result) {
        <%--当前${pageInfo.pageNum}页，总共${pageInfo.pages}页，总共${pageInfo.total}--%>
        $("#page_info_area").empty();
        $("#page_info_area").append("当前" + result.extend.pageInfo.pageNum + "页，" + "总共" + result.extend.pageInfo.pages + "页，"
            + "共" + result.extend.pageInfo.total + "记录");
        totalRecord = result.extend.pageInfo.total;
    }

    function build_page_nav(result) {
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));


        if (result.extend.pageInfo.hasPreviousPage == false) {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        } else {
            //为元素添加点击翻页的事件
            firstPageLi.click(function () {
                to_page(1);
            });
            prePageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum - 1);
            });
        }

//
//        //为元素添加翻页事件
//        firstPageLi.click(function () {
//            to_page(1)
//        });
//        prePageLi.click(function () {
//            to_page(result.extend.pageInfo.pageNum-1)
//        });

        if (result.extend.pageInfo.hasPreviousPage == false) {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled")
        }

        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));

        if (result.extend.pageInfo.hasNextPage == false) {
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        } else {
            nextPageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum + 1);
            });
            lastPageLi.click(function () {
                to_page(result.extend.pageInfo.pages);
            });
        }


//        //为元素添加翻页事件
//        nextPageLi.click(function () {
//            to_page(result.extend.pageInfo.pageNum+1)
//        });
//        lastPageLi.click(function () {
//            to_page(result.extend.pageInfo.pages)
//        });
//
//        if (result.extend.pageInfo.hasNextPage==false){
//            nextPageLi.addClass("disabled");
//            lastPageLi.addClass("disabled")
//        }


        //添加首页和前一页
        ul.append(firstPageLi).append(prePageLi);
        $.each(result.extend.pageInfo.navigatepageNums, function (index, item) {

            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if (result.extend.pageInfo.pageNum == item) {
                numLi.addClass("active");
            }
            numLi.click(function () {

//                alert("==item"+item+",index="+index)
                to_page(item);
            });
            ul.append(numLi);
        });
        //添加下一页和末页
        ul.append(nextPageLi).append(lastPageLi);

//        nav aria-label="Page navigation
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo($("#page_nav_area"));
    }


  //重置表单
    function  reset_from(ele) {
        ele[0].reset();//情况清空表达样式
        ele.find("*").removeClass("has-succes has-error");//找到所有
        ele.find($(".help-block").text(""));
    }

    $("#emp_add_modal_btn").click(function () {
        getDepts($("#empAddModal select"));

      reset_from($("#empAddModal form"));
        $("#empAddModal").modal({

            backdrop: "static"
        });
    });

    //获取部门信息
    function getDepts(ele) {
            //清空下拉列表滴数据
        $(ele).empty();

        $.ajax({
            url: "/depts",
//            data:"pn="+pn,
            type: "GET",
            success: function (result) {
//                console.log("==部门信息" + result)

                $("#empAddModal select").append($(""))
                $.each(result.extend.depts, function () {
                    //this关键字代表当前正在遍历的部门对象
                    var optionEle = $("<option></option>").append(this.deptName).attr("value", this.deptId);
                    optionEle.appendTo(ele);   ///效果一样
//                    $("#empAddModal select").append(optionEle)
                });
            }
        });
    }


    function validate_add_form() {
        var empName = $("#empName_add_input").val();
        var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
//        alert(regName.test(empName)) ;
        if (!regName.test(empName)) {

            show_validate_msg($("#empName_add_input"),"error","用户名输入不合法");
            return false
        } else {
            show_validate_msg($("#empName_add_input"),"success","用户名验证通过");
        }

        var email = $("#email_add_input").val();
        var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if (!regEmail.test(email)) {
//            $("#email_add_input").parent().addClass("has-error");
//            $("#email_add_input").next("span").text("邮箱输入不合法");
            show_validate_msg($("#email_add_input"),"error","邮箱输入不合法");
            return false
        } else {
//            $("#email_add_input").parent().addClass("has-succes");
//            $("#email_add_input").next("span").text("邮箱格式验证通过");
            show_validate_msg($("#email_add_input"),"success","邮箱格式验证通过");
        }
        return true
    }
    /*当输入框发生改变滴时间监听*/
    $("#empName_add_input").change(function () {
//        alert("===回");
        var empName = this.val;
        $.ajax({
            url: "/emp/checkuser",
            data: "empName="+empName,
            type: "POST",
            success: function (result) {
//                $("#empAddModal").modal("hide");
//                to_page(totalRecord)
//              alert("=="+result.code)
//                console.log("==="+result);
                if (result.code==100){
                 show_validate_msg( $("#empName_add_input"),"success","用户名验证通过");
                 $("#emp_save_btn").attr("ajax-va","success");
                }else {
                    show_validate_msg( $("#empName_add_input"),"error",result.extend.va_msg);
                    $("#emp_save_btn").attr("ajax-va","error");
                }
            }
        });
    });
    
    
    $("#emp_save_btn").click(function () {
        var serialize = $("#empAddModal form ").serialize();

        alert("======"+serialize);
        if (!validate_add_form()){
//            alert("不通过")
            return false;
        }

//        var va = $(this).attr("ajax-va");
//        if(va=="error"){
//            return;
//        }
//1、判断之前的ajax用户名校验是否成功。如果成功。
        if($(this).attr("ajax-va")=="error"){
            return false;
        }

        $.ajax({
            url: "/emp/emp",
            data: serialize,
            type: "POST",
            success: function (result) {

                if (result.code == 100) {
                    $("#empAddModal").modal("hide");
                    to_page(totalRecord)
                } else{
                    //显示失败信息
                    //console.log(result);
                    //有哪个字段的错误信息就显示哪个字段的；
                    if(undefined != result.extend.errorFields.email){
                        //显示邮箱错误信息
                        show_validate_msg("#email_add_input", "error", result.extend.errorFields.email);
                    }
                    if(undefined != result.extend.errorFields.empName){
                        //显示员工名字的错误信息
                        show_validate_msg("#empName_add_input", "error", result.extend.errorFields.empName);
                    }
                }
            }
        });
    });


    function show_validate_msg(e, status, msg) {
        //之前应该清除元素滴状态  及class属性
        e.parent().removeClass("has-succes has-error");
        e.next("span").text("");
        if ("success" == status) {
            e.parent().addClass("has-succes");
            e.next("span").text(msg);
        } else if ("error" == status) {
            e.parent().addClass("has-error");
            e.next("span").text(msg);
        }
    }


  //这样注册监听会不成功  因为按钮是请求完数据之后才有滴
//    $(".edit_btn").click(function () {
//        alert("===");
//    });

    //1、我们是按钮创建之前就绑定了click，所以绑定不上。
    //1）、可以在创建按钮的时候绑定。    2）、绑定点击.live()
    //jquery新版没有live，使用on进行替代
    $(document).on("click",".edit_btn",function(){
//       alert("edit");


        //1、查出部门信息，并显示部门列表
        getDepts("#empUpdateModal select");
        //2、查出员工信息，显示员工信息
      getEmp($(this).attr("edit-id"));

        //3、把员工的id传递给模态框的更新按钮
        $("#emp_update_btn").attr("edit-id",$(this).attr("edit-id"));
        $("#empUpdateModal").modal({
            backdrop:"static"
        });
    });

    //获取员工信息
    function getEmp(id){
        $.ajax({
            url:"${APP_PATH}/emp/emp/"+id,
            type:"GET",
            success:function(result){
                //console.log(result);
                var empData = result.extend.emp;
                $("#empName_update_static").text(empData.empName);
                $("#email_update_input").val(empData.email);
                $("#empUpdateModal input[name=gender]").val([empData.gender]);
                $("#empUpdateModal select").val([empData.dId]);
            }
        });
    }
</script>
</body>
</html>
