#language: pt

Funcionalidade: Busca no Banco de Questões
		
Cenário: Busca por questão inexistente

	Dado que navego para a página de busca do banco de questões
	E digito 'Science: Computers' no campo de busca
	Quando clico no botão de buscar
	Então visualizo uma mensagem de erro com o texto 'No questions found.'
	
Cenário: Busca por categoria

	Dado que navego para a página de busca do banco de questões
	E digito 'Science: Computers' no campo de busca
	E seleciono a opção 'Category'
	Quando clico no botão de buscar
	Então verifico se a listagem de questões está com 25 itens 
	E se o controle de paginação irá aparecer
	
Cenário: Verifica a quantidade de questões sobre Game of Thrones

	Dado que navego para a página de busca do banco de questões
	E digito 'Game of Thrones' no campo de busca
	E seleciono a opção 'Question'
	Quando clico no botão de buscar
	Então verifico que há 1 questão na dificuldade 'Medium'
	E faço a ordenação pelo ID
	
	