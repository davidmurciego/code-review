## About The Project

This project is a code programming challenge proposed by Sequra.
https://gist.github.com/francesc/33239117e4986459a9ff9f6ea64b4e80

I have tried to stay within the time limit (without success) and develop the identified use cases.

I have identified 3 use cases that I explain below

### USE CASES
<strong>Complete Order:</strong> 
>Update order with completed date, then calculate order fee amount and create disbursement asociate.
> 
>I consider that Merchants fee and disbursement is calculated by completed order
> 
>Not implemented: call external billing service

<strong>Generate weekly disbursements:</strong>
>Get and iterate the last 7 days completed orders list then per order, calculate and generate the fee and disbursement
>
>I assume that there is an external scheduler that executes the usecase weekly. Maybe this is not a good idea.
> 
>Not implemented: call external billing service

<strong>Get disbursements</strong>
>Get disbursement from completed orders for a given week and merchant(optional)

### Built With
* SpringBoot 2.6.3
* Maven
* Java 8
* MySQL 8 in a Docker container
* Docker

## Getting Started
### Prerequisites
Install Docker
* Windows (https://docs.docker.com/desktop/windows/install/)
* Mac (https://docs.docker.com/desktop/mac/install/), 

### Installation
<p>You can install and run the project from the command line</p>
<p>Here are the list of commands to use:</p>
<p>Build a Docker image with the current version of sequrademo:0.0.3.jar </p> 

> docker build -t sequrademo:0.0.3 .

<p>Run up docker Containers</p>

> docker-compose up -d 

<p>To stop all</p>

> docker-compose down

## Usage
Each use case is exposed via API

<strong>Complete Order:</strong>
<p>No content response</p>

>curl --request POST 'http://localhost:8080/sequerademo/order/completed/6'

<strong>Generate weekly disbursements:</strong>
<p>No content response</p>

> curl --request PUT 'http://localhost:8080/sequerademo/disbursements/process'

<strong>Get disbursements:</strong>
<p>Disbursement list of orders completed in a specific week (pattern yyyyww) </p>

>curl --request GET 'http://localhost:8080/sequerademo/disbursements/202207'


## ToDo: Skipped and not implemented due to time constraints
* Function to get week from date is a Mock: always return 202207
* Parameters validation
* SQL Model: Most Keys and constrains.
* Manage exceptions.
* Configure log and use it to trace the flow
* Authentication and Authorization
* Domain vs EntityObjects
* DDD or Domain Events to create Disbursement when Order is complete?

## Contact

David Murciego - davidmurciego@gmail.com

Project Link: [https://github.com/davidmurciego/code-review](hhttps://github.com/davidmurciego/code-review)

(<a href="#top">back to top</a>)
