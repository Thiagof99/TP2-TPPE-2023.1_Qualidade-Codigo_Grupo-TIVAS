# Ausência de duplicidade

## Descrição
Essa característica se baseia na premissa: "Faça uma vez. Faça bem-feito. Evite duplicação."

É dito que códigos bem projetados não tem duplicação, ou seja, não se repetem.
A duplicação, que é inimiga de um design elegante e simples, normalmente vem através de copiar e colar parte do código, que acaba se tornando redundante e desnecessário, levando a um programa frágil, uma vez que existem duas partes de código semelhantes que diferem apenas em detalhes.
Sendo assim, se existir trechos de código separadas realizando tarefas muito semelhantes, o melhor a ser feito é generalizá-los em uma função com parâmetros apropriados, fazendo com que, se houver qualquer falha nesse código, esteja em um lugar só.

## Relação com maus-cheiros
A duplicação de código em si é um mau cheiro bem conhecido, porém há outras características não tão triviais que podem corroborar para que haja essa duplicação desnecessária:

### Duplicação de código
Como citado, a duplicação de código é um mal cheiro muito comum e pode ser resolvido através de refatorações para unificar essa repetição.

### Classe grande
Quando uma classe apresenta muitas variáveis de instâncias é indício de que ela está com coesão baixa (fazendo mais do que deveria) Classes com muito código indica que há grandes chances de haver código duplicado. 

### Instruções switch
Essa instrução, que é muita usada em OO, pode acabar causando duplicação de código, sendo preferível usar polimorfismo no lugar.

## Operação de refatoração: Extração de interface e extração de subclasse
Uma classe chamada "Produto" contém métodos para calcular o preço total tanto para produtos vendidos no varejo quanto no atacado. No entanto, esses métodos têm muita duplicação, já que a lógica para calcular o preço total é semelhante para ambos os tipos de produtos, mas difere em detalhes específicos:

```
public class Produto {
    private String nome;
    private int quantidade;
    private double precoUnitario;
    private boolean isVendaAtacado;

    // Construtor, getters e setters omitidos para simplificação

    public double calcularPrecoTotal() {
        double precoTotal;
        if (isVendaAtacado) {
            if (quantidade >= 100) {
                precoTotal = quantidade * precoUnitario * 0.9; // Desconto de 10% para venda no atacado acima de 100 unidades
            } else {
                precoTotal = quantidade * precoUnitario;
            }
        } else {
            precoTotal = quantidade * precoUnitario;
        }
        return precoTotal;
    }
}
``` 

Para refatorar esse código de forma simples e direta, é necessária a implementação de uma interface chamada "CalculadorPreco" que definirá um método para calcular o preço total. Em seguida a classe será dividida em duas subclasses: "ProdutoVarejo" e "ProdutoAtacado", que implementam essa interface e fornecem a implementação específica para o cálculo do preço total:

```
public interface CalculadorPreco {
    double calcularPrecoTotal();
}

public abstract class ProdutoBase implements CalculadorPreco {
    protected String nome;
    protected int quantidade;
    protected double precoUnitario;

    // Construtor, getters, setters e outros métodos omitidos para simplificação

    // Implementação comum do método da interface
    @Override
    public double calcularPrecoTotal() {
        return quantidade * precoUnitario;
    }
}

public class ProdutoVarejo extends ProdutoBase {
    // Construtor, getters, setters e outros métodos omitidos para simplificação

    // Não é necessário redeclarar o método calcularPrecoTotal(), pois ele já está implementado na classe base.
}

public class ProdutoAtacado extends ProdutoBase {
    // Construtor, getters, setters e outros métodos omitidos para simplificação

    // Implementação específica para calcular o preço total com desconto para venda no atacado
    @Override
    public double calcularPrecoTotal() {
        double precoTotalSemDesconto = super.calcularPrecoTotal();
        if (quantidade >= 100) {
            return precoTotalSemDesconto * 0.9; // Desconto de 10% para venda no atacado acima de 100 unidades
        } else {
            return precoTotalSemDesconto;
        }
    }
}
``` 

Portanto, foram usadas duas operações de refatoração: a extração de interface, a partir da criação da interface, e a extração de subclasse, quando a classe foi quebrada e se transformou em classes menores.

## Versionamento

| Versão |   Data   |      Alteração       | Participantes |
| :----: | :------: | :------------------: | :-----------: |
|  1.0   | 18/07/23 | Criação do documento | Amanda Nobre  |