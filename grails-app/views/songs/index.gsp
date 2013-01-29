<!doctype html>
<%@ page import="musicmaker.SongsController" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Music Maker</title>
    <style type="text/css" media="screen">

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
        color: #000000;
    }

    h2 {
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
        #page-body h1 {
            margin-top: 0;
        }
    }
    </style>
</head>

<body>
<div align="center">
    <h2>
        ${song}
    </h2>
</div>
</body>
</html>
