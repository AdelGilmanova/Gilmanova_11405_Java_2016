/**
 * Created by Adel on 25.04.2016.
 */

function call() {
    var msg = $('#formx').serialize();
    $.ajax({
        type: 'GET',
        url: "/admin/searchClass",
        data: msg,
        error: function (error) {
            alert('Приносим извинения. На сервере произошла ошибка:'+ error);
        }
    }).done(function (data) {  // сюда приходит ответ при успехе
        if (data != '') {
            $("#res").text("");
            $("#res").append(data);
        }
    })
}

f = function (request, response) {
    if ($("#s").val().length > 0)
        $.ajax({
            url: "/admin/searchByName",
            data: {"name": $("#s").val()},
            error: function (error) {
                alert('Приносим извинения. На сервере произошла ошибка:'+ error);
            }
        }).done(function (data) {  // сюда приходит ответ при успехе
            if (data != '') {
                $("#res").text("");
                $("#res").append(data);
            } else {
                this.hide();
            }
        })

};