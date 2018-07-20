angular.module('app').controller('DizimistasController', function ($scope, $http, $rootScope) {

    $scope.count = 0;
    $scope.dizimo = [];
    $scope.dizimista = [];
    $rootScope.mensagem = '';

    function fechaModalSucesso() {
        window.setTimeout(function () {
            $(".alert").hide();
        }, 4000);
    }

    function abreModalSucesso() {
        $(".alert").show();
    }

    $scope.addInput = function (dizimo) {

        if (!$scope.dizimista[$scope.count]) {
            var data = new Date();
            var mes = data.getMonth() + 1;
            var obj = { nome: dizimo[$scope.count].nome, valor: dizimo[$scope.count].valor, data: data.getDate() + '/' + mes + '/' + data.getFullYear() };
            $scope.dizimista.push(obj);
        }
        $scope.count++;
        $scope.dizimo[$scope.count] = [];
    }

    $scope.removeInput = function (dizimo) {

        if ($scope.count == 6) {
            $scope.count--;
        }

        $scope.dizimista.splice(dizimo, 1)
        $scope.count--;

    }

    $scope.submeter = function () {
        $http.post('/secretaria/dizimo', $scope.dizimista)
            .then(function (response) {
                console.log('cadastrou');
                $rootScope.mensagem = { id: 0, mensagem: 'Cadastrado com sucesso' };
                abreModalSucesso();
                fechaModalSucesso();
                $scope.count = 0;
                $scope.dizimo = [];
                $scope.dizimista = [];
            }, function (error) {
                console.log('não cadastrou');
            })
    }

})