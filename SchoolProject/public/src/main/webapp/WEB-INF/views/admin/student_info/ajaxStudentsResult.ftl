<#if students?has_content>
<table width="500" class="table table-bordered myinput">
    <thead>
    <tr>
        <td>ID</td>
        <td>Логин</td>
        <td>Класс</td>
        <td>ФИО</td>
        <td>Доступ</td>
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
            <td><#if student.getUsersEntity().getEnable()>TRUE
            <#else>FALSE
            </#if>
            </td>
            <td><#if student.getUsersEntity().getEnable()>
                <a href="/admin/blockStudent?studentId=${student.getId()}">Заблокировать</a>
            <#else><a href="/admin/unblockStudent?studentId=${student.getId()}">Открыть доступ</a>
            </#if>
            </td>
            <td>
                <a href="/admin/refactor_student?studentId=${student.getId()}">Редактировать</a>
            </td>
        </tr>
        </#list>
    </tbody>
</table>
<#else> <p align="center">Ни один учащийся не найден.</p>
</#if>