<#-- @ftlvariable name="home_works" type="java.util.List<ru.kpfu.itis.Gilmanova.model.HomeWorkEntity>" -->
<#-- @ftlvariable name="student" type="ru.kpfu.itis.Gilmanova.model.StudentsEntity"-->
<#include "templates/main_template.ftl">
<@main_template />

<#macro left_block>

<div class="comment-block">
    <h2 align="center">Домашние задания</h2>

    <#if home_works?has_content>
        <#list home_works as home_work>
            <li>${home_work.getClassTeacherObjectById().getTeacher_object_id().getObjectsEntity().getObject()}<br>
                Дата: ${home_work.getDate()}<br>
                Задание: ${home_work.getHomeWork()}<br>
            </li>
            <hr>
        </#list>
    <#else> <p align="center">Домашних заданий пока нет.</p>
    </#if>
</div>

</#macro>

<#macro center_block></#macro>

<#macro right_block>
    <#include "templates/news.ftl"/>
</#macro>