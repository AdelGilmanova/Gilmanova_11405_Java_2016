/**
 * Created by Adel on 06.04.2016.
 */

function validateLogin(input) {
    var result = input.value.match(/s[A-Z]+[a-z]+[A-Z][A-Z]/);
    if (input.value == result) {
        input.setCustomValidity("");
    }
    else {
        input.setCustomValidity("��������� ���� ����� �����������");
    }
}
function validateClass(input) {
    var result = input.value.match(/11[����]/);
    if (input.value == result) {
        input.setCustomValidity("");
    }
    else {
        input.setCustomValidity("������ ������ �� ����������");
    }
}
function validateFirstName(input) {
    var result = input.value.match(/[�-�]+[�-�]*/);
    if (input.value == result) {
        input.setCustomValidity("");
    }
    else {
        input.setCustomValidity("��� ������� �����������");
    }
}
function validateLastName(input) {
    var result = input.value.match(/[�-�]+[�-�]*/);
    if (input.value == result) {
        input.setCustomValidity("");
    }
    else {
        input.setCustomValidity("������� ������� �����������");
    }
}
function validateId(input) {
    var result = input.value.match(/([2-9][0-9])|([1-9][0-9][0-9]+)/);
    if(result==null){
        input.setCustomValidity("������������ id");
    }else{
        if (input.value == result[0]) {
            input.setCustomValidity("");
        }
        else {
            input.setCustomValidity("������������ id");
        }
    }

}