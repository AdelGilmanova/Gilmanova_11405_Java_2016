<#include "templates/main_template.ftl">
<@main_template />

<#macro left_block>
<div class="question-block">
    <h2 align="center">Оставить отзыв</h2>
    <#if msg ??>
        <p align="center">${msg}</p>
    </#if>
    <form action="${form_url}" method="POST">
        <p>Ваше имя: <input required type="text" name="name" size="60"/></p>
        <p><textarea required name='text' oninput="validateLength(this)" rows='10' cols='76'></textarea></p>
        <p><input type="submit" value="Отправить"/></p>
    </form>
</div>
</#macro>

<#macro center_block></#macro>

<#macro right_block>
    <#include "templates/news.ftl"/>
</#macro>