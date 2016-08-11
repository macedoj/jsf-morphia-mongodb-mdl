/*
 * 
 The MIT License
 
 Copyright 2016, Juliano Macedo.
 See LICENSE file for details.
 
 */

/* 
 Created on : Aug 10, 2016, 10:34:54 PM
 Author     : Juliano Macedo
 */


$(document).ready(function () {
    $('#formsubscribe').trigger("reset");

    $("#formunsubscription").trigger("reset");

    $("#formsurvey").trigger("reset");

    $("#subscribe").hide();

    $("#btnshowsubscribe").click(function () {
        $("#subscribe").slideToggle(1000);
    });
});

$(document).on("pageload", function () {
    $('#formsubscribe').trigger("reset");

    $("#formunsubscription").trigger("reset");

    $("#formsurvey").trigger("reset");
});