// Cria a variável globalmente, assim não precisando importar para quiz.js
window.quizData = {
    programming: [
        {
            question:
                "Quais os nomes das funções que convertem um objeto literal em um Json, e um Json em objeto literal, respectivamente.",
            options: [
                "JSON.stringfy() e JSON.parse()",
                "JSON.toJson() e JSON.toObject()",
                "JSON.convertJson() e JSON.convertObject()",
                "JSON.parse() e JSON.toObject()",
            ],
            answer: "JSON.stringfy() e JSON.parse()",
        },
        {
            question:
                "Segundo a documentação oficial do React.js, o que é o React?",
            options: [
                "Framework",
                "Biblioteca",
                "Gerenciador de interfaces",
                "Gerenciador de dependências",
            ],
            answer: "Biblioteca",
        },
        {
            question: "Em PHP, como se é declarado uma variável?",
            options: ["var = 1", "$var = 1", "var variavel = 1", "#var = 1"],
            answer: "$var = 1",
        },
        {
            question: "O que significa a sigla HTML?",
            options: [
                "Home Tool Markup Language",
                "Hyperlink Markup Language",
                "Hyper Textual Markup Language",
                "Hypertext Markup Language",
            ],
            answer: "Hypertext Markup Language",
        },
        {
            question: "O que é uma função recursiva em programação?",
            options: [
                "Uma função recursiva é uma função que não permite a passagem de argumentos.",
                "Uma função recursiva é uma função que só pode ser chamada uma vez dentro de um programa.",
                "Uma função recursiva é uma função que chama a si mesma durante sua execução.",
                "Uma função recursiva é uma função que realiza operações matemáticas complexas.",
            ],
            answer: "Uma função recursiva é uma função que chama a si mesma durante sua execução.",
        },
        {
            question:
                "O que é uma chave primária em um banco de dados relacional?",
            options: [
                " A chave primária é um índice secundário que permite acesso rápido aos dados em uma tabela.",
                "A chave primária é um tipo de restrição que impede a inserção de valores duplicados em uma tabela.",
                "A chave primária é um campo em uma tabela que garante a unicidade e a identificação única de cada registro.",
                "A chave primária é um campo de uma tabela que armazena dados relacionados a chaves estrangeiras em outras tabelas.",
            ],
            answer: "A chave primária é um campo em uma tabela que garante a unicidade e a identificação única de cada registro.",
        },
        {
            question: "O que é o operador ternário em programação?",
            options: [
                "O operador ternário é um operador lógico que realiza operações booleanas entre dois valores.",
                "O operador ternário é um operador matemático que realiza cálculos com três operandos.",
                "O operador ternário é um operador matemático que realiza uma comparação entre duas funções anônimas.",
                "O operador ternário é um recurso para tomada de decisões com objetivo similar ao do if/else, mas que é codificado em apenas uma linha.",
            ],
            answer: "O operador ternário é um recurso para tomada de decisões com objetivo similar ao do if/else, mas que é codificado em apenas uma linha.",
        },
        {
            question: "Qual foi o primeiro computador criado?",
            options: [
                "O primeiro computador foi o ENIAC (Electronic Numerical Integrator and Computer), desenvolvido nos Estados Unidos.",
                "O primeiro computador foi o Z1, desenvolvido pelo engenheiro alemão Konrad Zuse.",
                "O primeiro computador foi o Colossus, criado pelos britânicos durante a Segunda Guerra Mundial para decifrar códigos nazistas.",
                "O primeiro computador foi o Harvard Mark I, construído em Harvard nos Estados Unidos.",
            ],
            answer: "O primeiro computador foi o ENIAC (Electronic Numerical Integrator and Computer), desenvolvido nos Estados Unidos.",
        },
        {
            question:
                "Qual a diferença entre os operadores de comparação de valores '==' e '===' em Javascript?",
            options: [
                "Ambos os operadores '==' e '===' comparam os valores e os tipos de dados das variáveis.",
                "O operador '==' compara apenas os valores das variáveis, ignorando seus tipos de dados.",
                "O operador '===' compara apenas os valores das variáveis, ignorando seus tipos de dados.",
                "O operador '==' compara apenas os valores das variáveis, já o operador '===' compara os valores e os tipos das variáveis.",
            ],
            answer: "O operador '==' compara apenas os valores das variáveis, já o operador '===' compara os valores e os tipos das variáveis.",
        },
        {
            question: "O que significa a sigla JSON?",
            options: [
                "JavaScript Object Notation.",
                "Java Syntax Object Notation.",
                "JavaScript Oriented Notation.",
                "Java Object Naming.",
            ],
            answer: "JavaScript Object Notation.",
        },
    ],
    conhecimentos: [
        {
            question: "Qual é o idioma oficial da China?",
            options: ["Chinês", "Mandarim", "Japonês", "Coreano"],
            answer: "Mandarim",
        },
        {
            question: 'Quem é o autor da famosa frase "Penso, logo existo"?',
            options: [
                "Platão",
                "Sócrates",
                "René Descartes",
                "Tales de Mileto",
            ],
            answer: "René Descartes",
        },
        {
            question:
                "Austrália, Espanha, Argentina e Bélgica. Qual a capital desses países, respectivamente?",
            options: [
                "Sydney, Barcelona, Buenos Aires, Bruxelas",
                "Melbourne, Barcelona, Santa Cruz, Bruges",
                "Canberra, Madrid, Buenos Aires, Bruxelas",
                "Sydney, Madrid, Santa Cruz, Bruges",
            ],
            answer: "Canberra, Madrid, Buenos Aires, Bruxelas",
        },
        {
            question:
                "Quais foram os anos de início e término do período da Guerra Fria?",
            options: [
                "1947 e 1991",
                "1943 e 1997",
                "1951 e 1990",
                "1941 e 1990",
            ],
            answer: "1947 e 1991",
        },
        {
            question: "Qual é o maior deserto do mundo?",
            options: [
                "Antártida",
                "Deserto do Saara",
                "Tundra do Ártico",
                "Deserto de Gobi",
            ],
            answer: "Antártida",
        },
        {
            question: "Qual é o maior estado em área territorial do Brasil?",
            options: ["Pará", "Mato Grosso", "Amazonas", "Minas Gerais"],
            answer: "Amazonas",
        },
        {
            question:
                "Qual é o nome da primeira mulher a ganhar o Prêmio Nobel?",
            options: [
                "Ana Curie",
                "Sofia Nobel",
                "Marie Antoinette",
                "Marie Curie",
            ],
            answer: "Marie Curie",
        },
        {
            question:
                "Qual é o país que sediou a Copa do Mundo de Futebol de 2018?",
            options: ["Qatar", "Alemanha", "Rússia", "Estados Unidos"],
            answer: "Rússia",
        },
        {
            question: 'Quem foi o autor(a) da obra literária "Frankenstein',
            options: [
                "Mary Shelley",
                "H.P Lovecraft",
                "Edgar Allan Poe",
                "Anne Rice",
            ],
            answer: "Mary Shelley",
        },
        {
            question:
                "Qual o nome da linha imaginária traçada horizontalmente e que divide a terra nos hemisférios Norte e Sul?",
            options: [
                "Trópico de Capricórnio",
                "Meridiano de Greenwich",
                "Linha do Equador",
                "Trópico de Câncer",
            ],
            answer: "Linha do Equador",
        },
    ],
    games: [
        {
            question: "Qual é o jogo mais vendido de todos os tempos?",
            options: ["GTA 5", "Minecraft", "Super Mario Bros.", "Tetris"],
            answer: "Minecraft",
        },
        {
            question:
                "Qual é o jogo de tiro em primeira pessoa que popularizou o gênero e foi lançado em 1993?",
            options: ["Doom", "Call of Duty", "Black", "Medal of Honor"],
            answer: "Doom",
        },
        {
            question:
                "Qual é o nome da empresa responsável pela série de jogos 'Grand Theft Auto'?",
            options: ["Activision", "Konami", "Capcom", "Rockstar Games"],
            answer: "Rockstar Games",
        },
        {
            question:
                "Qual é o nome da organização paramilitar fictícia do jogo 'Resident Evil'?",
            options: [
                "Biohazard Alliance",
                "Aegis Corporation",
                "Nemesis Syndicate",
                "Umbrella Corp.",
            ],
            answer: "Umbrella Corp.",
        },
        {
            question:
                "Qual é o nome do personagem principal da série de jogos 'Uncharted'?",
            options: [
                "Solid Snake",
                "Nathan Drake",
                "Joel Miller",
                "Cloud Strife",
            ],
            answer: "Nathan Drake",
        },
        {
            question:
                "Qual é o nome do estúdio de desenvolvimento responsável pela série 'The Elder Scrolls'?",
            options: [
                "Activision",
                "From Software",
                "Bethesda Game Studios",
                "Toei",
            ],
            answer: "Bethesda Game Studios",
        },
        {
            question:
                "Qual é o nome do jogo de ação e aventura lançado em 2010 que se passa no Velho Oeste?",
            options: [
                "Red Dead Redemption",
                "Wild West Conquest",
                "Frontier Wars",
                "Outlaws of the West",
            ],
            answer: "Red Dead Redemption",
        },
        {
            question:
                "Qual é o nome da espada lendária encontrada na série de jogos 'The Legend of Zelda'?",
            options: [
                "Master Sword",
                "Excalibur",
                "Sword of Destiny",
                "Blade of Legends",
            ],
            answer: "Master Sword",
        },
        {
            question: "Qual é o nome do protagonista da série de jogos 'Halo'?",
            options: [
                "Master Chief",
                "Ethan Walker",
                "Max Steel",
                "Alex Ryder",
            ],
            answer: "Master Chief",
        },
        {
            question:
                "Nos jogos de Pokémon, qual é o pokémon número 1 da Pokédex (Lista de todos os pokémons existentes)",
            options: ["Bulbasauro", "Pikachu", "Charmander", "Abra"],
            answer: "Charmander",
        },
    ],
    sports: [
        {
            question:
                "Qual é o jogador de basquete de detém o record de mais pontos marcados em uma partida?",
            options: [
                "Wilt Chamberlain",
                "Michael Jordan",
                "Lebron James",
                "Kareem Abdul-Jabbar",
            ],
            answer: "Wilt Chamberlain",
        },
        {
            question:
                "Qual o clube de futebol que tem mais títulos da UEFA Champions League depois do Real Madrid?",
            options: ["Milan", "Barcelona", "Bayern de Munique", "Liverpool"],
            answer: "Milan",
        },
        {
            question:
                "Qual o clube de futebol que tem mais títulos da Libertadores?",
            options: [
                "Boca Juniors",
                "Independiente",
                "River Plate",
                "Flamengo",
            ],
            answer: "Independiente",
        },
        {
            question:
                "Quantas medalhas ao total o Ex-Nadador Michael Phelps ganhou ao longo de sua carreira?",
            options: ["23", "18", "36", "28"],
            answer: "28",
        },
        {
            question: "Quantas vezes Pelé foi campeão da Copa do Mundo?",
            options: ["3", "4", "2", "Nenhuma das respostas"],
            answer: "3",
        },
        {
            question:
                "Quem é o boxeador que tem o record de mais números de nocautes?",
            options: [
                "Mike Tyson",
                "Floyd Mayweather",
                "Archie Moore",
                "Muhammad Ali",
            ],
            answer: "Archie Moore",
        },
        {
            question:
                "Entre os times campeôes da NBA, o primeiro lugar está empatado entre dois times, ambos com 17 títulos, quais são esses times?",
            options: [
                "Warriors e Lakers",
                "Lakers e Celtic",
                "Warriors e Pistons",
                "Bulls e Bucks",
            ],
            answer: "Lakers e Celtic",
        },
        {
            question: "Onde foi sediado as Olimpíadas de 2020 (2021)?",
            options: [
                "Tóquio, Japão",
                "Sydney, Austrália",
                "Paris, França",
                "Nova York, Estados Unidos",
            ],
            answer: "Tóquio, Japão",
        },
        {
            question: "Qual desses esportes NÃO é um esporte olímpico?",
            options: ["Canoagem slalom", "Skate", "Futsal", "Taekwondo"],
            answer: "Futsal",
        },
        {
            question:
                "Quantas bolas de ouro o jogador argentino Lionel Messi tem atualmente? (07/2023)",
            options: ["7", "6", "5", "8"],
            answer: "7",
        },
    ],
};
