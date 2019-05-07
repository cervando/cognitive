$( document ).ready(function(){
	$("#menu-conf").mmenu();
});

function conf_open(){
	$("#menu-conf").trigger("open");
}

function conf_close(){
	$("#menu-conf").trigger("close");
}