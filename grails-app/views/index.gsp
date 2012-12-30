<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Music Maker</title>
    <style type="text/css" media="screen">

    #status {
        background-color: #eee;
        border: .2em solid #fff;
        margin: 2em 2em 1em;
        padding: 1em;
        width: 30em;
        margin-left: auto;
        margin-right: auto;
        -moz-box-shadow: 0px 0px 1.25em #ccc;
        -webkit-box-shadow: 0px 0px 1.25em #ccc;
        box-shadow: 0px 0px 1.25em #ccc;
        -moz-border-radius: 0.6em;
        -webkit-border-radius: 0.6em;
        border-radius: 0.6em;
    }

    .ie6 #status {
        display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
    }

    #status ul {
        font-size: 0.9em;
        list-style-type: none;
        margin-bottom: 0.6em;
        padding: 0;
    }

    #status li {
        line-height: 1.3;
    }

    #status h1 {
        text-transform: uppercase;
        font-size: 1.1em;
        margin: 0 0 0.3em;
    }

    h2 {
        margin-top: 1em;
        margin-bottom: 0.3em;
        font-size: 1em;
    }

    #song {
        margin-top: 1em;
        margin-bottom: 0.3em;
        font-size: 1em;
    }

    p {
        line-height: 1.5;
        margin: 0.25em 0;
    }

    #controller-list ul {
        list-style-position: inside;
    }

    #controller-list li {
        line-height: 1.3;
        list-style-position: inside;
        margin: 0.25em 0;
    }

    @media screen and (max-width: 480px) {
        #status {
            display: none;
        }

        #page-body h1 {
            margin-top: 0;
        }
    }

    .clickable {
        text-decoration: underline;
        cursor: pointer;
        color: #48802C;
    }
    </style>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>

<body>

<div align="center" id="status" role="complementary">
    <h1>Music Maker <g:meta name="app.version"/></h1>
    <ul>
        <li>This program will create new music!</li>
        <span id="createSong" class="clickable">Click here to create a random tune</span>
    </ul>
    <div align="center" id="song"/>
</div>


<script>
    $("#createSong").click(function () {
        $.getJSON("/musicmaker/song.json", function (result) {
            $("#song").html(result.title + "<br>Intro: " + result.intro + "<br>Verse: " +
                    result.verse + "<br>Chorus: " + result.chorus + "<br>Outro: " + result.outro);
        });
    });
</script>

</body>
</html>
