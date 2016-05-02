/**
 * Created by Adel on 06.04.2016.
 */
function send() {
    var msg = $('#formx').serialize();
    $.ajax({
        type: 'POST',
        url: '/teacher/add_home_work',
        data: msg,
        success: function (data) {
            if (data == 'ok') {
                location.reload();
                alert("Задание отправлено.");
                $('#formx').find('input[type=text], textarea').val('');
            }
        },
        error: function () {
            alert('Приносим извинения. На сервере произошла ошибка');
        }
    });
}

