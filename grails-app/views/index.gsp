<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html"
      xmlns="http://www.w3.org/1999/html">
<head>
    <style>
    .select-mini {
        font-size: 11px;
        height: 30px;
        width: 50px;
    }
    </style>

    <meta charset="UTF-8">
    <title>Music Maker</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="keywords" content="">

    <link href="css/bootstrap.css" rel="stylesheet">
    <link rel="shortcut icon" href="img/M.ico">

    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="http://github.com/janl/mustache.js/raw/master/mustache.js"></script>
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/js/bootstrap.min.js"></script>


    <script id="chordsTemplate" type="text/template">
        <select class="select-mini btn-mini {{songPartId}}">
            {{#chords}}
            <option value="{{chord}}">{{chord}}</option>
            {{/chords}}
        </select>
    </script>

    <script id="songTemplate" type="text/template">
        <div class="well">
            <table class="table-striped table-hover table-condensed">
                <tr>
                    <td colspan="13" id="randomSongTitle"><b>{{title}}</b></td>
                    <td><input type="button" class="editTitle btn btn-success" value="Edit"/></td>
                </tr>
                <tr>
                    <td>Intro:</td>
                    {{#intro}}
                    <td id="songIntro" class="span2">
                        <input type="button" class="songIntro editPartOfSong btn btn-mini" value="{{.}}"/>
                    </td>
                    {{/intro}}
                    <td align="right" colspan="11">
                        <input type="button" class="editPartOfSong btn btn-success" value="Edit"/>
                    </td>
                </tr>
                <tr>
                    <td>Verse:</td>
                    {{#verse}}
                    <td id="songVerse" class="span2">
                        <input type="button" class="songVerse editPartOfSong btn btn-mini" value="{{.}}"/>
                    </td>
                    {{/verse}}
                    <td align="right" colspan="8">
                        <input type="button" class="editPartOfSong btn btn-success" value="Edit"/>
                    </td>
                </tr>
                <tr>
                    <td>Chorus:</td>
                    {{#chorus}}
                    <td id="songChorus" class="span2">
                        <input type="button" class="songChorus editPartOfSong btn btn-mini" value="{{.}}"/>
                    </td>
                    {{/chorus}}
                    <td align="right" colspan="10">
                        <input type="button" class="editPartOfSong btn btn-success" value="Edit"/>
                    </td>
                </tr>
                <tr>
                    <td>Outro:</td>
                    {{#outro}}
                    <td id="songOutro" class="span2">
                        <input type="button" class="songOutro editPartOfSong btn btn-mini" value="{{.}}"/>
                    </td>
                    {{/outro}}
                    <td align="right">
                        <input type="button" class="editPartOfSong btn btn-success" value="Edit"/>
                    </td>
                </tr>
            </table>
        </div>
        <input type="button" id="saveRandomSong" class="btn btn-success" value="Save"/>
    </script>

    <script id="songArchiveTemplate" type="text/template">
        <div class="well">
            <table class="table table-striped table-hover table-condensed">
                {{#songs}}
                <tr>
                    <td>{{title}}</td>
                    <td><input type="button" class="btn btn-success viewSong" value="View"/></td>
                    <td><input type="button" class="btn btn-danger deleteSong" value="Delete"/></td>
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

<div class="navbar navbar-inverse" span8 offset3>
    <div class="navbar-inner">
        <ul class="nav">
            <li><a href="#">About</a></li>
        </ul>
    </div>
</div>

<div class="container-fluid span8 offset1" id="menuarea"/>

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

<div class="container-fluid span8 offset1" id="presentationArea"/>

<script>
    function getTextValuesFromElementArray(elementArray) {
        return elementArray.map(
                function () {
                    return $(this).val();
                }).toArray();
    }

    $(document).ready(function () {
        $("#generateRandomSong").click(function () {
            $.getJSON("/musicmaker/songs/random", function (song) {
                var template = $('#songTemplate').html();
                var html = Mustache.to_html(template, song);
                $('#presentationArea').html(html);
            });
        });

        $("body").on("click", ".viewSong", function () {
            var columns = $(this).parents("tr").children("td");
            var songId = columns.last().children("input").val();
            $.getJSON("/musicmaker/songs/" + songId, function (result) {
                var template = $('#songTemplate').html();
                var html = Mustache.to_html(template, result);
                $('#presentationArea').html(html);
            });
        });

        $("body").on("click", ".editPartOfSong", function () {
            var songPart = $(this).parents("td");
            var songPartId = songPart.attr('id');
            var chordsSelect;
            $.getJSON("/musicmaker/chords", function (chords) {
                var template = $('#chordsTemplate').html();
                chordsSelect = Mustache.to_html(template, {chords: chords, songPartId: songPartId});
                songPart.html(chordsSelect);
            });
        });

        $("body").on("click", "#saveRandomSong", function () {
            $.ajax({
                url: "/musicmaker/songs",
                contentType: "application/json",
                type: "POST",
                dataType: "json",
                data: JSON.stringify({
                    'title': $("#randomSongTitle").text(),
                    'intro': getTextValuesFromElementArray($(".songIntro")),
                    'verse': getTextValuesFromElementArray($(".songVerse")),
                    'chorus': getTextValuesFromElementArray($(".songChorus")),
                    'outro': getTextValuesFromElementArray($(".songOutro"))
                })
            })
                    .fail(function (jqXHR, textStatus) {
                        alert(jqXHR + " " + textStatus);
                    })
                    .success(function () {
                        $("#saveRandomSong").prop('disabled', true);
                    });
        });

        $("#songArchive").click(function () {
            $.getJSON("/musicmaker/songs", function (songs) {
                $("#presentationArea").empty();
                var template = $('#songArchiveTemplate').html();
                var html = Mustache.to_html(template, {songs: songs});
                $('#presentationArea').html(html);
            });
        });

        $("body").on("click", ".updateSong", function () {
            var columns = $(this).parents("tr").children("td");
            var songId = columns.last().children("input").val();
            var title = columns.first().children("input").val();
            $.ajax({
                url: "/musicmaker/songs/" + songId,
                contentType: "application/json",
                type: "PUT",
                dataType: "json",
                data: JSON.stringify({'title': title})
            }).fail(function (jqXHR, textStatus) {
                        alert(jqXHR + " " + textStatus);
                    });
        });

        $("body").on("click", ".deleteSong", function () {
            var columns = $(this).parents("tr").children("td");
            var songId = columns.last().children("input").val();
            $.ajax({
                url: "/musicmaker/songs/" + songId,
                contentType: "application/json",
                type: "DELETE"
            }).fail(function (jqXHR, textStatus) {
                        alert(jqXHR + " " + textStatus);
                    });
            $.getJSON("/musicmaker/songs", function (songs) {
                $("#presentationArea").empty();
                var template = $('#songArchiveTemplate').html();
                var html = Mustache.to_html(template, {songs: songs});
                $('#presentationArea').html(html);
            });

        });

        $("#about").click(function () {
            var template = $('#aboutTemplate').html();
            var html = Mustache.to_html(template);
            $('#presentationArea').html(html);
        });
    });
</script>

</body>
</html>