<#-- @ftlvariable name="students" type="java.util.List<ru.kpfu.itis.Gilmanova.model.StudentsEntity>"-->
<#-- @ftlvariable name="classes" type="java.util.List<ru.kpfu.itis.Gilmanova.model.ClassesEntity>"-->
<#include "../../templates/main_template.ftl">
<@main_template scripts=["admin.js"]/>

<#macro left_block></#macro>

<#macro center_block>
<div class="diary-block">
    <h3 align="center">Список учащихся</h3>

    <p class="inline"></p><input type="text" id="s" oninput="studentFunc()"/>

    <form method="GET" id="formx" action="javascript:void(null);" onsubmit="studentSearch()" class="inline right">
        <select name="classId">
            <#if classes?has_content>
                <#list classes as class>
                    <option value="${class.getId()}">${class.getClazz()}</option>
                </#list>
            </#if>
        </select>
        <button>Поиск</button>
        <button id="slot1">Поиск на gwt</button>
    </form>
    <br><br>

    <div id="res">
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
    </div>

</div>
</#macro>

<#macro right_block></#macro>