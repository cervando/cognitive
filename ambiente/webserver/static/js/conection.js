var connection;
$( document ).ready(function(){
	connection = new WebSocket('wss://localhost:8888/socket');

	// When the connection is open, send some data to the server
	connection.onopen = function () {
		console.log("WebSocket opened");
	};

	// Log errors
	connection.onerror = function (error) {
		console.log('WebSocket Error ' + error);
	};

	// Log messages from the server
	connection.onmessage = function (e) {
		console.log('Server: ' + e.data);
	};
});




function sendMessage( text ){
	connection.send(text)
	/*jcrI = justClientRelevant.indexOf(text);
	if( jcrI != -1 ){
		
	}else{
		console.log( text );
		$.post(
			"/proccess",
			{"text":text},
			function( response ){
				console.log( response );
				if ( response.meta.actionType == actionType.ERROR ){
					console.log("ERROR");
				}else if ( response.meta.actionType == actionType.ATOMIC ){
					console.log("atomic");
				}else if ( response.meta.actionType == actionType.OPTIONS ){
					if ( response.meta.contentType == contentType.VIDEO ){
						parsed = videoFormat(response.result.items);
						$("#content").html(parsed);
					}
				}
				
			},
			"json"
		);
	}*/
}

/*
function setHandler(type, source){
	$("#" +type + "Handler").attr("src", source);
}

justClientRelevant = [
	"pausar video", 
	"pausa el video",
	"sistemo comando"
]


var lastValue = "";
*/
