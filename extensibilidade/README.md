# Simplicidade

## Descrição

A extensibilidade é um aspecto fundamental na qualidade de um software. Um software extensível é um software capaz de se adaptar e evoluir facilmente para atender a novos requisitos e cenários sem que hajam grandes alterações em sua estrutura.

Um software é extensível permite a adição de novas funcionalidades e a modificação das já existentes sem comprometer o funcionamento do programa. Essa característica é essencial para projetos que são desenvolvidos continuamente e a longo prazo, também auxília muito em equipes compostas por vários desenvolvedores diferentes.

## Relação com maus-cheiros: Código longo

### Código longo

Ao buscar a simplicidade, é importante reduzir o tamanho excessivo de funções ou métodos, pois código longo pode ser difícil de entender. Dividir o código longo em unidades menores e mais coesas aumenta a simplicidade.

## Operações de refatoração: Extrair de interface

A operação de extrair interface é um método de refatoração onde uma nova interface é criada a partir de um código existente. Essa refatoração é utilizada quando vários métodos ou classes se comportam de forma semelhante, ao criar uma interface com a assinatura desses comportamentos, é possível reduzir a implementação dos métodos utilizando o conceito de polimorfismo.

Extrair uma interface melhora a extensibilidade do código pois traz um padrão para a implementação de novos métodos, reduzindo o tamanho do código e facilitando a evolução do mesmo.

## Exemplo:

Vamos supor que estamos criando uma calculadora, uma calculadora pode realizar várias operações matemáticas distintas. Uma forma de implementar essa código é a seguinte:

``` 
public class Calculadora {
    public int adicao(int a, int b) {
        return a + b;
    }

    public int multiplicacao(int a, int b) {
        return a * b;
    }
}
```

Neste exemplo é criado um método para cada operação diferente. Logo, cada nova operação implementada iria requerer a criação de um novo método na classe calculadora, sendo muitas vezes semelhante à um já criado. 

É possível extrair uma interface para as operações, permitindo a adição de novas operações sem a necessidade de alterar a classe Calculadora.

```
interface Operacao {
    int calcular(int a, int b);
}
```

Com essa interface implementada, é possível criar uma classe para cada operação e definir como ela funcionará implementando o método assinado.

```
public class Soma implements Operacao {
    @Override
    public int calcular(int a, int b) {
        return a + b;
    }
}

public class Multiplicacao implements Operacao {
    @Override
    public int calcular(int a, int b) {
        return a * b;
    }
}
```

Por último criamos a classe Calculadora para que possa receber qualquer operação que implementa a interface Operacao.

```
public class Calculadora {
    public int calcular(Operacao operacao, int a, int b) {
        return operacao.calcular(a, b);
    }
}
```
Dessa forma, qualquer operação pode ser acessada pela classe Calculadora, e caso haja a adição ou alteração de alguma operação no código, não há necessidade de alterar nada na classe Calculadora. Isso garante que ao se mexer no código, nada do que já estava funcionando irá quebrar, facilitando sua evolução e ou adaptação.
  
## versionamento

| Versão |   Data   |      Alteração       |  Participantes  |
| :----: | :------: | :------------------: | :-------------: |
|  1.0   | 19/07/23 | Criação do documento | Thiago Oliveira |