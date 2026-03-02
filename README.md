# Project Pub-Sub

Este projeto é uma Prova de Conceito (PoC) que demonstra uma Arquitetura Orientada a Eventos (EDA) utilizando Java, Spring Boot e Apache Kafka. O sistema consiste em dois microsserviços desacoplados que se comunicam de forma assíncrona.

## 🏗️ Arquitetura

O projeto é dividido em dois módulos principais:

1.  **ms-pub (Publisher)**:
    *   Atua como o produtor de mensagens.
    *   Expõe uma API REST para receber dados externos.
    *   Publica mensagens JSON em um tópico do Kafka.
2.  **ms-sub (Subscriber)**:
    *   Atua como o consumidor.
    *   Escuta o tópico `My.Test.Topic.1` (grupo `my-group`).
    *   Processa e loga as mensagens recebidas.

## 🚀 Tecnologias Utilizadas

*   **Java 17**
*   **Spring Boot** (Web, Kafka)
*   **Apache Kafka**
*   **Maven**
*   **Lombok** (Para redução de boilerplate code)
*   **Jackson** (Para serialização/deserialização de JSON)

## ⚙️ Pré-requisitos

*   JDK 17+ instalado.
*   Apache Kafka rodando (Zookeeper e Broker) acessível em `localhost:9092`.
*   Maven (ou utilizar o wrapper `mvnw` incluído).

## 🏃‍♂️ Como Executar

### 1. Iniciar o Kafka
Certifique-se de que seu ambiente Kafka está ativo e rodando.

### 2. Executar o Consumidor (ms-sub)
Em um terminal, navegue até a pasta `ms-sub`:
```bash
./mvnw spring-boot:run
```

### 3. Executar o Produtor (ms-pub)
Em outro terminal, navegue até a pasta `ms-pub`:
```bash
./mvnw spring-boot:run
```
*Nota: Certifique-se de que os serviços não conflitem na mesma porta HTTP (padrão 8080). Verifique o `application.properties` de cada módulo se necessário.*

## 📡 Como Usar

Para disparar um evento, envie uma requisição POST para o `ms-pub`.

**Endpoint:** `POST /pub/text`

**Exemplo cURL:**
```bash
curl -X POST http://localhost:8080/pub/text \
-H "Content-Type: application/json" \
-d '{"key1": "Olá", "key2": "Mundo Kafka"}'
```

No console do **ms-sub**, você deverá ver a mensagem sendo processada:
`Message receivedJsonMessage(key1=Olá, key2=Mundo Kafka)`