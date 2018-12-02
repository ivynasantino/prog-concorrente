# Questão 8

```sh
a) Para proteger a região crítica com exclusão mútua necessita-se de um semáforo com valor igual a 1, pois o método wait() decrementa o nosso semáforo e estando em zero se outra thread tentar o acesso a região crítica será bloqueada e quando o post() for acionado incrementa o valor do semáforo em 1 e a thread irá sair da região crítica, sendo assim irá liberar o acesso para que outra thread possa entrar. 
```

```sh
b) 13 threads poderão ter acesso a região crítica.
```

```sh
c) i- Após realizar o wait() e decrementar S, como S será zero, o processo 1 acessará a região crítica sozinho e incrementa Q para 2, acordando o processo 2. O processo 2, executará o wait() decrementando o Q para 1 permitindo que o processo 1 entre na região crítica b.
```

```sh
d) 
```
