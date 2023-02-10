# Manipulador de Interrupções

## Introdução
Exemplo de implementação de manipulação de interrupções em Java, ilustrando o tratamento seguro e sincronizado de interrupções com o uso de Semáforos.

## Estrutura do código
- Classe InterruptHandler:

    - interruptVector: vetor de interrupções representado por inteiros.
    - semaphore: instância da classe Semaphore para garantir sincronização.
    - Inicialização do vetor com tamanho 10 e semáforo com permit inicial 1 (acesso a seção crítica por vez).
    - Método interruptGenerator: gera interrupções com número aleatório de 0 a 9 e incrementa o contador da interrupção no vetor.
    - Método interruptTreatment: loop infinito para verificar e tratar interrupções no vetor.
    - Método main: cria instância da classe e inicia 5 threads para gerar interrupções e uma para tratar.

## Conclusão
Exemplo simples de tratamento seguro e sincronizado de interrupções em Java com uso de semáforos para evitar perda ou duplicação de interrupções. Ilustra também o uso de threads.

## Autores
Este código foi desenvolvido por Mateus Balda & Julio Silveira.
