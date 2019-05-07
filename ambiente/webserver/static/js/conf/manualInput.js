$( document ).ready(function(){
	$("#manualInput").keypress(function(e) {
	    if(e.which == 13) {
	    	val = e.target.value;
	    	val = val.charAt(0).toUpperCase() + val.slice(1);
	    	sendMessage(val);
	       	e.target.value = "";
	    }
	});
});