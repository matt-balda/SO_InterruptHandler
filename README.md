# Interrupt Handler

Este é um exemplo de uma implementação de manipulação de interrupções em Java. O objetivo deste código é ilustrar como é possível tratar interrupções de forma segura e sincronizada, utilizando Semáforos.

## Estrutura do código

O código inicia com a declaração da classe InterruptHandler, que contém os seguintes membros:

    interruptVector: é um vetor de inteiros que representa o vetor de interrupções. Cada posição deste vetor representa uma interrupção diferente.
    semaphore: é uma instância da classe Semaphore, que será utilizada para garantir a sincronização na manipulação das interrupções.

Na construção da classe, o vetor de interrupções é iniciado com tamanho 10 e o semáforo é criado com um permit inicial igual a 1, o que significa que somente uma thread poderá acessar a seção crítica do código por vez.

O método interruptGenerator é responsável por gerar interrupções. Recebe como parâmetro o número da thread que está gerando a interrupção e gera um número aleatório de 0 a 9 para representar a interrupção gerada. Em seguida, a thread adquire o semáforo e incrementa o contador da interrupção gerada no vetor de interrupções. Por fim, libera o semáforo.

O método interruptTreatment é responsável por tratar as interrupções. Este método é executado em uma thread separada e tem um loop infinito que percorre o vetor de interrupções, verificando se há alguma interrupção para ser tratada. Se houver, a thread adquire o semáforo, trata a interrupção e libera o semáforo.

Por fim, o método main é responsável por iniciar a execução do código. Cria-se uma instância da classe InterruptHandler e iniciam-se 5 threads para gerar interrupções, e uma thread para tratar as interrupções.

# Conclusão

Este é um exemplo simples de como é possível tratar interrupções de forma segura e sincronizada em Java. A utilização de semáforos garante que as interrupções sejam tratadas corretamente, sem correr o risco de interrupções serem perdidas ou duplicadas. Além disso, este exemplo ilustra como é possível utilizar threads para
