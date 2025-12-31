# Transaction Processing System

## Overview
This project consists of two client applications (Bank A and Bank B) and a central server for processing transactions asynchronously.

## Tech Stack
- Java 25
- Spring Boot
- MySQL 
- JPA 
- Apache JMeter

## Project Structure
- client-bank-a
- client-bank-b
- server-app
- database (schema and seed data)
- requests (sample API & JMeter requests)

## Database Setup
1. Start MySQL
2. Run `database/schema.sql`
3. (Optional) Run `database/seed-data.sql`

## Running Applications
1. Start server-app (port 8081)
2. Start client-bank-a (port 8082)
3. Start client-bank-b (port 8083)

## API Testing
Sample request JSON files are available in the `requests` folder.

## Load Testing
An 8000-request load test was executed using Apache JMeter.
JMeter test plan is available in `requests/jmeter-clientB-load.jmx`.

## Notes
Server processes requests asynchronously using a thread pool to handle high concurrency.
