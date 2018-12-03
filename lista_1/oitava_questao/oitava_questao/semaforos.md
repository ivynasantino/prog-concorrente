# Questão 8

```sh
a) Para proteger a região crítica com exclusão mútua necessita-se de um semáforo com valor inicial igual a 1, pois o método wait() decrementa o semáforo, e, estando em zero, se outra thread tentar o acesso a região crítica será bloqueada e, quando o post() for acionado, incrementa o valor do semáforo em 1 e a thread irá sair da região crítica. Sendo assim, o acesso a região crítica será liberado. 
```

```sh
b) 13 threads poderão ter acesso a região crítica.
```

```sh
c) i- Se o processo 1 iniciar primeiro, após realizar o wait() e decrementar S, como S será zero, o processo 1 acessará a região crítica sozinho e irá realizar o post(), incrementando Q para 2. Quando o processo 2 iniciar sua execução e realizar o wait(), o valor de Q será decrementado para 1, permitindo que outro processo acesse a região crítica. Após isso, incrementará S para 1, sinalizando que a região crítica a() agora pode ser acessada.
	Se o processo 2 iniciar primeiro a situação será análoga, diferindo apenas na ordem que Q e S são incrementados e decrementados, já que, como dito na questão, ambos iniciam com o mesmo valor.
```

```sh
d) 
```
