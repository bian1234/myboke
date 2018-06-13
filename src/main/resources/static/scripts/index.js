function sendup() {
    $.ajax({
        cache : true,
        type : "POST",
        url : "/message/insert",
        data : $('#cform').serialize(),// 你的formid
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(data) {
            if (data.code == 20000) {
                parent.layer.msg("我会尽快回复您的留言");
                parent.reLoad();
                var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                parent.layer.close(index);

            } else {
                parent.layer.alert(data.msg)
            }

        }
    });
}