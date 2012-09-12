

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>MongoDB Examples</title>
</head>
<body>

<h1>Examples</h1>
<p>View the source to see the Mongo queries that produce this output. The Collection contains ${totalRows} records.</p>

<h2>States with Population Larger Than 10 Million</h2>
    %{--<p> ${statesWithPopulation}</p>--}%
    <ul class="bullets">
    <g:each in="${statesWithPopulation}" var="state">
        <li><b>${state._id}</b> -- ${state.totalPop} </li>
    </g:each>
    </ul>
<h2>Population by State</h2>
%{--<p>${avgCityPopulation}</p>--}%
    <ul class="bullets">
        <g:each in="${avgCityPopulation}" var="state">
            <li><b>${state._id}</b> -- ${state.avgCityPop} </li>
        </g:each>
    </ul>

<h2>Min/Max City Population by State</h2>
    <ul class="bullets">
        <g:each in="${minMaxCityPopulation}" var="state">
            <li><b>${state.state}</b>
                <ul class="bullets">
                    <li>${state.biggestCity.name} : ${state.biggestCity.pop}</li>
                    <li>${state.smallestCity.name} : ${state.smallestCity.pop}</li>
                </ul>
            </li>
        </g:each>
    </ul>
</body>
</html>