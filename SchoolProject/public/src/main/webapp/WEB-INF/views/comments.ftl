<#-- @ftlvariable name="comments" type="java.util.List<ru.kpfu.itis.Gilmanova.model.CommentsEntity>" -->
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<#include "templates/main_template.ftl">
<@main_template scripts=["comments.js"]/>

<#macro left_block>

<div class="comment-block">
    <h2 align="center">Отзывы</h2>

    <@sec.authorize ifNotGranted="ROLE_ADMIN">
        <p id="write_comment">Оставить отзыв</p>
    </@sec.authorize>

    <dev id="hidden-block">
        <form method="POST">
            <p>Ваше имя: <input required type="text" name="name"/></p>

            <p><textarea required name='text' oninput="validateLength(this)" rows='2' cols='76'></textarea></p>

            <p><input type="submit" value="Отправить"/></p>
        </form>
    </dev>

    <#if comments?has_content>
        <#list comments as comment>

            <@sec.authorize ifAnyGranted="ROLE_ADMIN">
                <div class="delete-block">
                    <form action="/comments/delete_comment" method="post">
                        <input type="hidden" name="commentId" value="${comment.getId()}">
                        <input type="submit" value="Удалить">
                    </form>
                </div>
            </@sec.authorize>
            <#if cookieComments??>
                <#list cookieComments as commentId>
                    <#if commentId==comment.getId()>
                        <div class="delete-block">
                            <form action="/comments/delete_comment" method="post">
                                <input type="hidden" name="commentId" value="${comment.getId()}">
                                <input type="submit" value="Удалить">
                            </form>
                        </div>
                    </#if>
                </#list>
            </#if>

            <li>${comment.getUserName()}
                <br>
            ${comment.getContent()}
                <br>
            ${comment.getDate()}
            </li>
            <hr>

        </#list>
    <#else> <p align="center">Комметариев пока нет.</p>
    </#if>
</div>

</#macro>

<#macro center_block></#macro>

<#macro right_block>
    <#include "templates/news.ftl"/>
</#macro>