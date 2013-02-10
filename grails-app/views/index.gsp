<!doctype html>
<html lang="en">
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
        <h2><span id="randomSongTitle">{{title}}</span></h2>
        Intro:
        {{#intro}}
        <span class="randomSongIntro">{{.}}</span>
        {{/intro}}</br>
        Verse:
        {{#verse}}
        <span id="randomSongVerse">{{.}}</span>
        {{/verse}}</br>
        Chorus:
        {{#chorus}}
        <span id="randomSongChorus">{{.}}</span>
        {{/chorus}}</br>
        Outro:
        {{#outro}}
        <span id="randomSongOutro">{{.}}</span>
        {{/outro}}</br>
        <span id="saveRandomSong" class="css_btn_class">Save</span>
    </script>

    <script id="songArchiveTemplate" type="text/template">
        <table>
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

<div id="status" align="center" role="complementary">
    <h1>Music Maker <g:meta name="app.version"/></h1>
    <input type="button" id="createRandomSong" class="btn btn-success" value="Create random song" />
    <input type="button" id="songArchive" class="btn btn-success" value="Song archive" />
    <input type="button" id="deleteAllSongs" class="btn btn-success" value="Delete all songs"/>
</div>

<div id="presentationArea" align="center" role="complementary"/>

<script>
    $(document).ready(function () {
        $("#createRandomSong").click(function () {
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
            var introParts = $(".randomSongIntro").map(
                    function () {
                        return $(this).text();
                    });
            var values = [];
            for(var i = 0; i < introParts.length; i++) {
                values[i] = introParts[i];
            }
            $.ajax({
                url: "/musicmaker/songs",
                contentType: "application/json",
                type: "POST",
                dataType: "json",
                data: JSON.stringify({
                    'title': $("#randomSongTitle").text(),
                    'intro': values,
                    'verse': $("#randomSongVerse").val(),
                    'chorus': $("#randomSongChorus").val(),
                    'outro': $("#randomSongOutro").val()
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
                type: "DELETE",
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