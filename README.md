# I.R. Donation

## 💻 Sobre o projeto

### Descrição
Todos os anos, milhões de pessoas devem declarar seu Imposto de Renda. O que poucos sabem é que
é possível direcionar parte de seu valor para algumas entidades beneficientes.
São as chamadas doações incentivadas.

Esse projeto tem a ideia de agregar valor para a sociedade com doações incentivadas,
intermediando contadores voluntários e pessoas com dificuldades para realizar sua declaração,
com a condição de que seja doada parte do imposto devido (até 6%),
e disseminar essa informação para a população em geral.

Esse projeto visa atender ao objetivos da *ONU*, através de doações para entidades especializadas em cada aspecto da sociedade, como:
Pobreza, Fome, Saúde, Educação e Desigualdade.


*(Esse projeto foi inspirado na ideia de outro já existente, sendo adaptado para
nossos requisitos e apenas para fim de educação e estudo. Segue link do projeto:
https://hackdash.org/projects/5894c5682c61d7392535cafa)*

### Funcionalidades
Desenvolvemos uma API REST, ao qual irá armazenar (em Banco de Dados SQL) os dados sobre os clientes (usuários),
contadores, e entidades não governamentais, além de conectar o usuário final com um contador disponível na plataforma.

* Adicionar clientes

Um cliente deve ter um nome, sobrenome, cpf, e informações para contato (email e telefone). 
Um cliente também pode acessar a lista com todos os contadores e clientes cadastrados na plataforma para criar confiança com os voluntários do projeto.

* Adicionar contadores

Um contador deve ter um nome, sobrenome, cpf, registro único (CRC), e informações para contato (email e telefone).
Um contador também pode acessar a lista com todos os contadores cadastrados na plataforma para criar confiança no projeto.

* Realizar atendimento (contadores)

Um contador deve entrar em contato com um cliente. Para isso, na url "/contador/atendimento", 
forneceremos para o contador as informações de contato do próximo cliente cadastrado que ainda não foi atendido, 
sendo seu papel entrar em contato com ele para prestar o serviço, seja por email ou telefone. 

Mas atenção ! Quando apresentamos as informações do usuário, entendemos que você entrará em contato com ele, por isso,
se a página for atualizada, forneceremos as informações do próximo cliente na fila para atendimento. 
Fique atento e anote as informações do seu cliente antes de atualizar a página :) 

* Listar entidades

Os clientes poderão acessar a lista de todas as entidades cadastradas, para escolher a que você mais se identificar na hora da doação.

Se você possuir uma indicação de entidade, envie um email para nós, (brunoaocosta@homtail.com e/ou gabrielpersuhn000@gmail.com)
que entraremos em contato com ela com uma proposta de parceria.
Assim, você ajuda o projejo a crescer cada vez mais :)


## 🛠 Tecnologias
- Java 11
- Maven
- Lombok
- Spring Boot
- Banco de dados (SQL)


## 💡 Autores

* **Bruno Costa - brunoaocosta@hotmail.com - https://github.com/Brun2310**

* **Gabriel Persuhn - gabrielpersuhn000@gmail.com - https://github.com/GabrielPersuhn**