$(document).ready(function () {
    var openid = $("#openid").val();
    var params = {
        'openid': openid
    };

    // $("#btn_1").on("click",function () {
    //     $("#form1").hide();
    //     $("#div1").hide();
    //     $("#btn_1").hide();
    //     $("#div2").show();
    // });

    $("#btn_commit").on("click", function () {
        $("#btn_commit").attr("disabled", "true");
        $.get("/jbbdxx", params, function (res) {
            if (res == "success") {
                alert("解除成功!");
                $("#form1").hide();
                $("#div1").hide();
                $("#div2").show();
                // location.href = "/sfyz?openid="+openid;
            } else {
                $("#btn_commit").removeAttribute("disabled");
                alert("解除失败!");
            }
        });
        // $.ajax({
        //     url: '/jbbdxx',
        //     type: 'GET',
        //     contentType: 'application/json',
        //     dataType: 'json',
        //     data: JSON.stringify(params),
        //     success: function (res) {
        //         if (res == "success") {
        //             alert("解除成功!");
        //             // location.href = "/sfyz?openid="+openid;
        //             Window.close();
        //         } else {
        //             alert("解除失败!");
        //             $("#btn_commit").removeAttribute("disabled");
        //         }
        //     },
        //     complete: function () {
        //         $("#btn_commit").removeAttribute("disabled");
        //     },
        //     before: function () {
        //         $("#btn_commit").attr("disabled", "true");
        //     },error: function(e) {
        //         console.log(e);
        //     }
        //
        // });
    });

    //请求刷新页面

    // var sfzh = $("#sfzh").val();
    // if (sfzh.length > 0) {
    //     return;
    // }
    // $.get("/reload_bdxx",params,function (res) {
    //     alert(res);
    // });
    // $.ajax({
    //     url: '/reload_bdxx',
    //     type: 'GET',
    //     contentType: 'application/json',
    //     dataType: 'json',
    //     data: JSON.stringify(params),
    //     success: function (res) {
    //         alert(res);
    //     }
    // });


});





