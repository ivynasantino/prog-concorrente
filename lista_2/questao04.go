package main

import (
	"fmt"
	"runtime"
	"log"
	"encoding/csv"
	"os"
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
	file, err := os.Create("golang.csv")
	if err != nil {
		log.Fatal(err)
	}	
	defer file.Close()
	
	linhaInicial := []string{"execucao", "bytes", "linguagem"}
	
	w := csv.NewWriter(file)
	w.Write(linhaInicial)
	
	for i := 0; i < 100; i++ {
		inicio := getMemUsage()
		fmt.Println("o primeiro a responder foi ", reliableRequest())
		total := getMemUsage() - inicio
		linha := []string{fmt.Sprintf("%d", i), fmt.Sprintf("%d", total), "go"}
		w.Write(linha)
	}
	
	w.Flush()
}


func getMemUsage() uint64 {
	var m runtime.MemStats
	runtime.ReadMemStats(&m)
	return m.TotalAlloc	
}
