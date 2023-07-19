// Neste exemplo, temos uma função que calcula o fatorial de um número. O código é recursivo e utiliza uma abordagem simples para calcular o fatorial, reduzindo o número em cada chamada recursiva até alcançar o caso base (n == 0). O código é claro e expressa de forma concisa o conceito matemático do fatorial.

public static int factorial(int n) {
    if (n == 0) {
        return 1;
    }
    return n * factorial(n - 1);
}