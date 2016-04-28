<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../../templates/main_template.ftl">
<@main_template scripts=["registration.js"]/>

<#macro left_block></#macro>

<#macro center_block>
<div class="diary-block">
    <h3 align="center">Регистрация нового преподавателя</h3>

    <@form.form commandName="teacherForm" method="post">
        <p><@form.input path="lastName" placeholder="Фамилия"/>
        <@form.errors path="lastName" cssStyle="color: red; font-size: 10px" /></p>

        <p><@form.input path="firstName" placeholder="Имя"/>
        <@form.errors path="firstName" cssStyle="color: red; font-size: 10px" /></p>

        <p><@form.input path="secondName" placeholder="Отчество"/>
        <@form.errors path="secondName" cssStyle="color: red; font-size: 10px" /></p>

        <@form.radiobutton path="gender" value="мужской" label="M"/>
        <@form.radiobutton path="gender" value="женский" label="Ж"/>

        <p>Дата рождения
        <@form.select path="day">
            <#list 1..31 as day>
                <@form.option value="${day}">${day}</@form.option>
            </#list>
        </@form.select>
        <@form.select path="month">
            <#list 1..12 as month>
                <@form.option value="${month}">${month}</@form.option>
            </#list>
        </@form.select>
        <@form.select path="year">
            <#list 1940..2000 as year>
                <@form.option value="${year}">${year}</@form.option>
            </#list>
        </@form.select></p>

        <p><@form.input path="login" id="login" placeholder="Логин"/>
        <@form.errors path="login" cssStyle="color: red; font-size: 10px" /></p>

        <p><@form.password path="password1" id="pass" placeholder="Пароль"/>
        <@form.errors path="password1" cssStyle="color: red; font-size: 10px" /></p>

        <p><@form.password path="password2" id="pass2" placeholder="Повторный пароль" onblur="validatePassword(this)"/>
        <@form.errors path="password2" cssStyle="color: red; font-size: 10px" /></p>
        <button type="submit">Зарегестрировать</button>
    </@form.form>

</div>
</#macro>

<#macro right_block></#macro>