<#include "templates/main_template.ftl">
<@main_template scripts=["ask_question.js"]/>
<#--<script type="text/javascript" language="javascript"-->
        <#--src="../app/app.nocache.js"></script>-->
<iframe id="_gwt_historyFrame" style="width: 0; height: 0;border: 0"></iframe>
<#macro left_block>
<div class="question-block">
    <h2 align="center">Задать вопрос</h2>
    <br>
    <p>Тема вопроса: <div id="theme"></div>
    <p align="left">Описание вопроса:</p>
    <p><span id="text"></span>
    <p>Ваше имя: <span id="name"></span>
    <p>Ваш email: <span id="email">
        <p><span id="add"></span></p>

</div>
</#macro>

<#macro center_block></#macro>

<#macro right_block>
<#include "templates/news.ftl"/>
</#macro>

