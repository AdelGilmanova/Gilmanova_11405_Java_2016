/**
 * Created by Adel on 06.04.2016.
 */

function validateLength(input) {
    if (input.value.length > 20) {
        input.setCustomValidity("��������� ���� ����� ������� �������");
    }
    else {
        input.setCustomValidity("");
    }
}