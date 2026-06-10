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
* [ ] Implementar a classe `Cliente`
* [ ] Implementar a classe `Venda`
* [ ] Implementar a classe `CalculadoraFinanceira`
* [ ] Implementar a classe `GerenciadorEstoque`
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

## Status atual

A classe `Produto` está concluída. O próximo passo é implementar a classe `Cliente`.

## Autor

Gustavo Anacleto
