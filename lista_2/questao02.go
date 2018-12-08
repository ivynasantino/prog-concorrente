package main

import (
	"fmt"
	"time"
    "math/rand"
)

var mirrors = [3]string{"mirror1.com", "mirror2.br", "mirror3.edu"}
var done = make(chan bool)
var primeiro = ""
var r = rand.New(rand.NewSource(time.Now().UnixNano()))

func reliableRequest() string {	
	go request(mirrors[0])
	go request(mirrors[1])
	go request(mirrors[2])
	<- done
	return primeiro
}

func request(serverName string) {
	soneca := time.Duration(r.Int() % 5000) * time.Millisecond
    time.Sleep(soneca)
	if (primeiro == "") {
		primeiro = serverName
	}
	done <- true
}

func main() {
	inicio := time.Now()
	resposta := reliableRequest()
	fim := time.Since(inicio).Seconds()
	if (fim > 2) {
		fmt.Println("Erro: Timeout")
	} else {
		fmt.Println("o primeiro a responder foi ", resposta)
	}
}
