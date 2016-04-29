<#-- @ftlvariable name="classes" type="java.util.List<ru.kpfu.itis.Gilmanova.model.ClassesEntity>"-->
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../../templates/main_template.ftl">
<@main_template scripts=["registration.js"]/>

<#macro left_block></#macro>

<#macro center_block>
<div class="diary-block">
    <h3 align="center">Регистрация нового учащегося</h3>

    <@form.form commandName="studentForm" method="post">
        <p><@form.input path="lastName" placeholder="Фамилия"/>
        <@form.errors path="lastName" cssStyle="color: red; font-size: 10px" /></p>

        <p><@form.input path="firstName" placeholder="Имя"/>
        <@form.errors path="firstName" cssStyle="color: red; font-size: 10px" /></p>

        Класс: <@form.select path="clazz">
        <#if classes?has_content>
            <#list classes as class>
                <@form.option value="${class.getId()}">${class.getClazz()}</@form.option>
            </#list>
        </#if>
    </@form.select><br><br>

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
