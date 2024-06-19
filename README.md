# Kafka Messaging with Spring Boot

## Project Overview

This project demonstrates how to integrate Apache Kafka with Spring Boot to send and receive messages using a REST API. It includes the setup of Kafka producers and consumers, configuration of Kafka topics, and a REST controller to send messages to the Kafka server. The application also streams a large number of messages to the Kafka server, which can be consumed by a Kafka consumer class.

## Features

- **Kafka Producer and Consumer Configuration**: Configures Kafka to send and receive messages.
- **REST API Integration**: Provides endpoints to send messages to Kafka using HTTP POST requests.
- **High-Volume Message Streaming**: Sends a stream of 10 million messages to the Kafka server.
- **Spring Boot Integration**: Uses Spring Boot for easy setup and integration.

## Prerequisites

- Java 11 or higher
- Apache Maven
- Apache Kafka
- Zookeeper

## Setup Instructions

### Step 1: Clone the Repository

```bash
git clone https://github.com/your-username/kafka-messaging-spring-boot.git
cd kafka-messaging-spring-boot
```
### Step 2: Start Zookeeper

Download and extract Zookeeper from the official website. Then start Zookeeper:
```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```

### Step 3: Start Kafka Server

Download and extract Kafka from the official website. Then start the Kafka server:
```bash
bin/kafka-server-start.sh config/server.properties
```

### Step 4: Configure Application
Ensure you have the following properties set in your application.properties file:

```properties
spring.application.name=kafka-example
spring.kafka.bootstrap-servers=localhost:9092
```

### Step 5: Build and Run the Application
Use Maven to build and run the Spring Boot application:

```bash
mvn clean install
mvn spring-boot:run
```

## Usage
### Sending Messages via REST API

You can send messages to the Kafka server using the provided REST API. Use the following endpoint to send messages:

```bash
POST /api/v1/kafka/send
```

### Request Body

```json
{
  "message": "Your message here"
}
```

### Consuming Messages
Messages sent to the Kafka topic can be consumed using the Kafka consumer configured in the application. The consumer will log the received messages to the console.


### License
This project is licensed under the MIT License.

### End
If you have tried my application and liked how it worked!, then please follow and start the project :) 

Happy Coding! :)
