var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

$(document).ready(function(){
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/gameRoom', function (greeting) {
            updateGame(
                JSON.parse(greeting.body).content,
                JSON.parse(greeting.body).namesOfAttackRegions,
                JSON.parse(greeting.body).idsForAdjacentRegions
            );
        });
    });
});

function updateGame(currentLand, namesOfAttackRegions, idsForAdjacentRegions) {
    var currentLand = currentLand.split("!1");
    var namesOfAttackRegions = namesOfAttackRegions.split("!2");
    var idsForAdjacentRegions = idsForAdjacentRegions.split("!3");

    $("#CountryName").html(currentLand[0]);
    $("#CountryValues").html(currentLand[1]);

    $(".adjacent").removeClass("adjacent");
    $(".chosen").removeClass("chosen");
    $(".others").removeClass("others");
    for(var i=1; i<idsForAdjacentRegions.length-1; i++){
        $("#" + idsForAdjacentRegions[i] + " > g > a > path").addClass("adjacent");
    }
    $("#" + idsForAdjacentRegions[idsForAdjacentRegions.length-1] + " > g > a > path").addClass("chosen");
    $("path:not(.adjacent):not(.chosen)").addClass("others");

    var attackRegionOutput = "";
    for (var i=1; i<namesOfAttackRegions.length; i++) {
        attackRegionOutput += "<button type='button' class='btn btn-default attackFrom' data-dismiss='modal' value='" + namesOfAttackRegions[i] + "'>" + namesOfAttackRegions[i] + "</button><br>";
    }
    $("#ifAttackIsPossible").append().html("<h4>Du kan attackera från:</h4>" + attackRegionOutput);
    $(".attackFrom").click(function () {
        stompClient.send("/app/attack", {}, JSON.stringify({'name':idsForAdjacentRegions[idsForAdjacentRegions.length-1]}));
    });
}

























/*
$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#endTurn" ).click(function() { sendGameTurnData(); });
});
*/

/*
 function disconnect() {
 if (stompClient != null) {
 stompClient.disconnect();
 }
 setConnected(false);
 console.log("Disconnected");
 }
 */

/*
 function sendGameTurnData() {
 stompClient.send("/app/endTurn", {}, JSON.stringify({'name': $("#name").val()}));
 }
 */