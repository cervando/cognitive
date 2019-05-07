//La variable se hizo publica para poder ser manipulada desde la consola del explorador web
var recognition;
$( document ).ready(function(){
	recognition = new webkitSpeechRecognition();
	recognition.lang = "es-MX";
	//recognition.continuous = true;
	//recognition.start();

	//Funcion que sera ejecutada cuando se detecte un mensaje
	recognition.onresult = function(e) {
		//Si hay resultados 
		if ( e["results"] != undefined ){
			console.log(e["results"]);
			text = e["results"][ e["results"].length - 1 ][0]["transcript"];
			sentToAgent ( text );

		//En caso de error
		}else 
			console.log("Error:" + e)
	}

	//Si la funcion termina, la vuelve a empezar
	recognition.onend = function() { 
		console.log("termino");
		recognition.start();
	}
});