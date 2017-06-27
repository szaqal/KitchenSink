var page=require('webpage').create();
page.open('http://www.pudelek.pl', function() {
			page.render('favicon.ico');
			phantom.exit();
		}

);
