<#include "templates/main_template.ftl">
<@main_template scripts=["js/ask_question.js"]/>

<#macro left_block>
<div class="question-block">
    <h2 align="center">Задать вопрос</h2>
    <br>
    <form id="formx" action="javascript:void(null);" onsubmit="send()">
        <p>Тема вопроса: <input required type="text" name="theme" size="57"/></p>
        <p align="left">Описание вопроса:</p>
        <p><textarea name='text' onblur="validateLength(this)" rows='10' cols='76'></textarea></p>
        <p>Ваше имя: <input required type="text" name="name" size="60"/></p>
        <p>Ваш email: <input required type="text" name="email" onblur="validateEmail(this)" size="60"/></p>
        <p><input type="submit" id="ask" value="Отправить"/></p>
    </form>
</div>
</#macro>

<#macro center_block></#macro>

<#macro right_block>
<#include "templates/news.ftl"/>
</#macro>

