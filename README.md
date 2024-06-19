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

