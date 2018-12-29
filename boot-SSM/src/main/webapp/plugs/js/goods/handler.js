//存放主要交互逻辑的js代码
var phoneKey="phoneKey";
var handler = {

    //封装相关ajax的url
    URL: {
        goodsBuy: function (goodsId) {
            return '/goods/' + goodsId + '/buy';
        }
    },
    //详情页秒杀逻辑
    goods: {
        //详情页初始化
        init: function (params) {
            // $('#loginBtn').click(function () {
            //     handler.showDialog();
            // });
        }
    },
    //验证手机号
    checkPhone: function (phone) {
        //在cookie中查找手机号
        if (phone && phone.length == 11 && !isNaN(phone)) {
            return true;//直接判断对象会看对象是否为空,空就是undefine就是false; isNaN 非数字返回true
        } else {
            return false;
        }
    },

    /***
     * 购买判断电话 是否存在cook或者可用  可用不弹窗直接进入购买   不可用弹窗弹窗输入电话号码
     * @param goodsId
     */
    goodsBuy: function (goodsId) {
        //在cookie中查找手机号
        // var userPhone = $.cookie("userPhone");

         var userPhone = $.cookie(phoneKey);
        var isPhone = handler.checkPhone(userPhone);
        console.log("购买缓存电话===="+userPhone);
        console.log("购买电话===="+isPhone);

        if (!isPhone){
         handler.showDialog()
        }else {
           toBuy();
        }
        function toBuy() {
            //执行购买请求
            var goodBugUrl = handler.URL.goodsBuy(goodsId);
            console.log("购买地址=="+goodBugUrl);
            $.ajax({
                url: goodBugUrl,
                // data: serialize,
                type: "GET",
                success: function (result) {
                    if (result.success == true) {
                        console.log("购买成功==");
                    } else{
                        console.log("购买失败==");
                    }
                }
            });

        }

    },
    /**
     * 弹出对话框同时 监听输入框电话是否合法
     */
    showDialog: function () {
        var loginModal = $('#loginModal');
        loginModal.modal({
            show: true,//显示弹出层
            backdrop: 'static',//禁止位置关闭
            keyboard: false//关闭键盘事件
        });
        $("#btn_buy_submit").click(function () {
            handler.checkDialogInput();
        });
    },

    checkDialogInput:function () {
        var inputPhone = $('#userPhone').val();
        console.log("购买成功用户输入=="+inputPhone);
        if (handler.checkPhone(inputPhone)) {
            //电话写入cookie(7天过期)
              $.cookie(phoneKey, inputPhone, {expires: 7});
            // $.cookie("userPhone", inputPhone, {expires: 7});
            //验证通过　　刷新页面
            window.location.reload();
        } else {
            $('#userPhoneMessage').hide().html('<label class="label label-danger">手机号错误!</label>').show(300);
        }
    }

}