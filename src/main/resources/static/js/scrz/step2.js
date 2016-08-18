$(document).ready(
    function () {
        var params = {
            'url': document.baseURI
        };
        $.ajax({
                type: 'POST',
                contentType: 'application/json',
                url: '/sign',
                dataType: 'json',
                data: JSON.stringify(params),
                success: function (data) {
                    //注入配置信息
                    wx.config({
                        debug: false,
                        appId: data.appId,
                        timestamp: data.timestamp,
                        nonceStr: data.nonceStr,
                        signature: data.signature,
                        jsApiList: [
                            'checkJsApi',
                            'chooseImage',
                            'openLocation',
                            'getLocation',
                            'uploadImage'
                        ]
                    });
                    wx.ready(function () {
                        alert('is wx ready ');
                        $("#btn_submit").removeAttr("disabled");
                    });

                }
            }
        );

        $("#btn_submit").on('click', function () {
            wx.chooseImage({
                sourceType: ['camera'],
                success: function (res) {
                    $("#img").attr("src", res.localIds[0]);
                    $.confirm({
                        title: '通知',
                        text: '请确认是否上传照片',
                        onOK: function () {
                            upload(res.localIds[0]);
                        },
                        onCancel: function () {
                        }
                    });
                    //alert('已选择 ' + res.localIds.length + ' 张图片');
                    //images.localId = res.localIds;
                }
            });

        });

        // $('#openLocation').on('click', function () {
        //     wx.getLocation({
        //         success: function (res) {
        //             wx.openLocation({
        //                 latitude: res.latitude,
        //                 longitude: res.longitude,
        //                 //name: 'TIT 创意园',
        //                 //address: '广州市海珠区新港中路 397 号',
        //                 scale: 14,
        //                 infoUrl: 'http://weixin.qq.com'
        //             });
        //         },
        //         cancel: function (res) {
        //             //alert('用户拒绝授权获取地理位置');
        //         }
        //     });
        // });

    });

function upload(picId) {
    //调用上传图片接口
    wx.uploadImage({
        localId: picId, // 需要上传的图片的本地ID，由chooseImage接口获得
        isShowProcess: 1,   // 默认为1，显示进度提示
        success: function (res) {
            //返回图片的服务器端ID res.serverId,然后调用wxImgCallback函数进行下载图片操作
            console.log(res.serverId);
            var params = {
                serverId: res.serverId
            };

            $.ajax({
                type: 'POST',
                contentType: 'application/json',
                url: '/uploadImage',
                dataType: 'json',
                data: JSON.stringify(params),
                success: function (res) {
                    if (res === 'success') {
                        $.alert('上传照片成功,社保工作人员将在3个工作日内完成信息审核!');
                        $("#btn_commit").attr("value","重新拍照");
                        $("#btn_commit").removeClass("btn-primary").addClass("btn-info");
                    }
                },
                before: function () {
                    $.showLoading();
                },
                complete: function () {
                    $.hideLoading();
                }

            });
        },
        fail: function (res) {
            $.alert('照片上传失败,请检查网络重试!', "通知");
        }
    });
}
