<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html"
      xmlns="http://www.w3.org/1999/html">
<head>

    <style>
    .chordSelect {
        font-size: 11px;
        width: 50px;
        vertical-align: bottom !important;
        height: 20px !important;
    }

    .column {
        width: 2000px !important;
    }

    .row {
        height: 30px;
    }

    body {
        background-image: url('img/knappar.jpg');
    }

    select {
    }

    .chordButton {
        width: 35px !important;

    }
    </style>

    <title>Music Maker</title>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="keywords" content="">

    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/css/bootstrap-combined.min.css" rel="stylesheet">
    <link rel="shortcut icon" href="img/M.ico">

    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/mustache.js/0.7.0/mustache.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.0/js/bootstrap.min.js"></script>
    <g:javascript src="songevents.js"/>
</head>

<body>

<audio controls>
    <source src="sound/apa.mp3" type="audio/mpeg">
    <source src="sound/apa.ogg" type="audio/ogg">
    Your browser does not support the audio element.
</audio>

<div class="navbar navbar-inverse" span8 offset3>
    <div class="navbar-inner">
        <ul class="nav">
            <ul class="nav"><li><a href="#" id="aboutModal">About</a></li></ul>
        </ul>
    </div>
</div>

<div class="container-fluid span8 offset1" id="menuarea"/>

<h1>Music Maker</h1>
<input type="button" id="login" class="btn btn-success" value="Login"/>
<br><br>
</div>

<div id="presentationArea" class="container-fluid span8 offset1"/>

</body>
</html>