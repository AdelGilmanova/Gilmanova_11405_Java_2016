<#include "templates/main_template.ftl">
<@main_template />

<#macro left_block></#macro>

<#macro center_block>
    <div class="diary-block">
        <h3>Табель успеваемости</h3>

        <p>Учащийся: ${(student)!}</p>

        <form action="/diary" method="GET">
            <p>Период:
                <select name="halves">
                    <option value="1">1 полугодие</option>
                    <option value="2">2 полугодие</option>
                </select>
                <input type="submit" value="Показать"/></p>
        </form>

    <#if table?has_content>
        <table width="500" class="table table-bordered myinput">
            <tr>
                <td>Предмет</td>
                <td colspan="10" width="300" align="center">Оценки</td>
                <td>Средний балл</td>
                <td>Итоговая оценка</td>
            </tr>

            <#list table as t>
                <tr>
                    <td>${t.getObject().getObject()}</td>

                    <#if t.getEst0()!=0>
                        <td>${t.getEst0()}</td>
                    <#else>
                        <td></td>
                    </#if>

                    <#if t.getEst1()!=0>
                        <td>${t.getEst1()}</td>
                    <#else>
                        <td></td>
                    </#if>

                    <#if t.getEst2()!=0>
                        <td>${t.getEst2()}</td>
                    <#else>
                        <td></td>
                    </#if>

                    <#if t.getEst3()!=0>
                        <td>${t.getEst3()}</td>
                    <#else>
                        <td></td>
                    </#if>

                    <#if t.getEst4()!=0>
                        <td>${t.getEst4()}</td>
                    <#else>
                        <td></td>
                    </#if>

                    <#if t.getEst5()!=0>
                        <td>${t.getEst5()}</td>
                    <#else>
                        <td></td>
                    </#if>

                    <#if t.getEst6()!=0>
                        <td>${t.getEst6()}</td>
                    <#else>
                        <td></td>
                    </#if>

                    <#if t.getEst7()!=0>
                        <td>${t.getEst7()}</td>
                    <#else>
                        <td></td>
                    </#if>

                    <#if t.getEst8()!=0>
                        <td>${t.getEst8()}</td>
                    <#else>
                        <td></td>
                    </#if>

                    <#if t.getEst9()!=0>
                        <td>${t.getEst9()}</td>
                    <#else>
                        <td></td>
                    </#if>

                    <#if t.getAvg()!=0>
                        <td>${t.getStringAvg()}</td>
                    <#else>
                        <td></td>
                    </#if>

                    <#if t.getFinal_grade()!=0>
                        <td>${t.getFinal_grade()}</td>
                    <#else>
                        <td></td>
                    </#if>
                </tr>
            </#list>
        </table>
    <#else> <p>Табель успеваемости не найден</p>
    </#if>

    </div>
</#macro>

<#macro right_block></#macro>