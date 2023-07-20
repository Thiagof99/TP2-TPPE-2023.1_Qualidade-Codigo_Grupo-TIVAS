# Modularidade

## Descrição

A modularidade em projetos de software se refere à prática de dividir o código em partes independentes, cada um representando uma unidade lógica e funcional. Cada módulo possui uma clara responsabilidade e contém funcionalidades relacionadas. Essa abordagem tem diversos efeitos positivos no código.

1. Estrutura organizada: a modularidade cria uma estrutura organizada no código, facilitando a divisão do sistema em partes menores e mais gerenciáveis. Cada módulo é como um bloco de construção que, quando combinado com outros módulos, forma o sistema como um todo;

2. Claridade e compreensão: módulos independentes tornam o código mais claro e compreensível. Os desenvolvedores podem se concentrar em um local específico de cada vez, entendendo sua funcionalidade e responsabilidade sem se preocupar com detalhes de outras partes do sistema;

3. Coesão interna: cada módulo deve conter funcionalidades relacionadas que trabalham juntas de forma coesa, melhorando a organização do código, tornando-o mais mais fácil de ser mantido;

4. Baixo acoplamento: módulos com baixo acoplamento têm poucas dependências entre si, o que torna o código mais flexível e menos propenso a efeitos colaterais.

## Relação com os maus-cheiros: "Mudança divergente"

Esse mau-cheiro ocorre quando uma única alteração no código requer várias mudanças em diferentes partes do sistema. A modularidade ajuda a combater esse problema, pois cada módulo é responsável por uma funcionalidade específica, tornando as alterações mais localizadas.

## Operação de refatoração: "Extrair módulo"

Consiste em identificar funcionalidades relacionadas em um módulo existente e movê-las para um novo módulo, criando assim uma unidade lógica mais coesa e independente. Isso ajuda a reduzir o acoplamento e melhora a estruturação do código. Essa refatoração facilita a manutenção e evolução do código ao longo do tempo.

### Exemplo

Dado o seguinte módulo:

```js
// Módulo "Calculadora"

const calculadora = {
  somar: (a, b) => a + b,
  subtrair: (a, b) => a - b,
  multiplicar: (a, b) => a * b,
  dividir: (a, b) => a / b,

  calcularMedia: (valores) => valores.reduce((acc, curr) => acc + curr, 0) / valores.length,
};
```

É possível extrair a funcionalidade de calcular média para um novo módulo

```js
// Módulo "CalculadoraEstatistica"

const calculadoraEstatistica = {
  calcularMedia: (valores) => valores.reduce((acc, curr) => acc + curr, 0) / valores.length,
};
```

## Versionamento

| Versão |    Data    |      Alteração       |        Participantes        |
| :----: | :--------: | :------------------: | :-------------------------: |
|  1.0   | 19/07/2023 | Criação do documento | Irwin Schmitt e Sara Campos |
