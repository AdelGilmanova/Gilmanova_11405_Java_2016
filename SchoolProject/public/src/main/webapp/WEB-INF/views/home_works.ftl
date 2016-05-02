<#-- @ftlvariable name="objects" type="java.util.List<ru.kpfu.itis.Gilmanova.model.ObjectsEntity>" -->
<#-- @ftlvariable name="teacher" type="ru.kpfu.itis.Gilmanova.model.TeachersEntity"-->
<#-- @ftlvariable name="classes" type="java.util.List<ru.kpfu.itis.Gilmanova.model.ClassesEntity>"-->
<#include "templates/main_template.ftl">
<@main_template scripts=["home_works.js"]/>

<#macro left_block>
<div class="comment-block">
    <h3><a href="/teacher" class="cabinet-link">Личный кабинет</a> - Задать домашнее задание</h3>
    <p>Преподаватель: ${(teacher.getLastName())!} ${(teacher.getFirstName())!} ${(teacher.getSecondName())!}</p>
    <p>Кол-во заданных домашних заданий: <#if home_work??>${home_work}<#else>0</#if></p>
    <br>

    <form id="formx" action="javascript:void(null);" onsubmit="send()">
        <p>
            <select name="objectId" class="inline">
                <#if objects?has_content>
                    <#list objects as object>
                        <option value="${object.getId()}">${object.getObject()}</option>
                    </#list>
                </#if>
            </select>
            <select name="classId" class="inline">
                <#if classes?has_content>
                    <#list classes as class>
                        <option value="${class.getId()}">${class.getClazz()}</option>
                    </#list>
                </#if>
            </select>
            <button type="submit">Задать</button>
        </p>
        Задание:
        <textarea name="home_work" rows='15' cols='76' required></textarea>
        <input type="hidden" name="teacherId" value="${(teacher.getId())!}">
    </form>
</div>
</#macro>

<#macro center_block></#macro>

<#macro right_block>
    <#include "templates/news.ftl"/>
</#macro>