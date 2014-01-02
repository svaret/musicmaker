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
        background-image: url("${resource(dir: 'img', file: 'knappar.jpg')}");
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

    <script id="chordsTemplate" type="text/template">
        <select class="chordSelect btn-mini {{songPartId}}">
            {{#chords}}
            <option value="{{chord}}">{{chord}}</option>
            {{/chords}}
        </select>
    </script>

    <script id="editSongTitleTemplate" type="text/template">
        <input class="songTitle" value="{{title}}"/>
    </script>

    <script id="editSongAuthorTemplate" type="text/template">
        <input class="songAuthor" value="{{author}}"/>
    </script>

    <script id="songTemplate" type="text/template">
        <div class="well">
            <table class="table-striped table-hover table-condensed">
                <tr>
                    <td>
                        <input id="editSongTitle" type="button" class="btn btn-mini btn-success" value="Edit"/>
                    </td>
                    <td id="songTitle" colspan={{colSpan}}>
                        <input class="songTitle" type="hidden" value="{{song.title}}"/>
                        <b>{{song.title}}</b>
                    </td>
                </tr>
                <tr class="row">
                    <td>Intro:</td>
                    {{#song.intro}}
                    <td id="songIntro" class="span2 column">
                        <input type="button" class="chordButton songIntro editPartOfSong btn btn-mini"
                               value="{{.}}"/>
                    </td>
                    {{/song.intro}}
                </tr>
                <tr class="row">
                    <td>Verse:</td>
                    {{#song.verse}}
                    <td id="songVerse" class="span2 column">
                        <input type="button" class="chordButton songVerse editPartOfSong btn btn-mini"
                               value="{{.}}"/>
                    </td>
                    {{/song.verse}}
                </tr>
                <tr class="row">
                    <td>Chorus:</td>
                    {{#song.chorus}}
                    <td id="songChorus" class="span2 column">
                        <input type="button" class="chordButton songChorus editPartOfSong btn btn-mini"
                               value="{{.}}"/>
                    </td>
                    {{/song.chorus}}
                </tr>
                <tr class="row">
                    <td>Outro:</td>
                    {{#song.outro}}
                    <td id="songOutro" class="span2 column">
                        <input type="button" class="chordButton songOutro editPartOfSong btn btn-mini"
                               value="{{.}}"/>
                    </td>
                    {{/song.outro}}
                </tr>
                <td>
                    <input id="editSongAuthor" type="button" class="btn btn-mini btn-success" value="Edit"/>
                </td>
                <td id="songAuthor" colspan={{colSpan}}>
                    <input class="songAuthor" type="hidden" value="{{song.author}}"/>
                    <b>{{song.author}}</b>
                </td>
            </table>
        </div>
        <input type="button" id="{{saveAction}}" class="btn btn-success saveSongButton" value="Save"/>
        <input id="songId" value="{{song._id.$oid}}" type="hidden">
    </script>

    <script id="songArchiveTemplate" type="text/template">
        <div class="well">
            <table class="table table-striped table-hover table-condensed">
                <tr>
                    <td colspan="4">
                        <input id="deleteSongs" type="button" class="btn btn-mini btn-danger" value="Delete All"/>
                    </td>
                </tr>
                {{#songs}}
                <tr>
                    <td>{{title}}</td>
                    <td>{{author}}</td>
                    <td><input type="button" class="btn btn-mini btn-success viewSong" value="View"/></td>
                    <td><input type="button" class="btn btn-danger btn-mini deleteSong" value="Delete"/></td>
                    <td><input value="{{_id.$oid}}" type="hidden"></td>
                </tr>
                {{/songs}}
            </table>
        </div>
    </script>

    <script id="aboutTemplate" type="text/template">
        <div class="well">
            <table class="table">
                <tr>
                    <td>About Music Maker</td>
                    <td>Version X</td>
                </tr>
            </table>
        </div>
    </script>

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
            <input type="button"
                   id="login"
                   class="btn btn-success"
                   value="Login with Google Account"/>
        </ul>
        <ul class="nav">
            <input type="button"
                   id="logout"
                   class="btn btn-success"
                   value="Logout from Google Account"
                   hidden="true"/>
        </ul>
        <ul class="nav">
            <li><a href="#" id="aboutModal">About</a></li>
        </ul>
        <span style="background:black; color:white; vertical-align:middle;" id="username"/>
    </div>
</div>

<div class="container-fluid span8 offset1" id="menuarea"/>

<div id="loggedInActions"/>

<h1>Music Maker</h1>
<input type="button" id="generateRandomSong" class="btn btn-success" value="Generate new"/>
<input type="button" id="songArchive" class="btn btn-success" value="Song archive"/>
<br><br>
</div>

<div id="about" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="aboutLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <br>

        <div class="left"><img src="${resource(dir: 'img', file: 'leeperry.jpg')}" alt="Grails"/></div>

        <div class="right">
            Version: 0.1<br>
            Build Id:   <br>

            <div class="left"><img src="${resource(dir: 'img', file: 'nextit.png')}" alt="Grails"/></div>
            <img src="${resource(dir: 'img', file: 'M.ico')}" alt="Grails"/> usic
            <img src="${resource(dir: 'img', file: 'M.ico')}" alt="Grails"/> aker
        </div>
    </div>
</div>

<div id="presentationArea" class="container-fluid span8 offset1"/>

</body>
</html>