angular.module('app').controller('ListaController', function ($scope, $http, $rootScope) {

    $scope.membros = [];
    $scope.filtro = '';
    $scope.mensagem2 = '';

    function fechaModalSucesso() {
        window.setTimeout(function () {
            $(".alert").hide();
        }, 4000);
    }

    function abreModalSucesso() {
        $(".alert").show();
    }

    $http.get('/secretaria/membro')
        .then(function (response) {
            $scope.membros = response.data;
        }).catch(function (error) {
            console.log(error);
        });

    $scope.excluir = function (membro) {
        $http.delete('/secretaria/membro/' + membro.id)
            .then(function (response) {
                var indice = $scope.membros.indexOf(membro);
                $scope.membros.splice(indice, 1);
                $scope.mensagem2 = 'Excluido com sucesso!';
                abreModalSucesso();
                fechaModalSucesso();
            }, function (error) {
                console.log(error);
            });
    }

})