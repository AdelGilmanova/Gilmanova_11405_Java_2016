/**
 * Created by Adel on 25.04.2016.
 */

function studentSearch() {
    var msg = $('#formx').serialize();
    $.ajax({
        type: 'GET',
        url: "/admin/searchClass",
        data: msg,
        error: function (error) {
            alert('Приносим извинения. На сервере произошла ошибка:' + error);
        }
    }).done(function (data) {  // сюда приходит ответ при успехе
        if (data != '') {
            $("#res").text("");
            $("#res").append(data);
        }
    })
}

studentFunc = function (request, response) {
    if ($("#s").val().length > 0)
        $.ajax({
            url: "/admin/searchByName",
            data: {"name": $("#s").val()},
            error: function (error) {
                alert('Приносим извинения. На сервере произошла ошибка:' + error);
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

teacherFunc = function (request, response) {
    if ($("#s").val().length > 0)
        $.ajax({
            url: "/admin/searchTeacherByName",
            data: {"name": $("#s").val()},
            error: function (error) {
                alert('Приносим извинения. На сервере произошла ошибка:' + error);
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

function addObject() {
    var msg = $('#addObjectForm').serialize();
    $.ajax({
        type: 'POST',
        url: '/admin/add_object',
        data: msg,
        success: function (data) {
            if (data == 'ok') {
                alert("Предмет добавлен.");
            }
            if(data == 'no'){
                alert("Этот предмет уже преподается данным преподавателем.");
            }
            location.reload();
        },
        error: function () {
            alert('Приносим извинения. На сервере произошла ошибка');
        }
    });
}

function addClass() {
    var msg = $('#addClassForm').serialize();
    $.ajax({
        type: 'POST',
        url: '/admin/add_class',
        data: msg,
        success: function (data) {
            if (data == 'ok') {
                alert("Класс добавлен.");
            }else{
                alert("Данный преподаватель уже преподает в этом классе.");
            }
            location.reload();
        },
        error: function () {
            alert('Приносим извинения. На сервере произошла ошибка');
        }
    });
}

