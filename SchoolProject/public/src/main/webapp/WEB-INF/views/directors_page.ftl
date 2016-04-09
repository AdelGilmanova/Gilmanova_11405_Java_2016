<#include "templates/main_template.ftl">
<@main_template scripts=["directors_page.js"]/>

<#macro left_block>
    <div class="cabinet-navigation opacity">
        <p><a class="cursor cabinet-link" data-toggle="modal" data-target="#photo">Поменять фотографию профиля</a></p>
        <p><a href="/directors_questions" class="cabinet-link">Мои сообщения</a></p>
        <p><a class="cursor cabinet-link" data-toggle="modal" data-target="#myModal">Зарегистрировать учащегося</a></p>
        <p><a class="cursor cabinet-link" data-toggle="modal" data-target="#myModal2">Отчислить учащегося</a></p>
        <p><a href="/journal" class="cabinet-link">Журнал</a></p>
    <#if msg ??>
        <p>Уведомление:<br>${msg}</p>
    </#if>
    </div>
</#macro>

<#macro center_block></#macro>

<#macro right_block>
<#include "templates/teachers_info.ftl">
</#macro>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content opacity09">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <br>
                    <h3 class="modal-title" id="myModalLabel" align="center">Зарегистрировать учащегося</h3>
                </div>

                <form action="${form_url}" method="post" class="student-registration-block">
                    <div class="modal-body">
                        <p>Фамилия:</p>
                        <p><input required type="text" name="last_name" oninput="validateLastName(this)" size="40"/></p>
                        <p>Имя:</p>
                        <p><input required type="text" name="first_name" oninput="validateFirstName(this)" size="40"/></p>
                        <p>Класс:</p>
                        <p><input required type="text" name="class" oninput="validateClass(this)" size="40"/></p>
                        <p>Логин:</p>
                        <p><input required type="text" name="username" oninput="validateLogin(this)" size="40"/></p>
                        <p>Пароль:</p>
                        <p><input required type="password" name="password" size="40"/></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                        <input type="submit" value="Зарегистрировать" class="btn btn-primary"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content opacity09">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <br>
                    <h3 class="modal-title" id="myModalLabel2" align="center">Введите id учащегося</h3>
                </div>

                <form action="/exclude" method="post" class="student-registration-block">
                    <div class="modal-body">
                        <p><input required type="text" name="id" oninput="validateId(this)" size="40"/></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                        <input type="submit" value="Исключить" class="btn btn-primary"/>
                    </div>
                </form>

            </div>
        </div>
    </div>
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
