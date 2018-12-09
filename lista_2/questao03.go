package main

import (
	"fmt"
	"time"
    "math/rand"
    "os"
)

var mirrors = [3]string{"mirror1.com", "mirror2.br", "mirror3.edu"}
var done = make(chan bool)
var primeiro = ""
var r = rand.New(rand.NewSource(time.Now().UnixNano()))

func reliableRequest() string {	
	go request(mirrors[0])
	go request(mirrors[1])
	go request(mirrors[2])
	<-done
	return primeiro
}

func request(serverName string) {
	soneca := time.Duration(r.Int() % 5000) * time.Millisecond
    time.Sleep(soneca * 5)
	if (primeiro == "") {
		primeiro = serverName
	}
	done <- true
}

func makeRequests() {
	for {
		select {
		case <-done:
			fmt.Println("Sinal recebido, encerrando execução")
			return
		default:
			inicio := time.Now()
			resposta := reliableRequest()
			fim := time.Since(inicio).Seconds()
			if (fim > 2) {
				fmt.Println("Erro: Timeout")
			} else {
				fmt.Println("o primeiro a responder foi ", resposta)
			}
		}
	}
}

func cancel() {
	os.Stdin.Read(make([]byte, 1))
	close(done)
}


func main() {
	go cancel()
	makeRequests()
}
