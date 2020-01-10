# ResellFinderWeb
Resell Finder Web is a work in progress project that will allow users to scrape local listings and automatically determine which items are good reselling opportunities by cross referencing their average selling price on eBay and Amazon. This is a server-side full stack web application, there is a Java RESTfull api for scraping the data from the web using JSoup which will serve as the backend of the web application. The front-end has yet to be determined, it will either be made using a javascript framework or Django. 

The Java RestFull API is based on the craigslist webscraper code found here, of which I am a co-author: https://github.com/ryanjunglee1/CraigslistNotifier
