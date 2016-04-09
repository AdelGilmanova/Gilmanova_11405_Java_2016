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
    <#if !user??>
        <form action="${(form_url)!}" method="POST" class="form-signin login" role="form">
            <#if error_msg??>
                <input type="text" name='username' value=${(wrong_username)!} class="form-control" placeholder="User name"
                       required autofocus>
            ${(error_msg)!}
                <input type="password" name='password' class="form-control" placeholder="Password" required>
            <#else>
                <#if cookieName??>
                    <input type="text" name='username' value='${(cookieName)!}' class="form-control"
                           placeholder="User name" required autofocus>
                    <input type="password" name='password' value='${(cookiePassword)!}' class="form-control"
                           placeholder="Password" required>
                <#else>
                    <input type="text" name='username' class="form-control" placeholder="User name" required autofocus>
                    <input type="password" name='password' class="form-control" placeholder="Password" required>
                </#if>
            </#if>

            <label class="checkbox">
                Запомнить меня<input type="checkbox" name='check' value="remember-me">
            </label>
            <button class="btn btn-lg btn-primary" type="submit">Войти</button>
        </form>
    </#if>
    </div>
</#macro>
