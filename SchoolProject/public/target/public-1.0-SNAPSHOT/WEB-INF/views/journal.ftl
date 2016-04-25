<#-- @ftlvariable name="table" type="java.util.Map<java.lang.String, java.util.List<Integer>>" -->
<#-- @ftlvariable name="objects" type="java.util.List<ru.kpfu.itis.Gilmanova.model.ObjectsEntity>" -->
<#-- @ftlvariable name="object" type="ru.kpfu.itis.Gilmanova.model.ObjectsEntity" -->
<#-- @ftlvariable name="teacher" type="ru.kpfu.itis.Gilmanova.model.TeachersEntity"-->
<#include "templates/main_template.ftl">
<@main_template scripts=["journal.js"]/>

<#macro left_block></#macro>

<#macro center_block>
<div class="journal-block">
    <h3><a href="/teacher" class="cabinet-link">Личный кабинет</a> - Журнал</h3>

    <p>Преподаватель: ${(teacher.getLastName())!} ${(teacher.getFirstName())!} ${(teacher.getSecondName())!}</p>

    <div class="dropdown inline">
        <button class="dropdown-toggle" data-toggle="dropdown">${(class)!}
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
            <#if classes?has_content>
                <#list classes as class>
                    <li><a class="cursor" data-target="#"
                           onClick="document.form.cl.value='${(class)!}'">${(class)!}</a></li>
                </#list>
            </#if>
        </ul>
    </div>

    <div class="dropdown inline">
        <button class="dropdown-toggle" data-toggle="dropdown">${(half)!} полугодие
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
            <li><a class="cursor" data-target="#" onClick="document.form.half.value='1'">1 полугодие</a></li>
            <li><a class="cursor" data-target="#" onClick="document.form.half.value='2'">2 полугодие</a></li>
        </ul>
    </div>
    <div class="dropdown inline">
        <button class="dropdown-toggle" data-toggle="dropdown">${(object.getObject())!}
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
            <#if objects?has_content>
                <#list objects as obj>
                    <li><a class="cursor" data-target="#"
                           onClick="document.form.objectId.value='${obj.getId()}'">${obj.getObject()}</a></li>
                </#list>
            </#if>
        </ul>
    </div>
<#-- Форма для выбора класса-->
    <form name="form" action="/teacher/journal/show_journal" method="get" class="inline">
        <input type="hidden" name="cl" value="${(class)!}">
        <input type="hidden" name="half" value="2">
        <input type="hidden" name="objectId" value="${(object.getId())!}">
        <input type="submit" value="Показать"/>
    </form>
    <br><br>
<#--Журнал-->
    <#if table?has_content>
        <table width="500" class="table table-bordered myinput">
            <tr>
                <td>ФИО</td>
                <td colspan="11" align="center">Оценки</td>
                <td></td>
            </tr>
            <#list table?keys as key>
                <tr>
                <#-- Форма для выставления оценки-->
                    <form name="add_form" action="/teacher/journal/add_estimate" method="POST">
                    <#--Вывод всех оценок-->
                        <td>${key}</td>
                        <#list 0..10 as i>
                            <#if table[key][i]??>
                                <td>${table[key][i]}</td>
                            <#else>
                                <td><input type="text" name="estimate" oninput="validateEstimate(this)" size="1"/></td>
                            </#if>
                        </#list>

                        <td><input type="submit" id="addEstimate" value="ок"/></td>
                        <input type="hidden" name="cl" value="${(class)!}">
                        <input type="hidden" name="half" value="${(half)!}">
                        <input type="hidden" name="studentId" value="${key}">
                        <input type="hidden" name="objectId" value="${(object.getId())!}">
                    </form>
                </tr>
            </#list>
        </table>
    <#else> <p>Выберите класс</p>
    </#if>
</div>
</#macro>

<#macro right_block></#macro>