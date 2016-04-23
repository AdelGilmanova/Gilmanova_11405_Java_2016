<#-- @ftlvariable name="table" type="java.util.List<ru.kpfu.itis.Gilmanova.model.EstimationsEntity>" -->
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
                <td colspan="10" align="center">Оценки</td>
                <td>Итоговая оценка</td>
                <td></td>
            </tr>
            <#list table as t>
                <tr>
                <#-- Форма для выставления оценки-->
                    <form name="add_form" action="/teacher/journal/add_estimate" method="POST">
                        <#assign student=t.getStudentObjectTeacherByInfoId().studentsByStudentId>
                        <td>${student.getLastName()} ${student.getFirstName()}</td>
                    <#--Вывод всех оценок-->
                        <#assign get=[(t.getEstimate0())!, (t.getEstimate1())!,(t.getEstimate2())!,(t.getEstimate3())!,
                        (t.getEstimate4())!,(t.getEstimate5())!,(t.getEstimate6())!,(t.getEstimate7())!,(t.getEstimate8())!,
                        (t.getEstimate9())!]>
                        <#list 0..9 as i>
                            <#if get[i]?has_content>
                                <td>${get[i]}</td>
                            <#else>
                                <td><input type="text" name="${i}" oninput="validateEstimate(this)" size="1"/></td>
                            </#if>
                        </#list>

                        <#if t.getFinalGrade()??>
                            <td>${t.getFinalGrade()}</td>
                        <#else>
                            <td><input type="text" name="final_grade" oninput="validateEstimate(this)" size="5"/></td>
                        </#if>
                        <td><input type="submit" id="addEstimate" value="ок"/></td>
                        <input type="hidden" name="cl" value="${(class)!}">
                        <input type="hidden" name="half" value="${(half)!}">
                        <input type="hidden" name="studentId" value="${(student.getId())!}">
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