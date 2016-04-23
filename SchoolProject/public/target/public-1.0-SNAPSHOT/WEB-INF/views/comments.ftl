<#-- @ftlvariable name="comments" type="java.util.List<ru.kpfu.itis.Gilmanova.model.CommentsEntity>" -->
<#include "templates/main_template.ftl">
<@main_template scripts=["comments.js"]/>

<#macro left_block>

<div class="comment-block">
    <h2 align="center">Отзывы</h2>
    <p id="write_comment">Оставить отзыв</p>

    <dev id="hidden-block">
    <form method="POST">
        <p>Ваше имя: <input required type="text" name="name"/></p>
        <p><textarea required name='text' oninput="validateLength(this)" rows='2' cols='76'></textarea></p>
        <p><input type="submit" value="Отправить"/></p>
    </form>
    </dev>

    <#if comments?has_content>
        <#list comments as comment>
            <li>${comment}</li>
            <hr>
        </#list>
    <#else> Комметариев пока нет.
    </#if>
</div>

</#macro>

<#macro center_block></#macro>

<#macro right_block>
    <#include "templates/news.ftl"/>
</#macro>