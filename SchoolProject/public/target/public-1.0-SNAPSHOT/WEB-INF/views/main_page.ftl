<#include "templates/main_template.ftl">
<@main_template />

<#macro left_block>
<div class="main-block opacity">
    <h2 align="center">Учебный процесс</h2>
    <br>
    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse efficitur massa cursus, auctor erat eu,
    vulputate urna. Etiam non magna eu lacus mollis consectetur. Donec condimentum ut nibh ut euismod. Morbi maximus
    orci nec ipsum fringilla, at consectetur lacus consectetur. Maecenas quam nunc, gravida et posuere elementum,
    bibendum id nibh. Cras non ultricies metus. Donec in libero tortor. Nullam pulvinar at tortor accumsan dictum.
    Cras
    tincidunt nunc non fermentum luctus.

    Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aenean vel turpis
    ut
    eros sodales commodo. Aliquam dolor turpis, maximus ultrices laoreet eu, aliquet at felis.
</div>
</#macro>

<#macro center_block></#macro>

<#macro right_block>
<div class="main-block opacity">
    <h1 align="center">Добро пожаловать!</h1>
    <h3 align="center">Вход в личный кабинет</h3>
    <form name="authForm" id="authForm" action="/j_spring_security_check" method="POST" class="form-signin login"
          role="form">
        <input type="text" name="j_username" value='${(username)!}' class="form-control"
               placeholder="User name" required autofocus>
        <input type="password" name="j_password" value='${(password)!}' class="form-control"
               placeholder="Password" required>
        <#if error?has_content>
            <div style="text-align: right;color: red; font-size: 13px"><i>Неверный логин или пароль.</i></div>
        </#if>

        <label class="checkbox">
            Запомнить меня<input type="checkbox" id="remember_me" name="_spring_security_remember_me">
        </label>
        <button class="btn btn-primary btn-block" type="submit">Войти</button>
    </form>
</div>
</#macro>
