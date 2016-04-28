/**
 * Created by Adel on 19.03.2016.
 */

function validatePassword(input) {
    var pass = $('#pass').val();
    var pass2 = $('#pass2').val();
    if (pass == pass2) {
        input.setCustomValidity("");
    }
    else {
        input.setCustomValidity("Пароли не совпадают. Повторите попытку");
    }
}


