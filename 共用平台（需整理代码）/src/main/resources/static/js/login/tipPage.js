var wait = 10;
$(function () {
    countDownTime();
});


/**
 * 倒计时
 * @param obj
 */
function countDownTime() {
    if (wait == 0) {
        window.location.href="/base/login";
    } else {
        $("#btnCountDown").text(wait);
        wait--;
        setTimeout(function() {
            countDownTime()
        }, 1000)
    }
}
