"use strict"
debugger;
var page = require('webpage').create();


page.open('http://www.pudelek.pl', function(status) {

		if(status==="success") {
			page.includeJs('http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js', function() {
					var links = page.evaluate(function(){
						var pageLinks = [];
						$('a').each(function () {	
							pageLinks.push(this.href);
						});
						return pageLinks; 
					});
					for (var i = 0, len = links.length; i < len; i++) {
						try {
							if (links[i].indexOf('pudelek.pl') !== -1) {

								console.log(""+links[i]);
							}

						} catch (err) {
							phantom.exit(1);
						}
					}
					phantom.exit();
					})
		}
		});

page.onLoadFinished = function(response) {
	console.log(response, page.url);
};
