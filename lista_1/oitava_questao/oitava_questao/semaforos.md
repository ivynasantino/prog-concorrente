# Questão 8


a) Para proteger a região crítica com exclusão mútua necessita-se de um semáforo com valor inicial igual a 1, pois o método wait() decrementa o semáforo, e, estando em zero, se outra thread tentar o acesso a região crítica será bloqueada e, quando o post() for acionado, incrementa o valor do semáforo em 1 e a thread irá sair da região crítica. Sendo assim, o acesso a região crítica será liberado. 


b) 13 threads poderão ter acesso a região crítica.



c) i- Se o processo 1 iniciar primeiro, após realizar o wait() e decrementar S, como S será zero, o processo 1 acessará a região crítica sozinho e irá realizar o post(), incrementando Q para 2. Quando o processo 2 iniciar sua execução e realizar o wait(), o valor de Q será decrementado para 1, permitindo que outro processo acesse a região crítica. Após isso, incrementará S para 1, sinalizando que a região crítica a() agora pode ser acessada.
	Se o processo 2 iniciar primeiro a situação será análoga, diferindo apenas na ordem que Q e S são incrementados e decrementados, já que, como dito na questão, ambos iniciam com o mesmo valor.
	
ii - Com S = 1 e Q = 0: Se o processo 1 executar primeiro, o wait() decrementará o S, fazendo com que S zere e ele acessa a região crítica sozinho. Após isso, ele realiza o post(), incrementando Q. Quando o processo 2, iniciar sua execução, decrementará Q para zero por causa do wait(), entrando na região crítica sozinho e após isso, realizará post() em S, incrementa S liberando o acesso à região crítica a().
	Se o processo 2 executar primeiro será bloqueado ao fazer o wait(), pois o Q já está em zero. Quando o processo 1 iniciar sua execução, acessará sozinho a região crítica a() e após isso, realizará o post() de Q, liberando o processo 2, que acessará sua região crítica e fará o post() em S, deixando-o em 1.
	
Com S = 0 e Q = 1: Se o processo 1 executar primeiro será bloqueado ao fazer o wait(), pois o S já está em zero. Quando o processo 2 iniciar sua execução, acessará sozinho a região crítica b() e após isso, realizará o post() de S, liberando o processo 1, que acessará sua região crítica e fará o post() en Q, deixando-o em 1.
	Se o processo 2 executar primeiro, o wait() decrementará o Q, fazendo com que Q zere e ele acessa a região crítica sozinho. Após isso, ele realiza o post(), incrementando S. Quando o processo 1, iniciar sua execução, decrementará S para zero por causa do wait(), entrando na região crítica sozinho e após isso, realizará post() em Q, incrementa Q liberando o acesso à região crítica a(). 
	
iii - Quando ambos são inicializados em zero, independente de qual processo executar primeiro, nenhum dos processos conseguirão acessar sua região crítica, já que as operações de post() em S e Q não serão realizadas.



d) Se o processo 1 executar primeiro, será realizado o decremento de Q e S, respectivamente, através do wait(). Sendo assim, ele acessará a região crítica a() sozinho. Após isso, realizará o post() em S e Q, respectivamente, incrementando-os. Quando o processo 2 iniciar, o wait() será realizado em S e Q, decrementando-os e ele terá o acesso a região crítica b() sozinho, após isso o post() será realizado em Q e S, respectivamente.
	Se o processo 2 executar primeiro, a situação é análoga, diferindo apenas na ordem que Q e S são incrementados e decrementados.
