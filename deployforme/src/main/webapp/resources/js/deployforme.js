/*
 * The MIT License
 * 
 * Copyright 2016, Juliano Macedo.
 * See LICENSE file for details.
 */

/* 
 * Created on : Aug 10, 2016, 10:34:54 PM
 * Author     : Juliano Macedo
 */


/*
 * global  $:false 
 */ 
$(document).ready(function () {
    $('subscribe').hide();
    
    $('#btnshowsubscribe').click(function () {
      $('#subscribe').slideToggle(1000);
    });

    window.paceOptions = {
      restartOnPushState: true,
      startOnPageLoad: true,
      ajax: true
    };
});