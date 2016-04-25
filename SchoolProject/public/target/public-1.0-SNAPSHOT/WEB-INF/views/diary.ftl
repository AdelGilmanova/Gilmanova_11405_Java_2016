<#-- @ftlvariable name="table" type="java.util.Map<java.lang.String, java.util.List<Integer>>" -->
<#-- @ftlvariable name="student" type="ru.kpfu.itis.Gilmanova.model.StudentsEntity"-->
<#include "templates/main_template.ftl">
<@main_template />

<#macro left_block></#macro>

<#macro center_block>
<div class="diary-block">
    <h3>Табель успеваемости</h3>

    <p>Учащийся: ${(student.getLastName())!} ${(student.getFirstName())!}</p>

    <p>Класс: ${(student.getClazz())!}</p>

    <form method="GET">
        <p>Период:
            <select name="half">
                <option value="1">1 полугодие</option>
                <option value="2">2 полугодие</option>
            </select>
            <input type="submit" value="Показать"/></p>
    </form>

    <#if table?has_content>
        <table width="500" class="table table-bordered myinput">
            <thead>
            <tr>
                <td>Предмет</td>
                <td colspan="28" width="700" align="center">Оценки</td>
            </tr>
            </thead>
            <tbody>
                <#list table?keys as key>
                <tr>
                <#--Oценки ученика-->
                    <td>${key}</td>
                    <#list 0..27 as i>
                        <#if table[key][i]??>
                            <td width="1">${table[key][i]}</td>
                        <#else>
                            <td></td>
                        </#if>
                    </#list>
                </tr>
                </#list>
            </tbody>
        </table>
    <#else> <p>Табель успеваемости не найден</p>
    </#if>

</div>
</#macro>

<#macro right_block></#macro>