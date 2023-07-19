// Neste exemplo, temos um método simples que verifica se um número é primo. Ele utiliza um loop for para iterar até a raiz quadrada do número e verifica se o número é divisível por algum valor no intervalo. O código é claro e direto, utilizando uma abordagem simples para determinar se o número é primo ou não.

public static boolean isPrime(int number) {
    if (number <= 1) {
        return false;
    }
    for (int i = 2; i <= Math.sqrt(number); i++) {
        if (number % i == 0) {
            return false;
        }
    }
    return true;
}