<#macro main_template styles=[] scripts=[]>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8">
    <title>Гимназия 122 г. Казань</title>

    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css"/>
    <#list styles as css>
        <link rel="stylesheet" href="/resources/${css}" type="text/css"/>
    </#list>

    <script src="/resources/js/jquery-2.1.4.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <#list scripts as js>
        <script src="/resources/js/mine/${js}" type="text/javascript" defer></script>
    </#list>
</head>
<body>

<div class="content">
    <#include "menu_and_logo.ftl">
    <@left_block/>
    <@center_block/>
    <@right_block/>
</div>

</body>
</html>
</#macro>