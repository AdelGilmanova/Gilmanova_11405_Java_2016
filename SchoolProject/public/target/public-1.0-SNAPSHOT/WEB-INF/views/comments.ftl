<#include "templates/main_template.ftl">
<@main_template/>

<#macro left_block>
<div class="left-block opacity">
    <h3><a href="/director" class="cabinet-link">Личный кабинет</a> - Вопросы</h3>
    <br>
    <#if questions?has_content>
        <#list questions as q>
            <div class="delete-block">
                <form action="/directors_questions" method="post">
                    <input type="hidden" name="delete" value="${q}">
                    <input type="submit" value="Удалить">
                </form>
            </div>
            <li>${q}</li>
            <hr>
        </#list>
    <#else>  <p align="center">Отзывов пока нет</p>
        <p align="center">Оставить отзыв</p>
    </#if>
</div>
</#macro>
<#macro center_block></#macro>

<#macro right_block>
    <#include "templates/news.ftl"/>
</#macro>