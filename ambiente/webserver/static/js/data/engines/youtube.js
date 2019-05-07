function init(){
	
}

function load( idVideo){
	var params = { allowScriptAccess: "always" };
    var atts = { id: "myytplayer" };
    swfobject.embedSWF("http://www.youtube.com/v/" +  idVideo + "?enablejsapi=1&playerapiid=ytplayer", 
                       "ytapiplayer", "425", "356", "8", null, null, params, atts);
}

function play(){
}

function stop(){
}

function pause(){
}