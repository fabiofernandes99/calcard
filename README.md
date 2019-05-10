Sistema desenvolvido com os conceitos de Microsserviços, Restful e contrato para definir a comunicação entre as APIs (Swagger).

Foram usados Spring-boot para o servidor em Java e o OpenFeign para a integração entre os microsserviços.

Para a avaliação da proposta de crédito, escolhi a bibliotera Weka para inferir a melhor classificação, com o algoritmo Naive Bayes.

Por fim, o front-end foi desenvolvido utilizando nodejs, angular, html e bootstrap.

Obs: Não consegui finalizar o Front-end. Apenas tema a funcionalidade de cadastrar uma proposta. Para verificar as demais funcionalidades, usei o Postman. A seguir as urls:

http://localhost:8090/api/credit-controller/processProposal
Exemplo de JSON:
{
	"cpf": "123",
	"name": "João da Silva",
	"age": 68,
	"state": "SC",
	"numberOfDependents": 3,
	"income": 8000,
	"gender": "M",
	"maritalStatus": "casado"
}

http://localhost:8090/api/credit-controller/getAllProposals

http://localhost:8090/api/credit-controller/findProposal/123
