<#-- @ftlvariable name="student" type="ru.kpfu.itis.Gilmanova.model.StudentsEntity"-->
<#-- @ftlvariable name="classes" type="java.util.List<ru.kpfu.itis.Gilmanova.model.ClassesEntity>"-->
<#include "../../templates/main_template.ftl">
<@main_template />

<#macro left_block></#macro>

<#macro center_block>
<div class="diary-block">
    <h3 align="center">Редактирование данных учащегося</h3>

    <form method="post">
        <p><input type="text" name="lastName" value="${student.getLastName()}" required></p>

        <p><input type="text" name="firstName" value="${student.getFirstName()}" required></p>
        <select name="clazz">
            <#list classes as class>
                <#if class.getId()=student.getClass_id().getId()>
                    <option value="${class.getId()}" selected>${class.getClazz()}</option>
                <#else>
                    <option value="${class.getId()}">${class.getClazz()}</option>
                </#if>

            </#list>
        </select>
        <input type="submit" value="Применить">
    </form>

</div>
</#macro>

<#macro right_block></#macro>