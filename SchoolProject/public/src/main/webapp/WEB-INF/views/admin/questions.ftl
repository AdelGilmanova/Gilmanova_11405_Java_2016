<#-- @ftlvariable name="questions" type="java.util.List<ru.kpfu.itis.Gilmanova.model.QuestionsEntity>"-->
<#include "../templates/main_template.ftl">
<@main_template />

<#macro left_block>

<div class="comment-block">
    <h2 align="center">Вопросы пользователей</h2>

    <#if questions?has_content>
        <#list questions as question>

            <div class="delete-block">
                <form action="/delete_question" method="post">
                    <input type="hidden" name="questionId" value="${question.getId()}">
                    <input type="submit" value="Удалить">
                </form>
            </div>

            <li>${question.getEmail()}<br>
                Имя отправителя: ${question.getQuestionName()}<br>
                Тема: ${question.getTheme()}<br>
                ${question.getQuestionContent()}<br>
                Время: ${question.getQuestionDate()} ${question.getQuestionTime()}
            </li>
            <hr>

        </#list>
    <#else> <p align="center">Вопросов нет.</p>
    </#if>
</div>

</#macro>

<#macro center_block></#macro>

<#macro right_block>
    <#include "../templates/news.ftl"/>
</#macro>