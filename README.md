## About The Project

Este proyecto es un ejercicio de programacion de código propuesto por Sequra.
https://gist.github.com/francesc/33239117e4986459a9ff9f6ea64b4e80

He intentado mantenerme dentro del limite de tiempo (sin exito) y desarrollar los casos de uso identificados.

Esta es mi propuesta...

### USE CASES
Complete Order: 
Update order with completed date, then calculate order fee amount and create disbursement asociate.


Get Disbursements:
Generate weekly disbursements:

##### GETALL

### Built With
* SpringBoot 2.6.3
* Maven
* Java 8
* MySQL 8 in a Docker container
* Docker to build and run de project

## Getting Started
### Prerequisites
Tener docker instalado en la maquina.
Se ha probado en Windows (https://docs.docker.com/desktop/windows/install/) y Mac (https://docs.docker.com/desktop/mac/install/), 

### Installation
<p>La instalación y ejecución del proyecto se hace desde linea de comandos, puedes utilizar tu terminal favorita</p>
<p>Aqui tienes las lista de comandos a utilizar:</p>
<p>Construir una imagen Docker con la versión actual de la sequrademo:0.0.2.jar </p>

> docker build -t sequrademo:0.0.3 .

<p>Levantar la aplicación y sus dependencias con Docker Compose</p>

> docker-compose up -d 

<p>Cuando hayas terminado de ejecutar la aplicacion, para parar los contenedores Docker</p>

> docker-compose down
> 
<p>Parar los contenedores</p>

> docker-compose down

## Usage


#### Request example:
curl --request POST 'http://localhost:8080/sequerademo/order/completed/6'

curl --request GET 'http://localhost:8080/sequerademo/disbursements/202207'

curl --request PUT 'http://localhost:8080/sequerademo/disbursements/process'

## Testing
Para correr los test es necesario ejecutar:
docker docker build -t sequrademo:0.0.2 ./DockerFile


## ToDo: 
* SQL Model: Most Keys and constrains are omited for time limit. 
* Manage exceptions.
* Configure log and use it to trace the flow
* RichDomain vs EntityObjects
* DDD or Domain Events to create Disbursement when Order is complete?

CONSIDRERACIONES:
CompleteOrderUseCase:
He implementado dos formas de iniciar el calculo de los disburs
En linea, siempre que un pedido se marca como completado, se genera su disbur obteniendo la tarifa asociada en ese momento.
Asumo que la tarifa se genera en el momento de completar el pedido y no en el momento de creación del pedido.

GenerateWeeklyDisbursementsUseCase:
Se expone una api que puede llamarse mediante un scheduler para iniciar el proceso de generarión de disburs
No he implementado la conversión de DateTime a Week (Formato YearWeekNumber -> yyyyww) es un mock que devuelve "202207"
No he implementado la busqueda de pedidos de la semana anterior, devuelve los pedidos completados de los ultimos 7 días de la ejecución.
Se está delegando esa responsabilidad al scheduler y quizas no es buena idea

GetDisbursementsUseCase:
Devuelve los disburs por semana (yyyyww) y por merchantID, no se implementan control de excepciones, validaciones ni logs

General:
Por ahorro de tiempo he decidido no implementar validaciones de parametros nulos y sus excepciones asociadas.
Ademas el modelo de datos es simple sin foreingKeys que los relacione.
Los 3 casos de Uso se exponen via Api, pero están aislados para poder implementar cualquier otro modo de invocación.


## Contact

David Murciego - davidmurciego@gmail.com

Project Link: [https://github.com/your_username/repo_name](https://github.com/your_username/repo_name)

(<a href="#top">back to top</a>)
