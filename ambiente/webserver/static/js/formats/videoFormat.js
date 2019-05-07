function videoFormat( l ){
	ret = ""
	for (var i = 0; i < l.length; i++){
		ret += videoFormatUnit(l[i]);
	}
	return ret;
}

function videoFormatUnit( l ){
	return "<div class='row'>"+
				"<div class='col-xs-0 col-sm-1'></div>" + 
				"<div class='col-xs-12 col-sm-3 nopadding'>" + 
					"<img src='" +	l.image + "' class='img-responsive'>" +
				"</div>" + 
				"<div class='col-xs-12 col-sm-5'>" + 
					"<div class='row'>"+
						"<div class='col-xs-12 col-sm-12'><h1>" + 
							l.title	+
						"</h1></div>" + 
						"<div class='col-xs-12 col-sm-12'><h4>" + 
							l.description	+
						"</h4></div>" + 
					"</div>" + 
				"</div>" + 
				"<div class='col-xs-1 col-sm-1'></div>" + 
			"</div>"
}