<div class="cabinet-information opacity">
    <span class="photo"><img src="${(teacher.getPhoto())!}" width="150" height="150" alt="photo"/></span>
    <h1 align="center">Личный кабинет</h1>
    <h2>Моя анкета</h2>
    <p>Имя: ${(teacher.getLast_name())!} ${(teacher.getFirst_name())!} ${(teacher.getSecond_name())!}</p>
    <p>Логин: ${(login)!}</p>
    <p>Должность: Учитель</p>
    <p>Дата рождения: ${(teacher.getBirthday())!}</p>
    <p>Пол: ${(teacher.getGender())!}</p>
    <p>Школа: Муниципальное бюджетное общеобразовательное учреждение «Гимназия №122 имени Ж.А. Зайцевой» Московского
        района г.Казани</p>
</div>