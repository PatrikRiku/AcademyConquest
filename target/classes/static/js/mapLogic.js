$(document).ready(function() {

    var majorNationTurn;

    $("#majorNationsDropdown > li > a").click(function(){
        majorNationTurn = $(this).attr("id");
    });

    $('g > a').click(function () {
        if($(this).children().hasClass("chosen")) {
            $(".adjacent").removeClass("adjacent");
            $(".chosen").removeClass("chosen");
            $(".others").removeClass("others");
        } else {
            var myId = $(this).parent().parent().attr('id');
<<<<<<< HEAD
<<<<<<< HEAD
            stompClient.send("/app/makeMove", {}, JSON.stringify({'person': myId}));
=======
            stompClient.send("/app/makeMove", {}, JSON.stringify({'name': myId, 'majorNationTurn': majorNationTurn}));
>>>>>>> 230f714ee0b39b6038e69b780d6b0a449db6f50a
=======
            stompClient.send("/app/makeMove", {}, JSON.stringify({'name': myId, "majorNationTurn": majorNationTurn}));
>>>>>>> 6bb1f523f029b11bfab750d3c59f7bf0a1971d40
        }
    });

    $("#btnClose").click(function(){
        $(".adjacent").removeClass("adjacent");
        $(".others").removeClass("others");
        $(".chosen").removeClass("chosen");
    });

    var width = $("#gameMap").width();
    var height = $("#gameMap").height();

    $("#zoomIn").click(function(e){
        var newWidth = width * 1.25;
        var newHeight = height * 1.25;
        var scrolledX = window.pageXOffset;
        var scrolledY = window.pageYOffset;
        $("#gameMap").css("transform-origin", 0 + "px" + scrolledY + "px");
        $("#gameMap").css("animation", "zoomIn 0.5s");
        /*
         setTimeout(function(){
         $("#gameMap").css("width", newWidth + "px");
         $("#gameMap").css("height", newHeight + "px");
         window.scrollTo(scrolledX * 1.25, scrolledY * 1.26);
         }, 500);
         */
    });

    $("#zoomOut").click(function(e){
        var newWidth = width * 0.8;
        var newHeight = height * 0.8;
        $("#gameMap").css("animation", "zoomOut 0.5s");
        $("#gameMap").css("animation", "zoomOut 0.5s");
        setTimeout(function(){
            $("#gameMap").css("width", newWidth + "px");
            $("#gameMap").css("height", newHeight + "px");
        }, 500);
    });


});