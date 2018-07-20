angular.module('app', ['ngRoute', 'angularUtils.directives.dirPagination', '720kb.datepicker'])
    .config(function ($routeProvider) {

        $routeProvider.when('/cadastro', {
            templateUrl: '/partials/cadastro.html',
            controller: 'CadastroController'
        }).when('/editar/:idMembro', {
            templateUrl: '/partials/cadastro.html',
            controller: 'CadastroController'
        }).when('/lista', {
            templateUrl: '/partials/lista-de-membros.html',
            controller: 'ListaController'
        }).when('/dizimistas', {
            templateUrl: '/partials/dizimistas.html',
            controller: 'DizimistasController'
        }).when('/relatorios/dizimistas', {
            templateUrl: '/partials/relatorio-dizimistas.html',
            controller: 'RelatorioDizimistasController'
        }).otherwise({ redirectTo: '/' });
    });