/**
 * Created by Adel on 06.04.2016.
 */

function validateLogin(input) {
    var result = input.value.match(/s[A-Z]+[a-z]+[A-Z][A-Z]/);
    if (input.value == result) {
        input.setCustomValidity("");
    }
    else {
        input.setCustomValidity("Введенный вами логин некорректен");
    }
}
function validateClass(input) {
    var result = input.value.match(/11[АБВГ]/);
    if (input.value == result) {
        input.setCustomValidity("");
    }
    else {
        input.setCustomValidity("Такого класса не существует");
    }
}
function validateFirstName(input) {
    var result = input.value.match(/[А-Я]+[а-я]*/);
    if (input.value == result) {
        input.setCustomValidity("");
    }
    else {
        input.setCustomValidity("Имя введено некорректно");
    }
}
function validateLastName(input) {
    var result = input.value.match(/[А-Я]+[а-я]*/);
    if (input.value == result) {
        input.setCustomValidity("");
    }
    else {
        input.setCustomValidity("Фамилия введена некорректно");
    }
}
function validateId(input) {
    var result = input.value.match(/([2-9][0-9])|([1-9][0-9][0-9]+)/);
    if(result==null){
        input.setCustomValidity("Неправильный id");
    }else{
        if (input.value == result[0]) {
            input.setCustomValidity("");
        }
        else {
            input.setCustomValidity("Неправильный id");
        }
    }

}