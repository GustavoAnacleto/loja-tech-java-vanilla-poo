# Loja Tech Java Vanilla POO

Projeto independente desenvolvido em Java puro para consolidar os fundamentos de Programação Orientada a Objetos estudados na Seção 14 do curso Java Moderno.

O objetivo é construir, passo a passo, um sistema simples de loja de tecnologia, sem frameworks, banco de dados, Maven ou IDE automatizando a estrutura do projeto.

## Objetivos de aprendizagem

Este projeto busca praticar:

* classes e objetos;
* atributos de instância;
* construtores e sobrecarga de construtores;
* encapsulamento com `private`, getters e setters;
* métodos com e sem retorno;
* sobrecarga de métodos;
* pacotes e imports;
* modificadores de acesso;
* métodos e membros estáticos;
* passagem de valores primitivos e objetos como parâmetros;
* organização manual de um projeto Java.

## Tecnologias e ambiente

* Java 25
* Java puro
* Sublime Text
* GitHub Desktop
* Windows 10

## Estrutura planejada

```text
loja-tech-java-vanilla-poo/
├── Aplicacao.java
├── entidades/
│   ├── Produto.java
│   ├── Cliente.java
│   ├── Venda.java
│   └── DemonstracaoAcesso.java
├── servicos/
│   ├── Caixa.java
│   └── GerenciadorEstoque.java
└── util/
    └── CalculadoraFinanceira.java
```

## Progresso do projeto

* [x] Criar o repositório e a estrutura inicial
* [x] Implementar a classe `Produto`
* [x] Implementar a classe `Cliente`
* [x] Implementar a classe `Venda`
* [x] Implementar a classe `CalculadoraFinanceira`
* [x] Implementar a classe `GerenciadorEstoque`
* [ ] Implementar a classe `Caixa`
* [ ] Criar a demonstração dos modificadores de acesso
* [ ] Criar a classe principal `Aplicacao`
* [ ] Testar o fluxo completo
* [ ] Revisar o código e documentar o resultado final

## Classe Produto

A classe `Produto` foi a primeira entidade implementada.

Ela possui:

* código gerado automaticamente;
* nome;
* preço;
* quantidade em estoque;
* construtores sobrecarregados;
* getters e setters com validações;
* métodos sobrecarregados para aplicação de descontos;
* contador estático de produtos criados.

## Decisão didática sobre o código dos produtos

Neste projeto, o código de cada produto é gerado automaticamente pela própria classe `Produto`.

Foram utilizados dois membros estáticos com responsabilidades diferentes:

```text
proximoCodigo → controla a sequência dos códigos
totalProdutosCriados → conta quantos objetos Produto foram criados
```

O primeiro produto recebe o código `1000`, e os próximos códigos avançam de três em três:

```text
Produto 1 → código 1000
Produto 2 → código 1003
Produto 3 → código 1006
```

Essa solução foi adotada com finalidade didática para consolidar o uso de `static`.

Em um sistema real, o identificador normalmente seria controlado por um banco de dados, por exemplo por meio de uma chave primária gerada automaticamente. Como este projeto utiliza apenas Java puro, a geração foi simulada dentro da classe.

O atributo `codigo` pertence a cada objeto individualmente, enquanto `proximoCodigo` e `totalProdutosCriados` pertencem à classe `Produto`.

## Regras aplicadas na classe Produto

* o código não pode ser alterado externamente;
* o nome não pode ser nulo ou vazio;
* o preço não pode ser negativo;
* a quantidade em estoque não pode ser negativa;
* descontos fixos não podem ser maiores que o preço;
* descontos percentuais devem estar entre 1% e 100%;
* descontos condicionados ao estoque só são aplicados quando a quantidade mínima é atingida.

## Classe Cliente

A classe `Cliente` representa uma pessoa que pode realizar compras na loja.

Ela possui:

* nome;
* CPF;
* saldo de crédito;
* construtores sobrecarregados;
* getters e setters com validações;
* valores padrão para dados não informados;
* contador estático de clientes criados.

Antes da utilização dos setters nos construtores, os atributos recebem valores padrão. Essa decisão evita que o objeto permaneça com dados nulos quando um valor inválido for informado.

Exemplo:

```text
nome → Cliente não informado
CPF → CPF não informado
saldo de crédito → 0
```

## Regras aplicadas na classe Cliente

* o nome não pode ser nulo ou vazio;
* o CPF não pode ser nulo ou vazio;
* o saldo de crédito não pode ser negativo;
* valores inválidos não substituem os valores padrão;
* cada cliente criado aumenta o contador estático da classe.

O contador `totalClientesCriados` pertence à classe `Cliente` e é compartilhado entre todos os objetos.

## Classe Venda

A classe `Venda` representa a relação entre um cliente, um produto e a quantidade comprada.

Ela possui:

* referência para um objeto `Cliente`;
* referência para um objeto `Produto`;
* quantidade comprada;
* valor total;
* indicação de venda concluída;
* construtores sobrecarregados;
* contador estático de vendas concluídas.

Essa classe também pratica o relacionamento entre objetos, pois uma venda utiliza informações existentes nas classes `Cliente` e `Produto`.

## Construtores da classe Venda

Foram criadas três formas de iniciar uma venda:

```text
Venda()
```

Cria uma venda vazia.

```text
Venda(Cliente cliente, Produto produto)
```

Cria uma venda com cliente e produto, utilizando a quantidade padrão de uma unidade.

```text
Venda(Cliente cliente, Produto produto, int quantidade)
```

Cria uma venda completa, recebendo cliente, produto e quantidade.

## Regras aplicadas na classe Venda

Uma venda somente pode ser concluída quando:

* o cliente não for `null`;
* o produto não for `null`;
* a quantidade for maior que zero;
* o produto possuir estoque suficiente;
* a venda ainda não tiver sido concluída.

Quando a venda é concluída:

* a quantidade vendida é removida do estoque;
* o valor total é calculado;
* o atributo `concluida` recebe `true`;
* o contador de vendas concluídas é incrementado.

A verificação do atributo `concluida` evita que a mesma venda seja processada mais de uma vez. Sem essa validação, chamadas repetidas poderiam diminuir o estoque e aumentar o contador incorretamente.

## Cálculo do valor total

O valor total é calculado multiplicando o preço unitário do produto pela quantidade comprada:

```text
valor total = preço do produto × quantidade
```

O cálculo pertence à classe `Venda`, pois representa uma informação da operação de venda, e não uma responsabilidade individual do produto.

## Método obterInfo

O método `obterInfo()` reúne os principais dados da venda em uma única `String`.

Ele facilita a exibição das informações na classe principal, evitando que cada atributo precise ser acessado e exibido separadamente.

O método também verifica se o cliente ou o produto são `null`, evitando erros ao apresentar uma venda ainda incompleta.

## Contador de vendas concluídas

O atributo `totalVendasConcluidas` é estático porque representa uma informação compartilhada por todas as vendas.

Ele somente é incrementado quando uma venda é concluída com sucesso.

O método `getTotalVendasConcluidas()` também é estático, permitindo consultar o contador diretamente pela classe:

```java
Venda.getTotalVendasConcluidas();
```

## Classe GerenciadorEstoque

A classe `GerenciadorEstoque` foi criada no pacote `servicos`.

Ela não representa uma entidade da loja, mas sim um serviço responsável por realizar operações sobre o estoque de um produto.

Ela possui métodos para:

* adicionar unidades ao estoque;
* remover unidades do estoque;
* impedir que a remoção gere estoque negativo;
* demonstrar a passagem de tipos primitivos por valor.

Exemplo de responsabilidade da classe:

```text
Produto → guarda os dados do produto
GerenciadorEstoque → executa operações sobre o estoque do produto
```

Essa separação ajuda a praticar a ideia de que nem toda classe precisa representar uma entidade. Algumas classes podem representar serviços ou operações.

## Passagem por valor em Java

O método `tentarAlterarEstoque(int estoque)` foi mantido com finalidade didática.

Ele demonstra que variáveis primitivas em Java são passadas por valor.

Isso significa que alterar o parâmetro dentro do método não altera a variável original fora dele.

Exemplo conceitual:

```java
public void tentarAlterarEstoque(int estoque) {
    estoque += 100;
}
```

Esse método altera apenas a cópia local da variável `estoque`.

Para alterar o estoque real de um produto, é necessário acessar o objeto `Produto` e usar seus métodos, como ocorre em `adicionarEstoque` e `removerEstoque`.

## Classe CalculadoraFinanceira

A classe `CalculadoraFinanceira` foi criada no pacote `util`.

Ela é uma classe utilitária, ou seja, não representa uma entidade da loja. Sua função é concentrar operações financeiras simples que podem ser reutilizadas por outras partes do projeto.

Todos os métodos foram definidos como `static`, permitindo que sejam chamados diretamente pela classe, sem necessidade de criar um objeto `CalculadoraFinanceira`.

Exemplo:

```java
CalculadoraFinanceira.aplicarDesconto(100.0, 10);
```

Essa decisão é coerente com o objetivo da classe, pois ela não precisa guardar estado próprio. Ela apenas recebe valores, realiza cálculos e devolve resultados.

## Métodos da classe CalculadoraFinanceira

A classe possui os seguintes métodos:

```java
public static double aplicarDesconto(double preco, double desconto)
```

Aplica um desconto em valor fixo sobre o preço informado.

Exemplo conceitual:

```text
preço 100, desconto 20 → resultado 80
```

```java
public static double aplicarDesconto(double preco, int porcentagem)
```

Aplica um desconto percentual sobre o preço informado.

Exemplo conceitual:

```text
preço 100, desconto 10% → resultado 90
```

```java
public static double aplicarAcrescimo(double preco, int porcentagem)
```

Aplica um acréscimo percentual sobre o preço informado.

Exemplo conceitual:

```text
preço 100, acréscimo 10% → resultado 110
```

```java
public static double calcularTotal(double preco, int quantidade)
```

Calcula o valor total multiplicando o preço pela quantidade.

Exemplo conceitual:

```text
preço 50, quantidade 3 → resultado 150
```

```java
public static void exibirValor(String descricao, double valor)
```

Exibe um valor formatado no console com duas casas decimais.

Exemplo de saída:

```text
Total da compra: R$ 150,00
```

## Validações aplicadas na CalculadoraFinanceira

A classe possui validações simples para evitar cálculos com valores inadequados:

* preço negativo é tratado como zero;
* desconto negativo é tratado como zero;
* porcentagem negativa é tratada como zero;
* porcentagem acima de 100 é limitada a 100.

Essas validações tornam os métodos mais seguros para os testes iniciais do projeto.

## Observação didática sobre a CalculadoraFinanceira

A classe `CalculadoraFinanceira` ajuda a praticar o uso de métodos estáticos em Java.

Diferente de classes como `Produto`, `Cliente` e `Venda`, ela não precisa ter atributos de instância.

Isso reforça a diferença entre:

```text
Entidade → representa algo do domínio do sistema
Utilitário → oferece operações auxiliares
Serviço → executa ações sobre objetos
```

Neste projeto:

```text
Produto → entidade
Cliente → entidade
Venda → entidade
GerenciadorEstoque → serviço
CalculadoraFinanceira → utilitário
```

## Melhorias futuras na CalculadoraFinanceira

Algumas melhorias podem ser aplicadas futuramente:

* impedir que desconto fixo maior que o preço gere valor negativo;
* validar quantidade negativa no método `calcularTotal`;
* padronizar melhor as regras de arredondamento;
* usar a classe em conjunto com `Venda` ou `Caixa` quando o fluxo principal for montado.

Essas melhorias foram registradas como evolução possível, sem adicionar complexidade antes do momento certo do curso.

## Aprendizados consolidados

Até este ponto, o projeto já ajudou a consolidar:

* criação de classes em pacotes diferentes;
* uso de `import`;
* encapsulamento com atributos privados;
* validações em setters;
* uso de construtores sobrecarregados;
* uso de métodos estáticos;
* uso de atributos estáticos;
* relacionamento entre objetos;
* separação básica de responsabilidades;
* diferença entre entidade, serviço e classe utilitária;
* passagem de valores primitivos e objetos como parâmetros;
* cálculo de valores com métodos reutilizáveis.

## Status atual

As classes `Produto`, `Cliente`, `Venda`, `GerenciadorEstoque` e `CalculadoraFinanceira` estão implementadas.

O próximo passo do projeto é desenvolver a classe `Caixa`, localizada no pacote `servicos`.

Depois disso, o projeto deve avançar para a classe principal `Aplicacao`, onde o fluxo completo da loja será testado.

## Próximos passos

* implementar a classe `Caixa`;
* criar exemplos de uso na classe `Aplicacao`;
* testar criação de produtos;
* testar criação de clientes;
* testar conclusão de vendas;
* testar alteração de estoque;
* testar cálculos financeiros;
* revisar nomes de variáveis, métodos e classes;
* documentar o resultado final do projeto.

## Autor

Gustavo Anacleto
