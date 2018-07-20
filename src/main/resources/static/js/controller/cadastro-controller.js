angular.module('app').controller('CadastroController', function ($scope, $http, $routeParams, $location, $rootScope) {

    $scope.exibirHistorico = false;
    $scope.filtro = '';
    $rootScope.mensagem = '';

    function fechaModalSucesso() {
        window.setTimeout(function () {
            $(".alert").hide();
            }, 4000);
    }

    function abreModalSucesso() {
            $(".alert").show();
    }

    $scope.membro = {};

    $scope.submeter = function () {
        if ($routeParams.idMembro) {
            $http.put('/secretaria/membro', $scope.membro)
                .then(function (response) {
                    $scope.membro = {};
                    $rootScope.mensagem = {id: 1, mensagem: 'Membro alterado com sucesso!'};
                    abreModalSucesso()
                    fechaModalSucesso();
                    $location.path('/lista');
                }), function (erro) {
                    console.log(erro.data);
                }
        } else {
            $http.post('/secretaria/membro', $scope.membro)
                .then(function (response) {
                    $scope.membro = {};
                    $rootScope.mensagem = {id: 0,mensagem: 'Membro cadastrado com sucesso!'};
                    abreModalSucesso()
                    fechaModalSucesso();
                }, function (erro) {
                    console.log(erro.data);
                });
        }
    }

    if($routeParams.idMembro){
    $http.get('/secretaria/membro/' + $routeParams.idMembro)
        .then(function (response) {
            $scope.membro = response.data;
        }).catch(function (erro) {
            console.log(erro);
        });
    }


});