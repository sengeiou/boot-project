<%--
  Created by IntelliJ IDEA.
  User: xuzongmeng
  Date: 2017/7/4
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<div class="container ">
       <%--标题--%>
    <div class="row">
    <div class=".col-md-12">
        <h1>SSM-CRUD</h1>
    </div>
    </div>
        <%--按钮--%>
    <div class="row">
        <%--<div class="col-md-4 col-md-offset-4">--%>
            <%--<button>新增</button>--%>
            <%--<button>删除</button>--%>
        <%--</div>--%>

        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary">新增</button>
            <button class="btn btn-danger">删除</button>
        </div>
    </div>
        <%--显示表格--%>
    <div class="row">
            <div class="col-md-12">
                    <table class="table table-hover">
                        <tr>
                            <th>#</th>
                            <th>empName</th>
                            <th>gender</th>
                            <th>deptName</th>
                            <th>操作</th>
                        </tr>


                        <c:forEach items="${pageInfo.list }" var="emp">
                            <tr>
                                <th>${emp.empId }</th>
                                <th>${emp.empName }</th>
                                <th>${emp.gender=="M"?"男":"女" }</th>
                                <th>${emp.email }</th>
                                <th>${emp.department.deptName }</th>
                                <th>
                                    <button class="btn btn-primary btn-sm">
                                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                        编辑
                                    </button>
                                    <button class="btn btn-danger btn-sm">
                                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                        删除
                                    </button>

                                    <a href="/emp/getEmpDetail">查看详情</a>
                                </th>
                            </tr>
                        </c:forEach>
                    </table>

            </div>
    </div>
           <%--显示分页--%>
    <div class="row">
        <%--分页文信息--%>
       <div class="col-md-6">
            当前${pageInfo.pageNum}页，总共${pageInfo.pages}页，总共${pageInfo.total}
       </div>
            <%--分页条信息--%>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="/emp/getEmp?pn=1"> 首页</a></li>

                    <c:if test="${pageInfo.hasPreviousPage}">
                    <li>
                        <a href="/emp/getEmp?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    </c:if>
                    <%--pageInfo.pageNum表示当前页码--%>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                        <c:if test="${page_Num==pageInfo.pageNum}">
                            <li class="active"><a href="#">${page_Num }</a></li>
                        </c:if>
                        <c:if test="${page_Num!=pageInfo.pageNum}">
                            <li class=""><a href="/emp/getEmp?pn=${page_Num }">${page_Num }</a></li>
                        </c:if>

                    </c:forEach>
                    <%--<li>--%>
                        <%--<a href="#" aria-label="Next">--%>
                            <%--<span aria-hidden="true">&raquo;</span>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="/emp/getEmp?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <li><a href="/emp/getEmp?pn=${pageInfo.pages}"> 末页</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
