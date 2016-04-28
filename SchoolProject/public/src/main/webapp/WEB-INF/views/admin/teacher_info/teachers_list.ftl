<#-- @ftlvariable name="teachers" type="java.util.List<ru.kpfu.itis.Gilmanova.model.TeachersEntity>"-->
<#include "../../templates/main_template.ftl">
<@main_template scripts=["admin.js"]/>

<#macro left_block></#macro>

<#macro center_block>
<div class="diary-block">
    <h3 align="center">Список учащихся</h3>
    <p></p><input type="text" id="s" oninput="teacherFunc()"/>
    <br><br>
    <div id="res">
        <#if teachers?has_content>
            <table width="500" class="table table-bordered myinput">
                <thead>
                <tr>
                    <td>ID</td>
                    <td>Логин</td>
                    <td>ФИО</td>
                    <td>Дата рождения</td>
                    <td>Пол</td>
                    <td>Доступ</td>
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
                        <td><#if teacher.getUsersEntity().getEnable()>TRUE
                        <#else>FALSE
                        </#if>
                        </td>
                        <td><#if teacher.getUsersEntity().getEnable()>
                            <a href="/admin/blockTeacher?teacherId=${teacher.getId()}">Заблокировать</a>
                        <#else><a href="/admin/unblockTeacher?teacherId=${teacher.getId()}">Открыть доступ</a>
                        </#if>
                        </td>
                        <td>
                            <a href="/admin/refactor_teacher?teacherId=${teacher.getId()}">Редактировать</a>
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