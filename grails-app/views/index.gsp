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
        font-size: 1.1em;
        text-decoration: underline;
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
    
 
.css_btn_class {
	font-size:16px;
	font-family:Arial;
	font-weight:normal;
	-moz-border-radius:8px;
	-webkit-border-radius:8px;
	border-radius:8px;
	border:1px solid #dcdcdc;
	padding:9px 18px;
	text-decoration:none;
	background:-webkit-gradient( linear, left top, left bottom, color-stop(5%, #ededed), color-stop(100%, #dfdfdf) );
	background:-moz-linear-gradient( center top, #ededed 5%, #dfdfdf 100% );
	background:-ms-linear-gradient( top, #ededed 5%, #dfdfdf 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ededed', endColorstr='#dfdfdf');
	background-color:#ededed;
	color:#777777;
	display:inline-block;
	text-shadow:1px 1px 0px #ffffff;
 	-webkit-box-shadow:inset 1px 1px 0px 0px #ffffff;
 	-moz-box-shadow:inset 1px 1px 0px 0px #ffffff;
 	box-shadow:inset 1px 1px 0px 0px #ffffff;
}.css_btn_class:hover {
	background:-webkit-gradient( linear, left top, left bottom, color-stop(5%, #dfdfdf), color-stop(100%, #ededed) );
	background:-moz-linear-gradient( center top, #dfdfdf 5%, #ededed 100% );
	background:-ms-linear-gradient( top, #dfdfdf 5%, #ededed 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#dfdfdf', endColorstr='#ededed');
	background-color:#dfdfdf;
}.css_btn_class:active {
	position:relative;
	top:1px;
}
 
    
    
    
    </style>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>

<body>



<div align="center" id="status" role="complementary">
    <h1>Music Maker <g:meta name="app.version"/></h1>    
        <span id="createSong" class="clickable"><a href="#" class="css_btn_class">create new song</a></span> 
        <span id="listSongs" class="clickable"><a href="#" class="css_btn_class">list old songs</a></span>
    <div align="center" id="song"/>
</div>



<div align="center" id="list" role="complementary">
    <div align="center" id="songList"/>
</div>









<script>
    $("#createSong").click(function () {
        $.getJSON("/musicmaker/song.json", function (result) {
            $("#songList").html("<h2>" + result.title + "</h2>" + "Intro: " + result.intro + "<br>Verse: " +
                    result.verse + "<br>Chorus: " + result.chorus + "<br>Outro: " + result.outro);
        });
        $("#songList").html("")
    });

    $("#listSongs").click(function () {
        $.getJSON("/musicmaker/song/list.json", function (result) {
            $("#songList").html("")
            $.each(result, function (i, field) {
                $("#songList ").append(field.title + "<br>");
            });
        });
        $("#song").html("")
    });

 
    
</script>

</body>
</html>
