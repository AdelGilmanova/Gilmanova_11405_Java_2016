<#if students?has_content>
<table width="500" class="table table-bordered myinput">
    <thead>
    <tr>
        <td>ID</td>
        <td>Логин</td>
        <td>Класс</td>
        <td>ФИО</td>
        <td></td>
        <td></td>
    </tr>
    </thead>
    <tbody>
        <#list students as student>
        <tr>
        <#--Информация об учащемся-->
            <td>${(student.getId())!}</td>
            <td>${(student.getUsersEntity().getUsername())!}</td>
            <td>${(student.getClass_id().getClazz())!}</td>
            <td>${(student.getLastName())!} ${(student.getFirstName())!}</td>
            <td>
                <button>Заблокировать</button>
            </td>
            <td>
                <button>Редактировать</button>
            </td>
        </tr>
        </#list>
    </tbody>
</table>
<#else> <p align="center">Ни один учащийся не найден.</p>
</#if>