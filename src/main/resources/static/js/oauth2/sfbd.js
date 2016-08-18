$(document).ready(function(){
    $("#btn_dx").on("click",function(){
        //发送短信
        var params = {'sjhm':$("#sjhm").val()};
        $.get("/mass",params);
        //倒计时
        settime(this);
    });

    $("#btn_submit").on("click",function(){
        var r = vali();
        if (!r) {
            return;
        }

        var params = {
            'openid':$("#openid").val(),
            'sfzh':$("#sfzh").val(),
            'sjhm':$("#sjhm").val(),
            'dx':$("#dx").val(),
            'xm':$("#xm").val()
        };

        $.ajax({
            url: '/dxyz',
            type: 'POST',
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(params),
            success: function(res) {
                if (res.code == 'success') {
                    //转向成功页面
                    $.toptip("恭喜!身份绑定成功!",2000,'success');
                    location.href = "show_bdxx?openid="+res.openid;
                }else{
                    $.alert(res.result,"通知");
                }
            },
            before:function () {
                $.dialog.showLoading();
            },
            complete: function () {
                $.dialog.hideLoading();
            }
        });

    });

});



var countdown=60;
function settime(val) {
    if (countdown == 0) {
        val.removeAttribute("disabled");
        val.value="免费获取验证码";
        countdown = 60;
        return;
    } else {
        val.setAttribute("disabled", true);
        val.value="重新发送(" + countdown + ")";
        countdown--;
    }
    setTimeout(function() {
        settime(val)
    },1000)
}



function  vali(){

    var r = $("#from1").validate({
        rules: {
            dx: {
                required: true,
                minlength: 6
            }
        },
        messages: {
            dx: {
                required: "请输入6位短信验证码",
                minlength: "验证码不小于6位",
                maxlength:"验证码不大于6位"

            }
        },
        errorPlacement:function(error,element){
            error.appendTo(element.parent().next());
        }
    }).form();

    return r;

}





