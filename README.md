<br><br>
<h1 align="center">Desafio de Programação - Gerenciador de Treinamento</h1>
<p align="center"><i>Desenvolvido por Amanda de Oliveira Casagrande</p></i>

<h2> ✨ Objetivos</h2>
<hr>
<ul>
<p align="center">O objetivo deste trabalho é simular um sistema de gerenciamento de um treinamento hipotético em uma grande empresa de Tecnologia da Informação. Este projeto foi desenvolvido em Linguagem Java 11.</p>
<p align="center">Conforme o problema exposto, segue a explicação:
<br>
<p align="center"><cite>"O treinamento será realizado em 2 etapas e as pessoas serão divididas em salas com lotação variável. Serão realizados também dois intervalos de café em 2 espaços distintos. Você precisa criar o sistema que gerenciará este evento."</cite>
<br>
  <p align="center">Neste <i>ReadMe.md</i> você encontrará as <i>Tecnologias</i> utilizadas para o desenvolvimento deste trabalho, assim como uma breve explicação de <i>Como compilar e executar este programa</i>, as <i>Evidências</i> para comprovação de alguns pontos que eu considero importante para o funcionamento do projeto e, por fim, <i>Onde me encontrar</i> nas redes sociais.</p>
</p>
<br>
</ul>

<h2> ✨ Tecnologias</h2>
<hr>
<ul>
As seguintes ferramentas foram usadas na construção do projeto:<br><br>
<ul type="square">
<li><a href="https://www.eclipse.org/downloads/">Eclipse</a></li>
<li><a href="https://www.oracle.com/java/technologies/javase-downloads.html">JDK</a></li>
<li><a href="https://www.postman.com/">Postman</a></li>
<li><a href="https://dbeaver.io/">DBeaver</a></li>
<li><a href="https://www.mysql.com/">MySQL</a></li>
<li><a href="https://www.postgresql.org/">Postgres</a></li>
<li><a href="https://spring.io/">Spring Boot</a></li>
<li><a href="https://start.spring.io/">Spring Initializr</a></li>
<li><a href="https://maven.apache.org/">Apache Maven</a></li>
<li><a href="https://junit.org/junit5/">JUnit</a></li>
<li><a href="https://git-scm.com/">Git</a></li>
</ul></ul>

<br><br>
<h2> ✨ Como compilar e executar este programa</h2>
<hr>
<ul>
<p>Inserir aqui a explicação</p>
<p>Para executar o projeto, será necessário instalar os seguintes programas:<br>
<ul type="square">
<li><a href="https://www.oracle.com/java/technologies/javase-downloads.html">JDK 10:</a> Necessário para executar o projeto Java;</li>
<li><a href="https://maven.apache.org/">Maven 3.5.3: </a>Necessário para realizar o build do projeto Java;</li>
<li><a href="https://www.eclipse.org/downloads/packages/">Eclipse:</a> Para desenvolvimento do projeto;</li>
<li><a href="">Postman: </a>Para a entrada, consulta, atualização e exclusão de dados;</li>
<li><a href="">Dbeaver</a>*: Visualização dos dados armazenados no DB.</li>
<br>
</ul>
<i>* Ou qualquer outro SGBD de sua preferência.</i>
<br><br>
Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub num diretório de sua preferência:<br><br>

<ul><i>cd "diretorio de sua preferencia"<br>
git clone https://github.com/AmandaCasagrande/GerenciadorTreinamento</ul></i><br>

Para construir o projeto com o Maven, executar os comando abaixo:

<ul><i>mvn clean install</ul></i><br>
O comando irá baixar todas as dependências do projeto e criar um diretório target com os artefatos construídos, que incluem o arquivo jar do projeto. Além disso, serão executados os testes unitários, e se algum falhar, o Maven exibirá essa informação no console.

Para executar o projeto, é necessário utilizar o Eclipse, para que o mesmo identifique as dependências necessárias para a execução no repositório .m2 do Maven. Uma vez importado o projeto, será criado um arquivo .classpath que irá informar qual a classe principal para a execução.

Para rodar os testes, utilize o comando abaixo:

<ul><i>mvn test</ul></i>
</p>
</ul>
<br><br>

<h2> ✨ Evidências</h2>
<hr>
<p align="center">Abaixo segue algumas evidências do <i>CRUD (Create, Read, Update e Delete)</i> das entidades de <i>Participantes</i>, <i>Espaço de Café</i> e <i>Sala de Treinamento</i>. É importante mencionar que senti necessidade apenas de criar o <i>CRUD</i> completo dos <i>Participantes</i>. Neste projeto você não encontrará a possibilidade de atualizar e deletar as entidades de <i>Espaço de Café</i> e <i>Sala de Treinamento</i>. No entanto, futuramente, é possível implementar essas funcionalidades para fins de estudos e aperfeiçoamento do projeto.</p> <p align="center">Além disso, foi implementado um <i>Relatório Geral dos Participantes</i>, isto é, o programa retorna para cada <i>Participante</i>, na Primeira e Segunda Etapa do Treinamento, o <i>nome da sala de Treinamento</i> no qual ele participará, a <i>lotação máxima</i> de participantes na sala, a <i>quantidade atual de participantes</i> inseridos na sala, o <i>nome do Espaço de Café</i> e a <i>lotação máxima do Espaço de Café</i>. No fim da evidência do <i>Relatório Geral dos Participantes</i>, você encontrará o relatório gerado pelo Postman em formato JSON.</p>
<ul type="square">
<h3><li> Banco de Dados:</h3></ul>

<h3><ul><ul><li> Participante: </li></h3></ul>

<h3><ul><ul><ul><li> Cadastrar:</li><br>
<IMG src="https://github.com/AmandaCasagrande/GerenciadorTreinamento/blob/master/evidencias/InserirParticipante.PNG">
<br><br>

<li> Consultar:</li><br>
<IMG src="https://github.com/AmandaCasagrande/GerenciadorTreinamento/blob/master/evidencias/ConsultarParticipante1.PNG">
<br><br>

<li> Atualizar:</li><br>
<IMG src="https://github.com/AmandaCasagrande/GerenciadorTreinamento/blob/master/evidencias/EditarParticipante.PNG">
<IMG src="https://github.com/AmandaCasagrande/GerenciadorTreinamento/blob/master/evidencias/EditarParticipanteDB.PNG">
<br><br>

<li> Deletar:</li><br>
<IMG src="https://github.com/AmandaCasagrande/GerenciadorTreinamento/blob/master/evidencias/DeletarParticipante.PNG">
<IMG src="https://github.com/AmandaCasagrande/GerenciadorTreinamento/blob/master/evidencias/DeletarParticipanteDB.PNG">
<br><br>

</ul></ul></ul></h3>

<h3><ul><ul><li> Espaço de Café: </li></h3></ul>

<h3><ul><ul><ul><li> Cadastrar:</li><br>
<IMG src="https://github.com/AmandaCasagrande/GerenciadorTreinamento/blob/master/evidencias/CadastrarEspacoCafe.PNG">
<br><br>

<li> Consultar:</li><br>
<IMG src="https://github.com/AmandaCasagrande/GerenciadorTreinamento/blob/master/evidencias/ConsultarEspacoCafe.PNG">
<br><br>
</ul></ul></ul></h3>

<h3><ul><ul><li> Sala de Treinamento: </li></ul></ul></h3>

<h3><ul><ul><ul><li> Cadastrar:</li><br>
<IMG src="https://github.com/AmandaCasagrande/GerenciadorTreinamento/blob/master/evidencias/CadastrarSalaEvento.PNG">
<IMG src="https://github.com/AmandaCasagrande/GerenciadorTreinamento/blob/master/evidencias/CadastrarSalaEventoBD.PNG">
<br><br>

<li> Consultar:</li><br>
<IMG src="https://github.com/AmandaCasagrande/GerenciadorTreinamento/blob/master/evidencias/ConsultarSala.PNG">

</ul></ul></ul></h3>

<h3><ul><ul><li> Relatório Geral dos Participantes: </li></h3></ul>

<h3><ul><ul><ul><li> Consultar:</li><br>
<IMG src="https://github.com/AmandaCasagrande/GerenciadorTreinamento/blob/master/evidencias/RelatorioGerenciamento.PNG">
</ul></ul></ul></ul></h3>
<br><br>
<ul type="square">
<h3><li> Testes Unitários:</h3></ul>

<ul><ul>Foi desenvolvido testes unitários da camada de Service, segue abaixo as evidências de sucessos dos testes:</li><br></ul></ul>
<ul><ul><IMG src="https://github.com/AmandaCasagrande/GerenciadorTreinamento/blob/master/evidencias/ServiceTeste.PNG"></ul></ul><br><br>

</ul>
[
    {
        "participante": {
            "id": 7,
            "nomeParticipante": "Amanda",
            "sobrenomeParticipante": "Casagrande"
        },
        "salaPrimeiraEtapa": {
            "id": 4,
            "nomeSalaEvento": "Sala Treinamento A",
            "lotacaoMaximaEvento": 50,
            "lotacaoAtual": 2
        },
        "salaSegundaEtapa": {
            "id": 5,
            "nomeSalaEvento": "Sala Treinamento B",
            "lotacaoMaximaEvento": 80,
            "lotacaoAtual": 3
        },
        "cafePrimeiraEtapa": {
            "id": 4,
            "nomeEspacoCafe": "Espaco Cafe 1",
            "lotacaoEspacoCafe": 15
        },
        "cafeSegundaEtapa": {
            "id": 5,
            "nomeEspacoCafe": "Espaco Cafe 2",
            "lotacaoEspacoCafe": 20
        },
        "erros": null
    },
    {
        "participante": {
            "id": 8,
            "nomeParticipante": "João",
            "sobrenomeParticipante": "Silva"
        },
        "salaPrimeiraEtapa": {
            "id": 5,
            "nomeSalaEvento": "Sala Treinamento B",
            "lotacaoMaximaEvento": 80,
            "lotacaoAtual": 3
        },
        "salaSegundaEtapa": {
            "id": 6,
            "nomeSalaEvento": "Sala Treinamento C",
            "lotacaoMaximaEvento": 30,
            "lotacaoAtual": 2
        },
        "cafePrimeiraEtapa": {
            "id": 4,
            "nomeEspacoCafe": "Espaco Cafe 1",
            "lotacaoEspacoCafe": 15
        },
        "cafeSegundaEtapa": {
            "id": 5,
            "nomeEspacoCafe": "Espaco Cafe 2",
            "lotacaoEspacoCafe": 20
        },
        "erros": null
    },
    {
        "participante": {
            "id": 9,
            "nomeParticipante": "Bruna",
            "sobrenomeParticipante": "Muller"
        },
        "salaPrimeiraEtapa": {
            "id": 6,
            "nomeSalaEvento": "Sala Treinamento C",
            "lotacaoMaximaEvento": 30,
            "lotacaoAtual": 2
        },
        "salaSegundaEtapa": {
            "id": 7,
            "nomeSalaEvento": "Sala Treinamento D",
            "lotacaoMaximaEvento": 30,
            "lotacaoAtual": 2
        },
        "cafePrimeiraEtapa": {
            "id": 4,
            "nomeEspacoCafe": "Espaco Cafe 1",
            "lotacaoEspacoCafe": 15
        },
        "cafeSegundaEtapa": {
            "id": 5,
            "nomeEspacoCafe": "Espaco Cafe 2",
            "lotacaoEspacoCafe": 20
        },
        "erros": null
    },
    {
        "participante": {
            "id": 11,
            "nomeParticipante": "Leandro",
            "sobrenomeParticipante": "Bueno"
        },
        "salaPrimeiraEtapa": {
            "id": 7,
            "nomeSalaEvento": "Sala Treinamento D",
            "lotacaoMaximaEvento": 30,
            "lotacaoAtual": 2
        },
        "salaSegundaEtapa": {
            "id": 4,
            "nomeSalaEvento": "Sala Treinamento A",
            "lotacaoMaximaEvento": 50,
            "lotacaoAtual": 2
        },
        "cafePrimeiraEtapa": {
            "id": 4,
            "nomeEspacoCafe": "Espaco Cafe 1",
            "lotacaoEspacoCafe": 15
        },
        "cafeSegundaEtapa": {
            "id": 5,
            "nomeEspacoCafe": "Espaco Cafe 2",
            "lotacaoEspacoCafe": 20
        },
        "erros": null
    },
    {
        "participante": {
            "id": 12,
            "nomeParticipante": "Pedro",
            "sobrenomeParticipante": "Torres"
        },
        "salaPrimeiraEtapa": {
            "id": 4,
            "nomeSalaEvento": "Sala Treinamento A",
            "lotacaoMaximaEvento": 50,
            "lotacaoAtual": 2
        },
        "salaSegundaEtapa": {
            "id": 5,
            "nomeSalaEvento": "Sala Treinamento B",
            "lotacaoMaximaEvento": 80,
            "lotacaoAtual": 3
        },
        "cafePrimeiraEtapa": {
            "id": 4,
            "nomeEspacoCafe": "Espaco Cafe 1",
            "lotacaoEspacoCafe": 15
        },
        "cafeSegundaEtapa": {
            "id": 5,
            "nomeEspacoCafe": "Espaco Cafe 2",
            "lotacaoEspacoCafe": 20
        },
        "erros": null
    },
    {
        "participante": {
            "id": 13,
            "nomeParticipante": "Otávio",
            "sobrenomeParticipante": "Ferreira"
        },
        "salaPrimeiraEtapa": {
            "id": 5,
            "nomeSalaEvento": "Sala Treinamento B",
            "lotacaoMaximaEvento": 80,
            "lotacaoAtual": 3
        },
        "salaSegundaEtapa": {
            "id": 6,
            "nomeSalaEvento": "Sala Treinamento C",
            "lotacaoMaximaEvento": 30,
            "lotacaoAtual": 2
        },
        "cafePrimeiraEtapa": {
            "id": 4,
            "nomeEspacoCafe": "Espaco Cafe 1",
            "lotacaoEspacoCafe": 15
        },
        "cafeSegundaEtapa": {
            "id": 5,
            "nomeEspacoCafe": "Espaco Cafe 2",
            "lotacaoEspacoCafe": 20
        },
        "erros": null
    },
    {
        "participante": {
            "id": 14,
            "nomeParticipante": "Luciana",
            "sobrenomeParticipante": "Silveira"
        },
        "salaPrimeiraEtapa": {
            "id": 6,
            "nomeSalaEvento": "Sala Treinamento C",
            "lotacaoMaximaEvento": 30,
            "lotacaoAtual": 2
        },
        "salaSegundaEtapa": {
            "id": 7,
            "nomeSalaEvento": "Sala Treinamento D",
            "lotacaoMaximaEvento": 30,
            "lotacaoAtual": 2
        },
        "cafePrimeiraEtapa": {
            "id": 4,
            "nomeEspacoCafe": "Espaco Cafe 1",
            "lotacaoEspacoCafe": 15
        },
        "cafeSegundaEtapa": {
            "id": 5,
            "nomeEspacoCafe": "Espaco Cafe 2",
            "lotacaoEspacoCafe": 20
        },
        "erros": null
    },
    {
        "participante": {
            "id": 15,
            "nomeParticipante": "Julia",
            "sobrenomeParticipante": "Fraga"
        },
        "salaPrimeiraEtapa": {
            "id": 7,
            "nomeSalaEvento": "Sala Treinamento D",
            "lotacaoMaximaEvento": 30,
            "lotacaoAtual": 2
        },
        "salaSegundaEtapa": {
            "id": 4,
            "nomeSalaEvento": "Sala Treinamento A",
            "lotacaoMaximaEvento": 50,
            "lotacaoAtual": 2
        },
        "cafePrimeiraEtapa": {
            "id": 4,
            "nomeEspacoCafe": "Espaco Cafe 1",
            "lotacaoEspacoCafe": 15
        },
        "cafeSegundaEtapa": {
            "id": 5,
            "nomeEspacoCafe": "Espaco Cafe 2",
            "lotacaoEspacoCafe": 20
        },
        "erros": null
    },
    {
        "participante": {
            "id": 10,
            "nomeParticipante": "Gabriela",
            "sobrenomeParticipante": "Borges"
        },
        "salaPrimeiraEtapa": {
            "id": 4,
            "nomeSalaEvento": "Sala Treinamento A",
            "lotacaoMaximaEvento": 50,
            "lotacaoAtual": 2
        },
        "salaSegundaEtapa": {
            "id": 5,
            "nomeSalaEvento": "Sala Treinamento B",
            "lotacaoMaximaEvento": 80,
            "lotacaoAtual": 3
        },
        "cafePrimeiraEtapa": {
            "id": 4,
            "nomeEspacoCafe": "Espaco Cafe 1",
            "lotacaoEspacoCafe": 15
        },
        "cafeSegundaEtapa": {
            "id": 5,
            "nomeEspacoCafe": "Espaco Cafe 2",
            "lotacaoEspacoCafe": 20
        },
        "erros": null
    }
]
<br><br>

<h2> ✨ Onde me encontrar:</h2>
<hr>
<ul type="square">
<li><a href="https://www.linkedin.com/in/casagrandeamanda">LinkedIn</li></a>
<li>E-mail: amanda.c06@aluno.ifsc.edu.br</li>
<br><br><br>
