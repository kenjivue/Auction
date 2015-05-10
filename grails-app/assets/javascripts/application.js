/**
 * Created by Kenji Vue on 5/3//2015.
 */

//= require jquery/dist/jquery
//= require bootstrap/dist/js/bootstrap
//= require angular/angular
//= require angular-resource/angular-resource
//= require angular-route/angular-route
//= require angular-bootstrap/ui-bootstrap-tpls
//= require_self
//= require_tree .

angular.module("app", ["ngRoute", "ngResource", "ui.bootstrap"]);

if (typeof jQuery !== 'undefined') {
    (function($) {
        $('#spinner').ajaxStart(function() {
            $(this).fadeIn();
        }).ajaxStop(function() {
            $(this).fadeOut();
        });
    })(jQuery);
}