<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Weather</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="container">


    <br>

    <h2>Current weather in ${currentWeather.name}</h2>

    <br>


    <br>

    Your town: ${currentWeather.name}

    <br>
    <br>

    Temperature: ${currentWeather.main.temp}&deg;C

    <br>
    <br>

    Feels like: ${currentWeather.main.feels_like}&deg;C

    <br>
    <br>

    Wind: ${currentWeather.wind.speed} m/s

    <br>
    <br>

    Weather description: ${currentWeather.weather[0].description}

</div>

</body>
</html>
