Feature: Vehicle Insurance Application 

# The first example has nineteen steps
@Test1 
Scenario: Vehicle Insurance Application Test1 Ok

#------------------------------------ MainPage----------------------------------------- 
	Given que o usuario acesse a pagina principal e selecione automobile
	
	#------------------------------------VehicleData------------------------------------------
    And o usuario aguarda a proxima tela carregar
    And o usuario preencha "<marca>" "<perfomance>" "<data>" "<assento>" "<combustivel>" "<preco>" "<placa>" "<quilometragem>" no questionario VehicleData
	And o usuario pressione o botao proximo em VehicleData
			 
	#------------------------------------ InsuranceData------------------------------------------
    And o usuario aguarda a proxima tela carregar
    And o usuario preencha "<nome>" "<sobrenome>" "<datanascimento>" "<endereco>" "<pais>" "<CEP>" "<cidade>" "<situacao>" "<website>" no questionario InsuranceData
    And o usuario aguarda a proxima tela carregar
    And o usuario pressione o botao proximo em InsuranceData	
	And o usuario aguarda a proxima tela carregar 	
	#------------------------------------ ProductData------------------------------------------
    And o usuario preencha "<datainicio>" "<valor>" "<bonus>" "<cobertura>" "<carrocortesia>" no questionario ProductData
    And o usuario pressione o botao proximo em ProductData	
    	
	#------------------------------------ Select Price Option------------------------------------------
    And o usuario Select o PriceOption Platinum
    And o usuario pressione o botao proximo em Select Price Option	
	
	#------------------------------------ SendQuote------------------------------------------
    And o usuario preencha "<email>" "<telefone>" "<username>" "<password>" "<passwordconfirmation>" "<comentario>" no questionario SendQuote
	And o usuario clica no botão de enviar questionario
	And o usuario clica no botão de enviar email    
    And o usuario valida a mensagem de sucesso	 

# The second example has nineteen steps
@Test2
Scenario Outline: Vehicle Insurance Application  Test2 NOK

#------------------------------------ MainPage----------------------------------------- 
	Given que o usuario acesse a pagina principal e selecione automobile
	
	#------------------------------------VehicleData------------------------------------------
    And o usuario aguarda a proxima tela carregar
    And o usuario preencha "<marca>" "<perfomance>" "<data>" "<assento>" "<combustivel>" "<preco>" "<placa>" "<quilometragem>" no questionario VehicleData
	And o usuario pressione o botao proximo em VehicleData
			 
	#------------------------------------ InsuranceData------------------------------------------
    And o usuario aguarda a proxima tela carregar
    And o usuario preencha "<nome>" "<sobrenome>" "<datanascimento>" "<endereco>" "<pais>" "<CEP>" "<cidade>" "<situacao>" "<website>" no questionario InsuranceData
    And o usuario aguarda a proxima tela carregar
    And o usuario pressione o botao proximo em InsuranceData	
	And o usuario aguarda a proxima tela carregar 	
	#------------------------------------ ProductData------------------------------------------
    And o usuario preencha "<datainicio>" "<valor>" "<bonus>" "<cobertura>" "<carrocortesia>" no questionario ProductData
    And o usuario pressione o botao proximo em ProductData	
    	
	#------------------------------------ Select Price Option------------------------------------------
    And o usuario Select o PriceOption Platinum
    And o usuario pressione o botao proximo em Select Price Option	
	
	#------------------------------------ SendQuote------------------------------------------
    And o usuario preencha "<email>" "<telefone>" "<username>" "<password>" "<passwordconfirmation>" "<comentario>" no questionario SendQuote
	And o usuario clica no botão de enviar questionario
	And o usuario clica no botão de enviar email   
    And o usuario valida a mensagem de sucesso "<mensagem>"	
    Then o usuario clica no botão Ok
		
		
	
Examples:  
| marca  | perfomance | data       | assento | combustivel | preco | placa   | quilometragem | nome | sobrenome | datanascimento | endereco           | pais     | CEP      | cidade | situacao | website         | datainicio | valor         | bonus   | cobertura     | carrocortesia | email         | telefone        | username | password  | passwordconfirmation | comentario                     | mensagem                |   
| Volvo  | 412        | 02/11/2018 | 4       | Diesel      | 12500 | ALN2019 | 6000          | Alan | Silva     | 10/06/1982     | North Avenue, 2832 | Portugal | 52041080 | Porto  | Employee | www.youtube.com | 01/16/2019 | 20.000.000,00 | Bonus 9 | Full Coverage | Yes           | mail@mail.com | 558199394959697 | admin    | !Abcd1234 | !Abcd1234            | Prova de Automação em Selenium | Sending e-mail success! | 
| Porsche| 450        | 05/11/2018 | 2       | Diesel      | 25000 | JDO2019 | 400           | John | Doe       | 08/08/1986     | C Gomes Street, 157| Portugal | 52041080 | Porto  | Employee | www.mixcloud.com| 01/24/2019 | 20.000.000,00 | Bonus 9 | Full Coverage | Yes           | mail@mail.com | 558199394959697 | admin    | !Abcd1234 | !Abcd12345           | Prova de Automação em Selenium | Sending e-mail success! | 