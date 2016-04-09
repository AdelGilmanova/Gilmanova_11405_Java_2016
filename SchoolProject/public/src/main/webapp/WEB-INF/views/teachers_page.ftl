<#include "templates/main_template.ftl">
<@main_template />

<#macro left_block>
    <div class="cabinet-navigation opacity">
        <p><a class="cursor cabinet-link" data-toggle="modal" data-target="#photo">Поменять фотографию профиля</a></p>
        <p><a href="/journal" class="cabinet-link">Журнал</a></p>
    <#if cl ??>
        <p><a href="/order_food" class="cabinet-link">Школьное питание</a></p>
    </#if>
    <#if msg ??>
        <p>Уведомление:<br>${msg}</p>
    </#if>
    </div>
</#macro>

<#macro center_block></#macro>

<#macro right_block>
    <#include "templates/teachers_info.ftl">
</#macro>

    <div class="modal fade" id="photo" tabindex="-1" role="dialog" aria-labelledby="photoLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content opacity09">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <br>
                    <h3 class="modal-title" id="photoLabel" align="center">Выберите файл</h3>
                </div>

                <form action="/newFile" method="post" enctype="multipart/form-data" class="student-registration-block">
                    <div class="modal-body">
                        <p><input type="file" name="file_send"/></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                        <input type="submit" value="Загрузить" class="btn btn-primary"/>
                    </div>
                </form>

            </div>
        </div>
    </div>
