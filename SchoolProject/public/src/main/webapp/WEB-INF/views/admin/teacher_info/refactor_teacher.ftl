<#-- @ftlvariable name="teacher" type="ru.kpfu.itis.Gilmanova.model.TeachersEntity"-->
<#include "../../templates/main_template.ftl">
<@main_template />

<#macro left_block></#macro>

<#macro center_block>
<div class="diary-block">
    <h3 align="center">Редактирование данных преподавателя</h3>

    <form method="post">
        <p><input type="text" name="lastName" value="${teacher.getLastName()}" required></p>
        <p><input type="text" name="firstName" value="${teacher.getFirstName()}" required></p>
        <p><input type="text" name="secondName" value="${teacher.getSecondName()}" required></p>
        <input type="submit" value="Применить">
    </form>

</div>
</#macro>

<#macro right_block></#macro>