<#-- @ftlvariable name="teacher" type="ru.kpfu.itis.Gilmanova.model.TeachersEntity" -->
<#include "templates/main_template.ftl">
<@main_template />

<#macro left_block>
<div class="cabinet-navigation opacity">
    <#--<p><a class="cursor cabinet-link" data-toggle="modal" data-target="#photo">Поменять фотографию профиля</a></p>-->
    <p><a href="/teacher/add_home_work" class="cabinet-link">Задать домашнее задание</a></p>
</div>
</#macro>

<#macro center_block></#macro>

<#macro right_block>
<div class="cabinet-information opacity">
    <span class="photo"><img src="${(teacher.getPhoto())!}" width="150" height="150" alt="photo"/></span>
    <h1 align="center">Личный кабинет</h1>
    <h2>Моя анкета</h2>
    <p>Имя: ${(teacher.getLastName())!} ${(teacher.getFirstName())!} ${(teacher.getSecondName())!}</p>
    <p>Логин: ${(teacher.getUsersEntity().getUsername())!}</p>
    <p>Должность: Учитель</p>
    <p>Дата рождения: ${(teacher.getBirthday())!}</p>
    <p>Пол: ${(teacher.getGender())!}</p>
    <p>Школа: Муниципальное бюджетное общеобразовательное учреждение «Гимназия №122 имени Ж.А. Зайцевой» Московского
        района г.Казани</p>
</div>
</#macro>
<#if msg??>
    <script>
        alert(${msg});
    </script>
</#if>
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
