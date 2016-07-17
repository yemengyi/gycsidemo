function upload(picId) {
    //调用上传图片接口
    wx.uploadImage({
        localId: picId, // 需要上传的图片的本地ID，由chooseImage接口获得
        isShowProcess: 1,   // 默认为1，显示进度提示
        success: function(res) {
            //返回图片的服务器端ID res.serverId,然后调用wxImgCallback函数进行下载图片操作
            console.log(res.serverId);

            var params = {
                serverId : res.serverId
            };

            $.ajax({
                type: 'POST',
                contentType: 'application/json',
                url: '/uploadImage',
                dataType: 'json',
                data: JSON.stringify(params),
                success: function(res) {
                    if (res === 'success') {
                        alert('success');
                    }
                }
            });
        },
        fail: function(res) {
            alert('上传失败');
        }
    });
}

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
                    wx.config({
                        debug: true,
                        appId: 'wxf1f4b5e7a684eebc',
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
                        alert('ready ');

                    });

                }
            }
        );

        $('.button_img').on('click', function () {

            wx.chooseImage({
                sourceType: ['camera'],

                success: function (res) {
                    //images.localId = res.localIds;
                    $("#img_test").attr("src", res.localIds[0]);
                    alert('已选择 ' + res.localIds.length + ' 张图片');
                    upload(res.localIds[0]);
                }
            });

        })

        $('#openLocation').on('click', function () {
            wx.getLocation({
                success: function (res) {
                    wx.openLocation({
                        latitude: res.latitude,
                        longitude: res.longitude,
                        //name: 'TIT 创意园',
                        //address: '广州市海珠区新港中路 397 号',
                        scale: 14,
                        infoUrl: 'http://weixin.qq.com'
                    });
                },
                cancel: function (res) {
                    alert('用户拒绝授权获取地理位置');
                }
            });
        });

    });