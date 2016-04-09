/**
 * Created by Adel on 06.04.2016.
 */

function validateEstimate(input) {
    var result = input.value.match(/[2345]/);
    if (input.value == result) {
        input.setCustomValidity("");
    }
    else {
        input.setCustomValidity("ќценки не существует");
    }
}