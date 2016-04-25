<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>

<div class="logo">
    <img src="/resources/images/logo.png" width="100" height="102" alt="122"/>
    <h4>МБОУ «Гимназия №122 имени Ж.А Зайцевой»</h4>
    <h4>Московского района г. Казани</h4>
</div>

<div class="menu-block menu-part link">
<@sec.authorize ifAnyGranted="ROLE_ANONYMOUS">
    <span><a href="/">Главная</a></span>
</@sec.authorize>
<@sec.authorize access="isAuthenticated()">
    <span><a href="/logout">Выход</a></span>
</@sec.authorize>
<@sec.authorize ifNotGranted="ROLE_ADMIN">
    <span><a href="/information">О Гимназии</a></span>
    <span><a href="/for_parents">Родителям</a></span>
    <span><a href="/ask">Приемная директора</a></span>
    <span><a href="/comments">Отзывы</a></span>
</@sec.authorize>
<@sec.authorize ifAnyGranted="ROLE_ADMIN">
    <span><a href="/admin">Кабинет</a></span>
</@sec.authorize>
</div>


