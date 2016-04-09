/**
 * Created by Adel on 06.04.2016.
 */

function send() {
    var msg = $('#formx').serialize();
    $.ajax({
        type: 'POST',
        url: '/ask',
        data: msg,
        success: function (data) {
            if (data == 'ok') {
                alert("Ваш вопрос отправлен.");
                $('#formx').find('input[type=text], textarea').val('');
            } else {
                alert("Приносим извинения. Ваш вопрос не удалось отправить.")
            }
        },
        error: function () {
            alert('Приносим извинения. На сервере произошла ошибка');
        }
    });
}

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

function validateEmail(input) {
    if (/.+@.+\..+/.test(input.value)) {
        input.setCustomValidity("");
    }
    else {
        input.setCustomValidity("Введенный вами email некорректен");
    }
}
