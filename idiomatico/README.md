# Idiomatico

## Descrição
Um código idiomático é aquele usa os recursos de uma linguagem de programação de um jeito adequado ao problema em questão, ou seja, a escrita dele parece natural, é de fácil compreensão para usuários que dominam aquela linguagem. Ele tende a ser conciso, fácil de verificar e fácil de expandir.

## Efeitos
Um código escrito de forma não idiomática é difícil de fazer manutenção e corrigir bugs pela dificuldade de compreensão até mesmo por pessoas que programam naquela linguagem. A escrita do código precisa levar em conta não só a sintaxe correta, mas as boas práticas e padrões de escrita daquela comunidade. 

### Maus cheiros

“Maus cheiros” de código são pontos em que há possibilidades para aplicação de refatoração.
Um exemplo de mau cheiro são instruções de switch ... case.

### Relação com maus cheiros
### Instruções switch
Em OO é comum ver a mesma instrução switch ... case em diversos pontos do projeto (duplicação de código).
Algumas linguagens de programação oferece soluções para evitar o switch case, evitando duplicação de código. Ex: python com o uso de dicionários ou mapeamentos e javascript com o map.

## Código duplicado

Temos um programa que recebe um código numérico de erro e precisa imprimir uma mensagem de erro correspondente. 
Aqui está um exemplo de código não idiomático, pois está escrito em python mas se utiliza de recursos de linguegens como C.

``` 
def exibir_mensagem_erro(codigo_erro):
    if codigo_erro == 1:
        print("Erro: Divisão por zero.")
    elif codigo_erro == 2:
        print("Erro: Arquivo não encontrado.")
    elif codigo_erro == 3:
        print("Erro: Valor inválido.")
    elif codigo_erro == 4:
        print("Erro: Conexão recusada.")
    elif codigo_erro == 5:
        print("Erro: Limite de tempo excedido.")
    else:
        print("Erro desconhecido.")

```
Neste exemplo, temos uma função exibir_mensagem_erro que recebe um código de erro como entrada e imprime a mensagem de erro correspondente. No entanto, podemos ver que o código contém repetições desnecessárias. A estrutura do switch-case pode se tornar mais complicada e difícil de manter à medida que o número de casos aumenta.

## Refatoração

Podemos melhorar isso usando uma abordagem mais idiomática, usando recursos da própria linguagem como um mapeamento de dicionário, que evita a duplicação de código:

```
def exibir_mensagem_erro(codigo_erro):
    mensagens = {
        1: "Erro: Divisão por zero.",
        2: "Erro: Arquivo não encontrado.",
        3: "Erro: Valor inválido.",
        4: "Erro: Conexão recusada.",
        5: "Erro: Limite de tempo excedido."
    }

    print(mensagens.get(codigo_erro, "Erro desconhecido."))

```

## versionamento

| Versão |   Data   |      Alteração       | Participantes  |
| :----: | :------: | :------------------: | :------------: |
|  1.0   | 19/07/23 | Criação do documento | Thaís Rebouças |