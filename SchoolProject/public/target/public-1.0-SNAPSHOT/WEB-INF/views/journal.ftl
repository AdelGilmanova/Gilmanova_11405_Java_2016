<#include "templates/main_template.ftl">
<@main_template scripts=["js/journal.js"]/>

<#macro left_block></#macro>

<#macro center_block>
    <div class="journal-block">
        <h3><a href="/teacher" class="cabinet-link">Личный кабинет</a> - Журнал</h3>

        <p>Преподаватель: ${(teacher.getLast_name())!} ${(teacher.getFirst_name())!} ${(teacher.getSecond_name())!}</p>
        <p>Предмет: ${(object)!}</p>
        <p>Класс: ${(class)!} </p>
        <p>Полугодие: ${(half)!} </p>
    <#--${(msg)!}-->
        <form name="form" action="/journal" method="get">
            <input type="hidden" name="cl" value="11А">
            <input type="hidden" name="half" value="1">

            <div class="dropdown inline">
                <button class="dropdown-toggle" data-toggle="dropdown">Класс
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a class="cursor" data-target="#" onClick="document.form.cl.value='11А'">11А</a></li>
                    <li><a class="cursor" data-target="#" onClick="document.form.cl.value='11Б'">11Б</a></li>
                    <li><a class="cursor" data-target="#" onClick="document.form.cl.value='11В'">11В</a></li>
                    <li><a class="cursor" data-target="#" onClick="document.form.cl.value='11Г'">11Г</a></li>
                </ul>
            </div>
            <div class="dropdown inline">
                <button class="dropdown-toggle" data-toggle="dropdown">Полугодие
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a class="cursor" data-target="#" onClick="document.form.half.value='1'">1 полугодие</a></li>
                    <li><a class="cursor" data-target="#" onClick="document.form.half.value='2'">2 полугодие</a></li>
                </ul>
            </div>
            <input type="submit" value="Показать"/>
        </form>
        <br>
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
                    <form action="/journal?half=${half}&object_id=${id}&student_id=${t.getStudent_id()}" method="POST">
                        <td>${t.getStudent().getLast_name()} ${t.getStudent().getFirst_name()}</td>
                        <#if t.getEst0()!=0>
                            <td>${t.getEst0()}</td>
                        <#else>
                            <td><input type="text" name="0" oninput="validateEstimate(this)" size="1"/></td>
                        </#if>

                        <#if t.getEst1()!=0>
                            <td>${t.getEst1()}</td>
                        <#else>
                            <td><input type="text" name="1" oninput="validateEstimate(this)" size="1"/></td>
                        </#if>

                        <#if t.getEst2()!=0>
                            <td>${t.getEst2()}</td>
                        <#else>
                            <td><input type="text" name="2" oninput="validateEstimate(this)" size="1"/></td>
                        </#if>

                        <#if t.getEst3()!=0>
                            <td>${t.getEst3()}</td>
                        <#else>
                            <td><input type="text" name="3" oninput="validateEstimate(this)" size="1"/></td>
                        </#if>

                        <#if t.getEst4()!=0>
                            <td>${t.getEst4()}</td>
                        <#else>
                            <td><input type="text" name="4" oninput="validateEstimate(this)" size="1"/></td>
                        </#if>

                        <#if t.getEst5()!=0>
                            <td>${t.getEst5()}</td>
                        <#else>
                            <td><input type="text" name="5" oninput="validateEstimate(this)" size="1"/></td>
                        </#if>

                        <#if t.getEst6()!=0>
                            <td>${t.getEst6()}</td>
                        <#else>
                            <td><input type="text" name="6" oninput="validateEstimate(this)" size="1"/></td>
                        </#if>

                        <#if t.getEst7()!=0>
                            <td>${t.getEst7()}</td>
                        <#else>
                            <td><input type="text" name="7" oninput="validateEstimate(this)" size="1"/></td>
                        </#if>

                        <#if t.getEst8()!=0>
                            <td>${t.getEst8()}</td>
                        <#else>
                            <td><input type="text" name="8" oninput="validateEstimate(this)" size="1"/></td>
                        </#if>

                        <#if t.getEst9()!=0>
                            <td>${t.getEst9()}</td>
                        <#else>
                            <td><input type="text" name="9" oninput="validateEstimate(this)" size="1"/></td>
                        </#if>

                        <#if t.getFinal_grade()!=0>
                            <td>${t.getFinal_grade()}</td>
                        <#else>
                            <td><input type="text" name="final_grade" oninput="validateEstimate(this)" size="5"/></td>
                        </#if>
                        <td><input type="submit" value="ок"/></td>
                    </form>
                </tr>
            </#list>
        </table>
    <#else> <p>Выберите класс</p>
    </#if>
    </div>
</#macro>

<#macro right_block></#macro>