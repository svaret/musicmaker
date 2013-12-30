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
            'author': $(".songAuthor").val()
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
    $.getJSON("/musicmaker/login/code", function (code) {
        if(code.code) {
            $("#login").hide();
            $("#logout").show();
            $("#username").text('lasse.e.bergstrom@gmail.com');
        }
    });

    $("#login").click(function () {
        $.getJSON("/musicmaker/login/login", function (result) {
            window.location.href = result.url;
        });
    });

    $("#logout").click(function () {
        $.getJSON("/musicmaker/login/logout", function (result) {
            $("#login").show();
            $("#logout").hide();
            $("#username").text('');
        });
    });

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
        $("#editSongTitle").prop('disabled', true);
        $(".saveSongButton").prop('disabled', false);
    });

    $("body").on("click", "#editSongAuthor", function () {
        var songAuthor = $("#songAuthor").text().trim();
        var template = $("#editSongAuthorTemplate").html();
        var editSongHtml = Mustache.to_html(template, {author: songAuthor});
        $("#songAuthor").html(editSongHtml);
        $("#editSongAuthor").prop('disabled', true);
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