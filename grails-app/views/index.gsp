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
    td {
        width: 250px;
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

    <script id="editSongTitleTemplate" type="text/template">
        <input class="songTitle" value="{{title}}"/>
    </script>

    <script id="songTemplate" type="text/template">
        <div class="well">
            <table class="table-striped table-hover table-condensed">
                <tr>
                    <td id="songTitle" colspan={{colSpan}}>
                        <input class="songTitle" type="hidden" value="{{song.title}}"/>
                        <b>{{song.title}}</b>
                    </td>
                    <td>
                        <input id="editSongTitle" type="button" class="btn btn-success" value="Edit"/>
                    </td>
                </tr>
                <tr>
                    <td>Intro:</td>
                    {{#song.intro}}
                    <td id="songIntro" class="span2">
                        <input type="button" style="width: 35px " class="songIntro editPartOfSong btn btn-mini" value="{{.}}"/>
                    </td>
                    {{/song.intro}}
                </tr>
                <tr>
                    <td>Verse:</td>
                    {{#song.verse}}
                    <td id="songVerse" class="span2">
                        <input type="button" style="width: 35px " class="songVerse editPartOfSong btn btn-mini" value="{{.}}"/>
                    </td>
                    {{/song.verse}}
                </tr>
                <tr>
                    <td>Chorus:</td>
                    {{#song.chorus}}
                    <td id="songChorus" class="span2">
                        <input type="button" style="width: 35px " class="songChorus editPartOfSong btn btn-mini" value="{{.}}"/>
                    </td>
                    {{/song.chorus}}
                </tr>
                <tr>
                    <td>Outro:</td>
                    {{#song.outro}}
                    <td id="songOutro" class="span2">
                        <input type="button" style="width: 35px " class="songOutro editPartOfSong btn btn-mini" value="{{.}}"/>
                    </td>
                    {{/song.outro}}
                </tr>
                <td colspan={{colSpan}}>
                    Original composition by: <input id="songAuthor" value="{{song.author}}"/>
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
                        <input id="deleteSongs" type="button" class="btn btn-danger" value="Delete All"/>
                    </td>
                </tr>
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
            <ul class="nav"><li><a href="#" id="aboutModal">About</a></li></ul>
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

<div id="presentationArea" class="container-fluid span8 offset1"/>

<script>
    function getTextValuesFromElementArray(elementArray) {
        return elementArray.map(
                function () {
                    return $(this).val();
                }).toArray();
    }

    function renderSong(song, saveAction) {
        var maxLength = song.intro.length;
        if (song.verse.length > maxLength) maxLength = song.verse.length;
        if (song.chorus.length > maxLength) maxLength = song.chorus.length;
        if (song.outro.length > maxLength) maxLength = song.outro.length;
        var template = $('#songTemplate').html();
        var html = Mustache.to_html(template, {song: song,
            saveAction: saveAction,
            colSpan: maxLength});
        $('#presentationArea').html(html);
    }

    function saveSong(url, method) {
        return $.ajax({
            url: url,
            contentType: "application/json",
            type: method,
            dataType: "json",
            data: JSON.stringify({
                'title': $(".songTitle").val(),
                'intro': getTextValuesFromElementArray($(".songIntro")),
                'verse': getTextValuesFromElementArray($(".songVerse")),
                'chorus': getTextValuesFromElementArray($(".songChorus")),
                'outro': getTextValuesFromElementArray($(".songOutro")),
                'author': $("#songAuthor").val()
            })
        });
    }

    function getSongById(songId) {
        $.getJSON("/musicmaker/songs/" + songId, function (song) {
            renderSong(song, "saveExistingSong");
            $("#saveExistingSong").prop('disabled', true);
        });
    }

    function renderSongArchive() {
        $.getJSON("/musicmaker/songs", function (songs) {
            $("#presentationArea").empty();
            var template = $('#songArchiveTemplate').html();
            var html = Mustache.to_html(template, {songs: songs});
            $('#presentationArea').html(html);
        });
    }

    function deleteSong(url) {
        $.ajax({
            url: url,
            contentType: "application/json",
            type: "DELETE"
        })
                .fail(function (jqXHR, textStatus) {
                    alert(jqXHR + " " + textStatus);
                }).success(function () {
                    renderSongArchive();
                });
    }

    $(document).ready(function () {
        $("#generateRandomSong").click(function () {
            $.getJSON("/musicmaker/songs/random", function (song) {
                renderSong(song, "saveRandomSong");
            });
        });

        $("body").on("click", ".viewSong", function () {
            var columns = $(this).parents("tr").children("td");
            var songId = columns.last().children("input").val();
            getSongById(songId);
        });

        $("body").on("click", "#editSongTitle", function () {
            var songTitle = $("#songTitle").text().trim();
            var template = $("#editSongTitleTemplate").html();
            var editSongHtml = Mustache.to_html(template, {title: songTitle});
            $("#songTitle").html(editSongHtml);
            $(".saveSongButton").prop('disabled', false);
        });

        $("body").on("click", ".editPartOfSong", function () {
            var songPart = $(this).parents("td");
            var songPartId = songPart.attr('id');
            var chordsSelect;
            $.getJSON("/musicmaker/chords", function (chords) {
                var template = $('#chordsTemplate').html();
                chordsSelect = Mustache.to_html(template, {chords: chords, songPartId: songPartId});
                songPart.html(chordsSelect);
                $(".saveSongButton").prop('disabled', false);
            });
        });

        $("body").on("click", "#saveRandomSong", function () {
            var songId;
            saveSong("/musicmaker/songs", "POST")
                    .fail(function (jqXHR, textStatus) {
                        alert(jqXHR + " " + textStatus);
                    })
                    .success(function (result) {
                        $(".saveSongButton").prop('disabled', true);
                        getSongById(result.songId);
                    });
        });

        $("#songArchive").click(function () {
            renderSongArchive();
        });

        $("body").on("click", "#saveExistingSong", function () {
            var columns = $(this).parents("tr").children("td");
            var songId = $("#songId").val();
            saveSong("/musicmaker/songs/" + songId, "PUT")
                    .fail(function (jqXHR, textStatus) {
                        alert(jqXHR + " " + textStatus);
                    })
                    .success(function () {
                        $("#saveExistingSong").prop('disabled', true);
                        getSongById(songId);
                    });
        });

        $("body").on("click", ".deleteSong", function () {
            var columns = $(this).parents("tr").children("td");
            var songId = columns.last().children("input").val();
            deleteSong("/musicmaker/songs/" + songId);
        });

        $("body").on("click", "#deleteSongs", function () {
            deleteSong("/musicmaker/songs");
        });

        $("#about_variant").click(function () {
            var template = $('#aboutTemplate').html();
            var html = Mustache.to_html(template);
            $('#presentationArea').html(html);
        });

        $("#aboutModal").click(function () {
            $('#about').modal('show');
        });
    });
</script>

</body>
</html>