var page=require('webpage').create();

page.open('http://www.pudelek.pl/', function(status) {
	 	debugger;	
		console.log("Status: "+status);
		var title = page.evaluate(function() {
			return document.title;
		});
		console.log("Title: "+title);
		phantom.exit();

});
