package main

import (
	"fmt"
)

var mirrors = [3]string{"mirror1.com", "mirror2.br", "mirror3.edu"}
var done = make(chan bool)
var primeiro = ""

func reliableRequest() string {	
	go request(mirrors[0])
	go request(mirrors[1])
	go request(mirrors[2])
	<- done
	return primeiro
}

func request(serverName string) {
	if (primeiro == "") {
		primeiro = serverName
	}
	done <- true
}

func main() {
	fmt.Println("o primeiro a responder foi ", reliableRequest())
}
