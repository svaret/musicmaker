<!doctype html>
<html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
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
        font-size: 1.1em;
        text-decoration: underline;
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

    .css_btn_class {
        cursor: pointer;
        font-size: 16px;
        font-family: Arial;
        font-weight: normal;
        -moz-border-radius: 8px;
        -webkit-border-radius: 8px;
        border-radius: 8px;
        border: 1px solid #dcdcdc;
        padding: 9px 18px;
        text-decoration: none;
        background: -webkit-gradient(linear, left top, left bottom, color-stop(5%, #ededed), color-stop(100%, #dfdfdf));
        background: -moz-linear-gradient(center top, #ededed 5%, #dfdfdf 100%);
        background: -ms-linear-gradient(top, #ededed 5%, #dfdfdf 100%);
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr = '#ededed', endColorstr = '#dfdfdf');
        background-color: #ededed;
        color: #777777;
        display: inline-block;
        text-shadow: 1px 1px 0px #ffffff;
        -webkit-box-shadow: inset 1px 1px 0px 0px #ffffff;
        -moz-box-shadow: inset 1px 1px 0px 0px #ffffff;
        box-shadow: inset 1px 1px 0px 0px #ffffff;
    }

    .css_btn_class:hover {
        cursor: pointer;
        background: -webkit-gradient(linear, left top, left bottom, color-stop(5%, #dfdfdf), color-stop(100%, #ededed));
        background: -moz-linear-gradient(center top, #dfdfdf 5%, #ededed 100%);
        background: -ms-linear-gradient(top, #dfdfdf 5%, #ededed 100%);
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr = '#dfdfdf', endColorstr = '#ededed');
        background-color: #dfdfdf;
    }

    .css_btn_class:active {
        cursor: pointer;
        position: relative;
        top: 1px;
    }
    </style>

    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="http://github.com/janl/mustache.js/raw/master/mustache.js"></script>

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
                <td><button class="updateSong">Save</button></td>
                <td><input value="{{_id.$oid}}" type="hidden"></td>
            </tr>
            {{/songs}}
        </table>
    </script>
</head>

<body>

<div id="status" align="center" role="complementary">
    <h1>Music Maker <g:meta name="app.version"/></h1>
    <span id="createRandomSong" class="css_btn_class">Create random song</span>
    <span id="songArchive" class="css_btn_class">Song archive</span>
    <select id="chordSelect"></select>
    <span id="deleteAllSongs" class="css_btn_class">Delete all songs</span>
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

        $("body").on("click", "#saveRandomSong", function () {
            var introParts = $(".randomSongIntro").map(
                    function () {
                        return $(this).text();
                    });
            console.log(introParts);
            var apa = [];
            for(var i = 0; i < introParts.length; i++) {
                apa[i] = introParts[i];
            }
            $.ajax({
                url: "/musicmaker/songs",
                contentType: "application/json",
                type: "POST",
                dataType: "json",
                data: JSON.stringify({
                    'title': $("#randomSongTitle").text(),
                    'intro': apa,
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
    });
</script>

</body>
</html>