$(document).ready(function () {
    $("#btn_submit").on("click", function () {
        var r = vali();
        if (!r) {
            return;
        }

        var openid = $("#openid").val();
        var sfzh = $("#sfzh").val();
        var xm = $("#xm").val();

        var params = {
            'openid': openid,
            'sfzh': sfzh,
            'xm': xm
        };
        $.ajax({
            url: '/sfyz',
            type: 'POST',
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(params),
            success: function (res) {
                if (res.code == 'success') {
                    $.toptip("验证成功,下一步!",2000,'success');
                    location.href = "sfbd?openid=" + openid + "&sfzh=" + sfzh + "&sjhm=" + res.sjhm + "&xm=" + xm;
                } else {
                    $.alert(res.result,"通知");
                }
            },
            before: function () {
                $.showLoading();
            },
            complete: function () {
                $.hideLoading();
            }
        });
    });
});

function vali() {

    var r = $("#from1").validate({
        rules: {
            xm: {
                required: true,
            },
            sfzh: {
                required: true,
                minlength: 18
            }
        },
        messages: {
            xm: {
                required: "请输入姓名",
            },
            sfzh: {
                required: "请输入身份证号码",
                minlength: "身份证号码不能小于18位"
            }
        }
    }).form();

    return r;

}








