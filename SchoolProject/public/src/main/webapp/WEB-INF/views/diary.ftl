<#-- @ftlvariable name="table" type="java.util.List<ru.kpfu.itis.Gilmanova.model.EstimationsEntity>" -->
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
                <td colspan="10" width="300" align="center">Оценки</td>
                <td>Средний балл</td>
                <td>Итоговая оценка</td>
            </tr>
            </thead>
            <tbody>
                <#list table as t>
                <tr>
                    <td>${t.getStudentObjectTeacherByInfoId().getTeacherObjectByTeacherObjectId()
                    .getObjectsEntity().getObject()}</td>
                <#--Вывод всех оценок-->
                    <#assign get=[(t.getEstimate0())!, (t.getEstimate1())!,(t.getEstimate2())!,(t.getEstimate3())!,
                    (t.getEstimate4())!,(t.getEstimate5())!,(t.getEstimate6())!,(t.getEstimate7())!,(t.getEstimate8())!,
                    (t.getEstimate9())!]>
                    <#list 0..9 as i>
                        <#if get[i]??>
                            <td>${get[i]}</td>
                        <#else>
                            <td></td>
                        </#if>
                    </#list>
                <#--Средняя оценка по предмету-->
                    <#if t.avg()!=0>
                        <td>${t.stringAvg()}</td>
                    <#else>
                        <td></td>
                    </#if>
                <#--Итоговая оценка-->
                    <#if t.getFinalGrade()??>
                        <td>${t.getFinalGrade()}</td>
                    <#else>
                        <td></td>
                    </#if>
                </tr>
                </#list>
            </tbody>
        </table>
    <#else> <p>Табель успеваемости не найден</p>
    </#if>

</div>
</#macro>

<#macro right_block></#macro>