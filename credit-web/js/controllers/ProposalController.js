angular.module('app')
    .controller('ProposalController', function ($scope, $location, $http) {

        $scope.customer = {
            gender:  'M',
            maritalStatus: 'solteiro',
			state: 'SC'
        };
        $scope.config = {
            maritalStatus: [
                { name: 'Solteiro', value: 'solteiro' },
                { name: 'Casado', value: 'casado' },
				{ name: 'Divorciado', value: 'divorciado' },
                { name: 'Viúvo', value: 'viuvo' },
            ],
            gender: [
                { name: 'Masculino', value: 'M' },
                { name: 'Feminino', value: 'F' }
            ],
			state: [
                { name: 'Acre', value: 'AC' },
				{ name: 'Alagoas', value: 'AL' },
				{ name: 'Amapá', value: 'AP' },
				{ name: 'Amazonas', value: 'AM' },
				{ name: 'Bahia', value: 'BA' },
				{ name: 'Ceará', value: 'CE' },
				{ name: 'Distrito Federal', value: 'DF' },
				{ name: 'Espírito Santo', value: 'ES' },
				{ name: 'Goiás', value: 'GO' },
				{ name: 'Maranhão', value: 'MA' },
				{ name: 'Mato Grosso', value: 'MT' },
				{ name: 'Mato Grosso do Sul', value: 'MS' },
				{ name: 'Minas Gerais', value: 'MG' },
				{ name: 'Pará', value: 'PA' }, 
				{ name: 'Paraíba', value: 'PB' },
				{ name: 'Paraná', value: 'PR' },
				{ name: 'Pernambuco', value: 'PE' },
				{ name: 'Piauí', value: 'PI' },
				{ name: 'Rio de Janeiro', value: 'RJ' },
				{ name: 'Rio Grande do Norte', value: 'RN' },
				{ name: 'Rio Grande do Sul', value: 'RS' },
				{ name: 'Rondônia', value: 'RO' },
				{ name: 'Roraima', value: 'RR' },
				{ name: 'Santa Catarina', value: 'SC' },
				{ name: 'São Paulo', value: 'SP' },
				{ name: 'Sergipe', value: 'SE' },
				{ name: 'Tocantins', value: 'TO' }
            ]
			
        };

        $scope.submit = function () {
            $http.post('http://localhost:8090/api/credit-controller/processProposal', $scope.customer).then(function(response) {
					console.log(response.data);
					$location.path('/'); 
				}, function(response) {
					console.log(response.data);
				});
        };
    });