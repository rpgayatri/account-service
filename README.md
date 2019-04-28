# account-service

account-service is a Java backend service built on **Spring Boot** which does the following operations:
1) Fetch all the bank accounts for a given user
2) Fetch all the account transactions for a given user account

This service has been designed in **MVC Architecture Pattern** and uses **Jpa** for persisting objects in the Database. The functionalities for the service is testing with **Junit** test cases and integration testing has been performed with **MockMvc**.

The application has been containerised with **Docker**. 


# Running the service
The application can be run in 2 ways :

1)  [Run in standard way](#run-in-standard-way)
2)  [Run with Docker](#run-with-docker)
  


## Run in standard way
### Prerequisites
Make sure you have **Java 8** and **Maven** installed in your machine and added to your environment path. The commands are expected to work on **Mac** and **Linux** Environment.

### Steps to run
1) Clone the project in your local with the following command

    

    ```git clone https://github.com/rpgayatri/account-service.git```

    
2) From command-line, goto the account-service directory which you have just cloned now

    ```cd accountservice```
   
3) By default, the application has a remote datasource configured. If you want to use your local or remote datasource with the application, follow here -   [Configuring database](#configuring-database)

4) Run the following **maven command** :

    ```mvn package```
    
    This command will **compile** the code and also **package** it.
5) After you see the **Build Success**, you can see the jar file (accountservice-0.0.1-SNAPSHOT.jar) being generated in the path ```target/```

6) Run the following command to run the application from ```accountservice/``` directory :

    ```java -jar target/accountservice-0.0.1-SNAPSHOT.jar```

### Configuring database
By Default, the application is configured with an Open-Source Remote MySQL Database which already has some test data.

If you want to configure your own database for this service, do the following :

1) Go to the following directory inside the **accountservice** directory :

    ```cd src/main/resources/``` 
2) You will find the file **application.properties** inside this directory. You can configure your local or remote database name, username, password and host in the following properties of the file:
```bash
spring.datasource.url=YOUR_DATASOURCE_URL
spring.datasource.username=YOUR_DATASOURCE_USERNAME
spring.datasource.password=YOUR_DATASOURCE_PASSWORD
```
## Run with Docker
### Prerequisites
You should have **Docker** installed in your system. The commands are expected to work on **Mac** and **Linux** Environment.
### Steps to run with Docker
1) In the **accountservice** directory, there will be 3 shell scripts (build-docker.sh, run-docker.sh, stop-docker.sh). Give appropriate permissions to the scripts with the following commands from your command-line :

```bash
chmod a+x build-docker.sh
```
```bash
chmod a+x run-docker.sh
```
```bash
chmod a+x stop-docker.sh
```
2) After giving the permissions, run the **build-docker.sh** script to create a docker image for the application :
```bash
./build-docker.sh
```
3) After the build succeeds and the image creation steps are completed with the message ```Successfully built gayatri/accountservice:latest``` in the last few lines of script execution, you can verify if the image is successfully created by getting an entry with the following command :
```bash
docker images gayatri/accountservice:latest
```

4)  After verification of image creation, run the **run-docker.sh** script to create container of the application :
```bash
./run-docker.sh
```
5) After you see this message in your command-line ```Tomcat started on port(s): 8080 (http) with context path ''```, goto browser and access this URL [http://localhost:8080/](http://localhost:8080/). You will see the following message in the browser :

> Hello! Welcome to bank-account service
6) The application is successfully started with Docker
7) To stop the docker container, run the **stop-docker.sh** script :
```bash
./stop.sh
```
# Testing the APIs
Below is the sample data for **user_account** table that I have inserted into the remote MySQL Database (which is currently configured in the application)  :
```bash
mysql> select * from user_account;
+----------------+---------+------------------+--------------+---------------------+----------+-----------------+
| account_number | user_id | account_name     | account_type | balance_date        | currency | opening_balance |
+----------------+---------+------------------+--------------+---------------------+----------+-----------------+
| 456-123-123    | user5   | user-1 account-1 | CURRENT      | 2019-04-27 14:00:00 | AUD      |          100.21 |
| 456-123-124    | user6   | user-2 account-1 | SAVINGS      | 2019-04-27 14:00:00 | AUD      |         1232.21 |
| 456-123-125    | user7   | user-1 account-2 | SAVINGS      | 2019-04-27 14:00:00 | AUD      |          123.21 |
+----------------+---------+------------------+--------------+---------------------+----------+-----------------+
```

Below is the sample data for **account_transaction** table that I have inserted into the remote MySQL Database (which is currently configured in the application)  :
```bash
mysql> select * from account_transaction;
+----+---------------+----------+--------------+---------------------------------+--------------+------------+----------------+---------+
| id | credit_amount | currency | debit_amount | transaction_narrative           | debit_credit | value_date | account_number | user_id |
+----+---------------+----------+--------------+---------------------------------+--------------+------------+----------------+---------+
| 47 |      12313.12 | AUD      |         0.00 | test narrative for transaction1 | CREDIT       | 2019-04-27 | 456-123-123    | user5   |
| 48 |          0.00 | AUD      |     12313.12 | test narrative for transaction2 | DEBIT        | 2019-04-27 | 456-123-123    | user5   |
| 49 |      10000.00 | AUD      |         0.00 | test narrative for transaction3 | CREDIT       | 2019-04-27 | 456-123-124    | user6   |
| 50 |      12313.12 | AUD      |         0.00 | test narrative for transaction1 | CREDIT       | 2019-04-27 | 456-123-123    | user5   |
| 51 |          0.00 | AUD      |     12313.12 | test narrative for transaction2 | DEBIT        | 2019-04-27 | 456-123-123    | user5   |
| 52 |      10000.00 | AUD      |         0.00 | test narrative for transaction3 | CREDIT       | 2019-04-27 | 456-123-124    | user6   |
+----+---------------+----------+--------------+---------------------------------+--------------+------------+----------------+---------+
```
## getAccountsForUserId API
To test the API, run the following **curl script** :
```bash
curl -X GET 'http://localhost:8080/accounts?userId=user5'
```
You get the following response for the sample data given above :
```bash
[{"accountIdentity":{"userId":"user5","accountNumber":"456-123-123"},"accountName":"user-1 account-1","balanceDate":"2019-04-27","currency":{"code":"AUD","numericCode":36,"decimalPlaces":2,"symbol":"AUD","numeric3Code":"036","countryCodes":["CC","TV","AU","NR","CX","HM","NF","KI"],"pseudoCurrency":false},"openingAvailableBalance":100.21,"accountType":"CURRENT"}]
```
## getTransactionsForAccountNumber API
To test the API, run the following **curl script** :
```bash
curl -X GET 'http://localhost:8080/transactions?accountNumber=456-123-123'
```
You get the following response for the sample data given above :
```bash
[{"id":47,"valueDate":"2019-04-27","currency":{"code":"AUD","numericCode":36,"decimalPlaces":2,"symbol":"AUD","numeric3Code":"036","countryCodes":["CC","TV","AU","NR","CX","HM","NF","KI"],"pseudoCurrency":false},"debitAmount":0.00,"creditAmount":12313.12,"transactionType":"CREDIT","transactionNarrative":"test narrative for transaction1"},{"id":48,"valueDate":"2019-04-27","currency":{"code":"AUD","numericCode":36,"decimalPlaces":2,"symbol":"AUD","numeric3Code":"036","countryCodes":["CC","TV","AU","NR","CX","HM","NF","KI"],"pseudoCurrency":false},"debitAmount":12313.12,"creditAmount":0.00,"transactionType":"DEBIT","transactionNarrative":"test narrative for transaction2"},{"id":50,"valueDate":"2019-04-27","currency":{"code":"AUD","numericCode":36,"decimalPlaces":2,"symbol":"AUD","numeric3Code":"036","countryCodes":["CC","TV","AU","NR","CX","HM","NF","KI"],"pseudoCurrency":false},"debitAmount":0.00,"creditAmount":12313.12,"transactionType":"CREDIT","transactionNarrative":"test narrative for transaction1"},{"id":51,"valueDate":"2019-04-27","currency":{"code":"AUD","numericCode":36,"decimalPlaces":2,"symbol":"AUD","numeric3Code":"036","countryCodes":["CC","TV","AU","NR","CX","HM","NF","KI"],"pseudoCurrency":false},"debitAmount":12313.12,"creditAmount":0.00,"transactionType":"DEBIT","transactionNarrative":"test narrative for transaction2"}]
```