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

    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="http://github.com/janl/mustache.js/raw/master/mustache.js"></script>
   	<script src="js/bootstrap.js"></script>

   <script id="randomSongTemplate" type="text/template">
   <div class="well">
        <table class="table table-bordered">
            <tr>
                <td colspan="13" id="randomSongTitle"><b>{{title}}</b></td>
                <td><input type="button" class="editTitle btn btn-success" value="Edit"/></td>
            </tr>
            <tr>
                <td>Intro:</td>
                {{#intro}}
                <td><span class="randomSongIntro">{{.}}</span></td>
                {{/intro}}</br>
                <td></td><td></td><td></td><td></td><td></td>
                <td></td><td></td><td></td><td></td><td></td>
                <td><input type="button" class="editIntro btn btn-success" value="Edit"/></td>
            </tr>
            <tr>
                <td>Verse:</td>
                {{#verse}}
                <td><span class="randomSongVerse">{{.}}</span></td>
                {{/verse}}</br>
                <td></td><td></td><td></td><td></td><td></td><td></td><td></td>
                <td><input type="button" class="editVerse btn btn-success" value="Edit"/></td>
            </tr>
            <tr>
                <td>Chorus:</td>
                {{#chorus}}
                <td><span class="randomSongChorus">{{.}}</span></td>
                {{/chorus}}</br>
                <td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
                <td><input type="button" class="editVerse btn btn-success" value="Edit"/></td>
            </tr>
            <tr>
                <td>Outro:</td>
                {{#outro}}
                <td><span class="randomSongOutro">{{.}}</span></td>
                {{/outro}}</br>
                <td><input type="button" class="editVerse btn btn-success" value="Edit"/></td>
            </tr>
        </table>
        </div>
        <input type="button" id="saveRandomSong" class="btn btn-success" value="Save"/>
        <input type="button" id="editRandomSong" class="btn btn-success" value="Edit"/>
        <input type="button" id="generateNewRandomSong" class="btn btn-success" value="Generate new"/>
    </script>

    <script id="songArchiveTemplate" type="text/template">
        <div class="well">
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
        </div>
    </script>
</head>

<body>

<div class="container-fluid span8 offset1" id="menuarea"   />
    <h1>Music Maker</h1>
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
            $.getJSON("/musicmaker/songs/random", function (song) {
                var template = $('#randomSongTemplate').html();
                var html = Mustache.to_html(template, song);
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


    });
</script>

</body>
</html>