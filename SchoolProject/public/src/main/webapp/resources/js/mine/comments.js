/**
 * Created by Adel on 09.04.2016.
 */

$(document).on('click', '#write_comment', function () {
    document.getElementById("hidden-block").style.display='inline';
    document.getElementById("write_comment").style.display='none';
});

function validateLength(input) {
    if (input.value.length > 20) {
        input.setCustomValidity("Введенный вами текст слишком большой");
    }
    if (input.value.length < 4) {
        input.setCustomValidity("Введенный вами текст слишком маленький");
    }
    else {
        input.setCustomValidity("");
    }
}