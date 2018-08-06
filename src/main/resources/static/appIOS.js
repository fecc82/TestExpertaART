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

function connect() {
    var socket = new SockJS('/ws-ios');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected IOS: ' + frame);
        stompClient.subscribe('/topic/push-ios', function (confirm) {
        	console.log(confirm);
        	showConfirmations(JSON.parse(confirm.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function showConfirmations(message) {
	$("#tb-confirmations").append("<tr><td>" + message.attentionId + "</td>" 
			+ "<td>" + message.userUUID + "</td>"
			+ "<td>" + message.message + "</td>"
			+ "<td>" + message.ringTone + "</td>"
			+"</tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});

