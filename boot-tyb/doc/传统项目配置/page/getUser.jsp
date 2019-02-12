<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>后台登录</title>
</head>
<%--<link rel="stylesheet" href="/asset/css/style.css"/>--%>
<script type="text/javascript" src="/plugs/js/jquery-1.7.2.js"></script>

<script>

$(function () {

    (function () {
        alert("获取用户信息被调用")
        getUserDate()
        function getUserDate() {
            $.ajax({
                type: "get", //jquey是不支持post方式跨域的
//                async: false,
                url: "/user/getOneUser", //跨域请求的URL
//                dataType: "json",
//                dataType: "jsonp",
                //传递给请求处理程序，用以获得jsonp回调函数名的参数名(默认为:callback)
//                jsonp: "jsoncallback",
                //自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
//                    jsonpCallback: "success_jsonpCallback",
                //成功获取跨域服务器上的json数据后,会动态执行这个callback函数
                success: function (json) {
//                        alert(json);
                    console.log("xxxxx===="+json.toString())
                    console.log("xxxxx"+json)

                }
            });
        }

    })();




})


</script>
<body>

<h2>获取用户信息成功</h2>





</body>
</html>
