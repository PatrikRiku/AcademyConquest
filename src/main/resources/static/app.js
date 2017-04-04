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
            updateGame(JSON.parse(greeting.body).content);
        });
    });
});

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendGameTurnData() {
    stompClient.send("/app/endTurn", {}, JSON.stringify({'name': $("#name").val()}));
}

function updateGame(message) {
    //Vi splittar upp informationen för att kunna skriva värden på olika ställen
    var firstSplit = message.split("kristofferrobin");
    console.log("f1rst " + firstSplit);
    var myAttackRegions = firstSplit[1].split("!1");
    console.log("2nd " + myAttackRegions);
    var countryContent = firstSplit[0].split("!1");
    console.log("tre " + countryContent);
    var clickedRegion = firstSplit[1].split("!3");
    console.log("fyra " + clickedRegion);
    $("#CountryName").html(countryContent[0]);
    $("#CountryValues").html(countryContent[1]);
    $(".adjacent").removeClass("adjacent");
    $(".chosen").removeClass("chosen");
    $(".others").removeClass("others");
    for(var i=2; i<countryContent.length; i++){
        $("#" + countryContent[i] + " > g > a > path").addClass("adjacent");
    }
    $("#" + clickedRegion[1] + " > g > a > path").addClass("chosen");
    $("path:not(.adjacent):not(.chosen)").addClass("others");
    var abc = "";
    for (var j=0; j<myAttackRegions.length; j++) {
        abc +=  myAttackRegions[j]+"<br>";
    }
    $("#ifAttackIsPossible").append().html("<h4>Du kan attackera från:</h4><p>" + abc + "</p>");
}



$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#endTurn" ).click(function() { sendGameTurnData(); });
});