<#include "../templates/main_template.ftl">
<@main_template />

<#macro left_block></#macro>

<#macro center_block>
<div class="diary-block a-black">
    <ul>
        <li>Список
            <ul>
                <li><a href="/admin/students_list">учащихся</a></li>
                <li><a href="/admin/teacher_list">преподавателей</a></li>
            </ul>
        </li>
        <li>Зарегестрировать
            <ul>
                <li><a href="/admin/add_student">нового учащегося</a></li>
                <li><a href="/admin/add_teacher">нового преподавателя</a></li>
            </ul>
        </li>
    </ul>
</div>

</#macro>

<#macro right_block></#macro>