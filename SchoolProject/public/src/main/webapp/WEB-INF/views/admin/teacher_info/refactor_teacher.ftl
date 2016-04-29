<#-- @ftlvariable name="teacher" type="ru.kpfu.itis.Gilmanova.model.TeachersEntity"-->
<#-- @ftlvariable name="teacherClasses" type="java.util.List<ru.kpfu.itis.Gilmanova.model.ClassesEntity>"-->
<#-- @ftlvariable name="AllClasses" type="java.util.List<ru.kpfu.itis.Gilmanova.model.ClassesEntity>"-->
<#-- @ftlvariable name="teacherObjects" type="java.util.List<ru.kpfu.itis.Gilmanova.model.ObjectsEntity>" -->
<#-- @ftlvariable name="AllObjects" type="java.util.List<ru.kpfu.itis.Gilmanova.model.ObjectsEntity>" -->
<#include "../../templates/main_template.ftl">
<@main_template scripts=["admin.js"]/>

<#macro left_block></#macro>

<#macro center_block>
<div class="diary-block">
    <h3><a href="/admin/teacher_list" class="cabinet-link">Списки преподвателей</a> - Редактирование данных преподавателя</h3>
    <br>
    <form method="post">
        <p><input type="text" name="lastName" value="${teacher.getLastName()}" required></p>
        <p><input type="text" name="firstName" value="${teacher.getFirstName()}" required></p>
        <p><input type="text" name="secondName" value="${teacher.getSecondName()}" required></p>
        <input type="submit" value="Применить">
    </form><br>

    Добавить предмет
    <form id="addObjectForm" action="javascript:void(null);" onsubmit="addObject()">
        <select name="objectId">
            <#if AllObjects?has_content>
                <#list AllObjects as object>
                    <option value="${object.getId()}">${object.getObject()}</option>
                </#list>
            </#if>
        </select>
        <input type="hidden" name="teacherId" value="${(teacher.getId())!}">
        <input type="submit" value="Добавить">
    </form><br>


    Добавить класс
    <form id="addClassForm" action="javascript:void(null);" onsubmit="addClass()">
        <select name="classId" class="inline">
            <#if AllClasses?has_content>
                <#list AllClasses as class>
                    <option value="${class.getId()}">${class.getClazz()}</option>
                </#list>
            </#if>
        </select>
        <select name="objectId" class="inline">
            <#if teacherObjects?has_content>
                <#list teacherObjects as object>
                    <option value="${object.getId()}">${object.getObject()}</option>
                </#list>
            </#if>
        </select>
        <input type="hidden" name="teacherId" value="${(teacher.getId())!}">
        <input type="submit" value="Добавить">
    </form><br>

</div>
</#macro>

<#macro right_block></#macro>