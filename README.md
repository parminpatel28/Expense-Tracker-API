# Expense Tracker API

## Requirements
https://roadmap.sh/projects/expense-tracker-api
## Setup
1. In root directory run `./gradlew clean build -x test`
2. Run the docker file to run the database and the Spring boot project using `docker compose up --build`

## API Endpoints

Server is hosted on: `http://localhost:8080`

### Authentication Endpoints
To call the Auth endpoints no JWT token is required. 
1. Sign up: ``POST /auth/signup``
    
    Request Body: `` {
   "email": "EMAIL_HERE",
   "password": "PASSWORD_HERE",
   "fullName": "FIRST_NAME LAST_NAME"
   }``

2. Login: ``POST /auth/login``

   Request Body: `` {
   "email": "EMAIL_HERE",
   "password": "PASSWORD_HERE"
   }``

   Response Body: `` {
   "token": "JWT_TOKEN",
   "expiryTime": XXXXXX
   }``

### Expense Tracker Endpoints
When calling the following endpoints below a `JWT_TOKEN` must be passed into the headers as a Bearer Token.

1. Create Expense: ``POST /expense/create``

   Request Body: `` {
   "amount": XXX,
   "expenseType": "EXPENSE_TYPE"
   }``
2. Update Expense: ``PUT /expense/update/{id}``

   Request Body: `` {
   "amount": XXX,
   "expenseType": "EXPENSE_TYPE"
   }``
2. Update Expense: ``DELETE /expense/delete/{id}``

