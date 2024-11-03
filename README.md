InovaX

Integrantes do Projeto

Turma: 2TDSPJ

	•	Lucas dos Santos Lopes - RM550790
	•	Gustavo Marques Catelan - RM551823
	•	Murilo Machado - RM550718
	•	Victor Taborda Rodrigues - RM97900
	•	Gabriel Bacelar Valentim - RM97901

Requisitos de Instalação

Para rodar a aplicação InovaX, siga os passos a seguir:

1. Clonando o Repositório

Primeiro, clone o repositório do projeto InovaX:
•	git clone https://github.com/GustavoCatelan/JavaChallengeFinal.git

2. Configuração do Ambiente no IntelliJ IDEA

	•	Abra o IntelliJ IDEA.
	•	Importe o projeto InovaTech.

3. Configuração do RabbitMQ

No Windows

	1.	Instalar o Erlang:
	•	Baixe o instalador do Erlang para Windows no site oficial: https://www.erlang.org/downloads.
	•	Instale o Erlang e anote o diretório de instalação.
	2.	Instalar o RabbitMQ:
	•	Baixe o instalador do RabbitMQ para Windows no site oficial: https://www.rabbitmq.com/install-windows.html.
	•	O RabbitMQ deve detectar automaticamente o Erlang. Se não detectar, configure a variável de ambiente ERLANG_HOME com o caminho do diretório de instalação do Erlang.

No macOS

	1.	Instalar o Erlang:
 •	brew install erlang
 	2.	Instalar o RabbitMQ:
 •	brew install rabbitmq
	3.	Iniciar o RabbitMQ:
 •	brew services start rabbitmq
 
4. Executando o Projeto

	1.	No IntelliJ, execute o aplicativo.
	2.	Abra um navegador web.
	3.	Acesse a aplicação através do URL: http://localhost:8080/login
