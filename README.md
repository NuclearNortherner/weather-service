## Weather REST app

Weather app gets simplified data from www.openweathermap.org using REST.

For using it you need to register your own "appid" from https://openweathermap.org/api and past the appid in "weather.server.appid" property of application.properties file.

Two options to get data:
1. using html form - just add "/city_name". *Example - your_host:port/london*.
1. using REST - just add "/api/weather/city_name". *Example - your_host:port/api/weather/london*.

Default city - Gomel (aka Homyel on openweathermap.org)

Used tech stack:
-Java
-Spring MVC
-Jackson
-Bootstrap

--------------------------------------------

Author: Dmitry Blagushin (Dzmitry Blahushyn)