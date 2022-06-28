# Teste de conhecimentos em Android (Java/Kotlin)

Como cenário proposto dessa avaliação, será necessário desenvolver um aplicativo Android que implemente as seguintes funcionalidades:

- Consultar um catálogo de bebidas com os dados obtidos através da API (https://api.punkapi.com/v2/beers)
  - O catálogo deve ser disponibilizado através de uma lista com paginação no modelo infinite scroll.
  - Possibilitar a visualização de detalhes da bebida selecionada (inclusive com a imagem).
  
- Implementar uma view que possibilite ao usuário registrar uma mensagem com no máximo 240 caracteres, o POST dessa mensagem deve ser enviado para API (https://webhook.site/28222730-d87c-48f0-b5bb-57d67718aa74).
  - Por se tratar de uma API dinâmica não é necessário seguir um contrato específico, apenas um POST em formato JSON com os dados preenchidos.
  - Como a API mencionada acima é apenas um ambiente temporário, a qualquer momento este endereço poderá se tornar inválido, sendo assim o app deverá ser resiliente e caso ocorra um erro 404 (NotFound) deverá ser possibilitado ao usuário informar uma nova URL de API.

## Como iniciar
Faça um fork deste repositório.

Ao finalizar o seu desenvolvimento, submeta um pull request para este repositório que seremos notificados!

## Requisitos
- A aplicação desenvolvida deve ser app Android utilizando Java e/ou Kotlin.
- A consulta de catálogo de produtos deve implementar páginação no modelo Infinite Scroll.
- A visualização de detalhes da produto não exige um layout específico (deixamos ao seu critério) apenas sendo obrigatório o carregamento dos dados e imagem do produto.
- A submissão de mensagens para API deve ser resiliente, e caso ocorrá erros por motivo 404 (NotFound) deverá ser possibilitado ao usuário a atualização da URL.
- Não se preocupe tanto com o temas e/ou layout, o foco aqui é principalmente a implementação das funcionalidades básicas e demais requisitos mencionados acima!

## Dicas
- Procure aplicar os seus conhecimentos, convenções e boas práticas pertinentes ao desenvolvimento de app para Android.
- Aqui não existe certo ou errado, o nosso objetivo é conhecer o seu estilo de programação.
- E principalmente, divirta-se :smiley:!

## Links
- Punk API V2 Documentarion https://punkapi.com/documentation/v2
