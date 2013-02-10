<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html"
      xmlns="http://www.w3.org/1999/html">
<head>
	<meta charset="UTF-8">
	<title>Music Maker</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="keywords" content="">

	<link href="css/bootstrap.css" rel="stylesheet">
</head>

    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="http://github.com/janl/mustache.js/raw/master/mustache.js"></script>
   	<script src="js/bootstrap.js"></script>

   <script id="randomSongTemplate" type="text/template">
   <div class="well">
        <table class="table table-bordered">
            <b><th id="randomSongTitle">{{title}}</th></b>
            <tr>
                <td>Intro:</td>
                {{#intro}}
                <td><span class="randomSongIntro">{{.}}</span></td>
                {{/intro}}</br>
            </tr>
            <tr>
                <td>Verse:</td>
                {{#verse}}
                <td><span class="randomSongVerse">{{.}}</span></td>
                {{/verse}}</br>
            </tr>
            <tr>
                <td>Chorus:</td>
                {{#chorus}}
                <td><span class="randomSongChorus">{{.}}</span></td>
                {{/chorus}}</br>
            </tr>
            <tr>
                <td>Outro:</td>
                {{#outro}}
                <td><span class="randomSongOutro">{{.}}</span></td>
                {{/outro}}</br>
            </tr>
        </table>
        </div>
        <input type="button" id="saveRandomSong" class="btn btn-success" value="Save"/>
        <input type="button" id="editRandomSong" class="btn btn-success" value="Edit"/>
        <input type="button" id="generateNewRandomSong" class="btn btn-success" value="Generate new"/>
    </script>

    <script id="songArchiveTemplate" type="text/template">
        <table class="table table-striped table-hover table-condensed">
            {{#songs}}
            <tr>
                <td>{{title}}</td>
 			    <td><input type="button" id="editSong" class="btn btn-success editSong" value="Edit" /></td>
 			    <td><input type="button" id="deleteSong" class="btn btn-success deleteSong" value="Delete" /></td>
                <td><input value="{{_id.$oid}}" type="hidden"></td>
            </tr>
            {{/songs}}
        </table>
    </script>
</head>

<body>

 %{--<div class="navbar navbar-inverse" span8 offset3>--}%
  %{--<div class="navbar-inner ">--}%
   %{--<ul class="nav">--}%
    %{--<li><a href="#" id="createRandomSong">Create random song</a></li>--}%
    %{--<li><a href="#" id="songArchive">Song archive</a></li>--}%
    %{--<li><a href="#" id="deleteAllSongs">Delete all songs</a></li>--}%
   %{--</ul>--}%
  %{--</div>--}%
 %{--</div>--}%

<div class="container-fluid span8 offset1" id="menuarea"   />
    <h1>Music Maker <g:meta name="app.version"/></h1>
<input type="button" id="createRandomSong" class="btn btn-success" value="Create random song"/>
<input type="button" id="songArchive" class="btn btn-success" value="Song archive"/>
<br><br>
</div>

<div class="container-fluid span8 offset1" id="presentationArea"/>

<script>
    function getTextValuesFromElementArray(elementArray) {
        return elementArray.map(
            function () {
                return $(this).text();
             }).toArray();
    }

    $(document).ready(function () {
        $("#createRandomSong").click(function () {
            $.getJSON("/musicmaker/songs/random", function (result) {
                var template = $('#randomSongTemplate').html();
                var html = Mustache.to_html(template, result);
                $('#presentationArea').html(html);
            });
        });

        $("body").on("click", "#generateNewRandomSong", function () {
            var columns = $(this).parents("tr").children("td");
            var songId = columns.last().children("input").val();
            $.getJSON("/musicmaker/songs/random", function (result) {
                var template = $('#randomSongTemplate').html();
                var html = Mustache.to_html(template, result);
                $('#presentationArea').html(html);
            });
        });

        $("body").on("click", ".editSong", function () {
            var columns = $(this).parents("tr").children("td");
            var songId = columns.last().children("input").val();
            $.getJSON("/musicmaker/songs/" + songId, function (result) {
                var template = $('#randomSongTemplate').html();
                console.log(result.title);
                var html = Mustache.to_html(template, result);
                $('#presentationArea').html(html);
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
                    'intro': getTextValuesFromElementArray($(".randomSongIntro")),
                    'verse': getTextValuesFromElementArray($(".randomSongVerse")),
                    'chorus': getTextValuesFromElementArray($(".randomSongChorus")),
                    'outro': getTextValuesFromElementArray($(".randomSongOutro"))
                })
            }).fail(function (jqXHR, textStatus) {
                        alert(jqXHR + " " + textStatus);
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

        $("#deleteAllSongs").click(function () {
            $.ajax({
                url: "/musicmaker/songs",
                type: "DELETE"
            }).fail(function (jqXHR, textStatus) {
                        alert(jqXHR + " " + textStatus);
                    });
            $("#presentationArea").html("");
        });

        $("#chordSelect").change(function () {
            alert("Du valde: " + $("#chordSelect").val());
        });

        $.getJSON("/musicmaker/chords", function (result) {
            var options = $("#chordSelect");
            $.each(result, function () {
                options.append($("<option />").val(this.chord).text(this.chord));
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


    });
</script>

</body>
</html>