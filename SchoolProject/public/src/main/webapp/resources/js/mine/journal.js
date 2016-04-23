/**
 * Created by Adel on 06.04.2016.
 */
function call() {
    var msg = $('#formx').serialize();
    $.ajax({
        type: 'POST',
        url: '/teacher/journal/add_estimate',
        data: msg,
        success: function (data) {
            if (data == 'ok') {
                alert("Оценка добавлена.");
            }
        },
        error: function () {
            alert('Приносим извинения. На сервере произошла ошибка');
        }
    });
}

function validateEstimate(input) {
    var result = input.value.match(/[2345]/);
    if (input.value == result) {
        input.setCustomValidity("");
    }
    else {
        input.setCustomValidity("Оценки не существует");
    }
}

