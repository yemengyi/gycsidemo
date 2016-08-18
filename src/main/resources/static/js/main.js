$(function () {
    function onKeyDown() {
        if ((event.altKey) || ((event.keyCode == 8) &&
            (event.srcElement.type != "text" &&
            event.srcElement.type != "textarea" &&
            event.srcElement.type != "password")) ||
            ((event.ctrlKey) && ((event.keyCode == 78) || (event.keyCode == 82)) ) ||
            (event.keyCode == 116)) {
            event.keyCode = 0;
            event.returnValue = false;
        }
    }
    document.onkeydown = onKeyDown;

    function stop() { //这个是禁用鼠标右键
        return false;
    }
    document.oncontextmenu = stop;
});



