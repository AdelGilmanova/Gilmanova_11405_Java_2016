/**
 * Created by Adel on 06.04.2016.
 */


f = function (request, response) {
    if ($("#s").val().length > 0)
        $.ajax({
            url: "/search",
            data: {"q": $("#s").val()},
            dataType: "json",
            success: function (msg) {
                if (msg.results.length > 0) {
                    console.log('msg=' + msg.results);
                    $("#res").text("");
                    for (var i = 0; i < msg.results.length; i++) {
                        $("#res").append("<div class='delete-block'> " +
                            "<form action='/cook' method='post'> " +
                            "<input type='hidden' name='delete' value='"+msg.results[i].order_content+"'>" +
                            "<input type='submit' value='Удалить'> </form>" +
                            "</div>");
                        $("#res").append("<li>" + msg.results[i].cl + "<br>Время: "+ msg.results[i].order_time +
                            "<br>Дата: " +  msg.results[i].order_date + "<br>Заказ: " + msg.results[i].order_content +
                            "<br></li><hr>");
                    }
                } else {
                    $("#res").text("По вышему запросу ничего не найдено");
                }
            }
        });
    else
        $("#res").text("");
}