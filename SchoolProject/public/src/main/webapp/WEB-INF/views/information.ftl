<#include "templates/main_template.ftl">
<@main_template />

<#macro left_block>
<div class="inf-left-block opacity">
    <div id="carousel" class="carousel slide slider-block opacity" data-ride="carousel" data-interval="3000">
        <!-- Индикаторы для карусели -->
        <ol class="carousel-indicators">
            <li data-target="#carousel" data-slide-to="0" class="active"></li>
            <li data-target="#carousel" data-slide-to="1"></li>
            <li data-target="#carousel" data-slide-to="2"></li>
            <li data-target="#carousel" data-slide-to="3"></li>
            <li data-target="#carousel" data-slide-to="4"></li>
            <li data-target="#carousel" data-slide-to="5"></li>
            <li data-target="#carousel" data-slide-to="6"></li>
        </ol>

        <!-- Слайды карусели -->
        <div class="carousel-inner ">
            <div class="item active">
                <img src="/resources/images/slider/1.jpg" alt="122"/>
            </div>
            <div class="item">
                <img src="/resources/images/slider/2.jpg" alt="122"/>
            </div>
            <div class="item">
                <img src="/resources/images/slider/3.jpg" alt="122"/>
            </div>
            <div class="item">
                <img src="/resources/images/slider/4.jpg" alt="122"/>
            </div>
            <div class="item">
                <img src="/resources/images/slider/5.jpg" alt="122"/>
            </div>
            <div class="item">
                <img src="/resources/images/slider/6.jpg" alt="122"/>
            </div>
            <div class="item">
                <img src="/resources/images/slider/7.jpg" alt="122"/>
            </div>
        </div>

        <!-- Навигация для карусели -->
        <a class="left carousel-control" href="#carousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a class="right carousel-control" href="#carousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
    </div>
    <h3 align="center">Lorem ipsum</h3>
</div>
</#macro>

<#macro center_block></#macro>

<#macro right_block>
<div class="inf-right-block opacity">
    <h3 align="center">О Гимназии</h3>
    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse efficitur massa cursus, auctor erat eu,
    vulputate urna. Etiam non magna eu lacus mollis consectetur. Donec condimentum ut nibh ut euismod. Morbi
    maximus
    orci nec ipsum fringilla, at consectetur lacus consectetur. Maecenas quam nunc, gravida et posuere
    elementum,
    bibendum id nibh. Cras non ultricies metus. Donec in libero tortor. Nullam pulvinar at tortor accumsan
    dictum.
    Cras
    tincidunt nunc non fermentum luctus.

    Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aenean vel
    turpis
    ut
    eros sodales commodo. Aliquam dolor turpis, maximus ultrices laoreet eu, aliquet at felis. Praesent accumsan
    auctor
    suscipit. Nulla non malesuada augue. Maecenas sed iaculis enim, sagittis rutrum elit. Vestibulum nec elit
    eleifend,
    auctor ipsum non, dignissim odio. Vestibulum vel mollis erat.
</div>
</#macro>