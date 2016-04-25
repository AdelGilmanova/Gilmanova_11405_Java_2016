<#-- @ftlvariable name="teachers" type="java.util.List<ru.kpfu.itis.Gilmanova.model.TeachersEntity>"-->
<#include "../templates/main_template.ftl">
<@main_template />

<#macro left_block></#macro>

<#macro center_block>
<div class="diary-block">
    <h3 align="center">Список учащихся</h3>

    <form method="GET">
        <p>
            <select name="half">
                <option value="1">1 полугодие</option>
                <option value="2">2 полугодие</option>
            </select>
            <input type="submit" value="Показать"/></p>
    </form>

    <#if teachers?has_content>
        <table width="500" class="table table-bordered myinput">
            <thead>
            <tr>
                <td>ID</td>
                <td>Логин</td>
                <td>ФИО</td>
                <td>Дата рождения</td>
                <td>Пол</td>
                <td></td>
                <td></td>
            </tr>
            </thead>
            <tbody>
                <#list teachers as teacher>
                <tr>
                <#--Информация об учащемся-->
                    <td>${(teacher.getId())!}</td>
                    <td>${(teacher.getUsersEntity().getUsername())!}</td>
                    <td>${(teacher.getLastName())!} ${(teacher.getFirstName())!} ${(teacher.getSecondName())!}</td>
                    <td>${(teacher.getBirthday())!}</td>
                    <td>${(teacher.getGender())!}</td>
                    <td><button>Заблокировать</button></td>
                    <td><button>Редактировать</button></td>
                </tr>
                </#list>
            </tbody>
        </table>
    <#else> <p align="center">Ни один учащийся не найден.</p>
    </#if>

</div>
</#macro>

<#macro right_block></#macro>