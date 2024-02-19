# Welcome to Wishlist Application README File :wave:


## Framework Used
___
```bash
 Springboot
```

## Language Used
___
```bash
 Java
```

## Tools Used
___
```bash
 Intellij IDEA
 Maven
 Postman
 Swagger
```
## Database Used
___
```bash
 MySQL
```

# :office: DataFlow of the program 
<br>

## Client Interaction
___
> The client, such as a web browser or a mobile app, sends HTTP requests to the server for Wishlist Application operations, including signup user, login user , wishlist item etc. (CRUD operations).

## Controller Layer
___
> In the Spring Boot application, the incoming HTTP requests are handled by the Controller layer. The Controller receives the requests and delegates them to the appropriate methods in the service layer.

## Service Layer
___
> The Service layer contains the business logic of the application and handles Wishlist Application operations. When a request is received from the Controller, the Service layer performs the necessary actions. For example, when creating a signup user, login user , wishlist item etc. The Service layer validates the input data, generates a unique identifier, and interacts with the data access layer.

## Data Access Layer
___
> The Data Access layer is responsible for interacting with the MySQL database to perform CRUD operations on the data. It uses SQL to map Java objects to database tables and execute SQL queries.

## Database
___
> The MySQL database stores Wishlist Application data, including signup user, login user , wishlist item etc.

## Response
___
> After the data operation is completed, the response flows back through the layers in the reverse ordersEntity. The Service layer receives the response from the Data Access layer, performs any necessary post-processing or formatting, and sends it back to the Controller.

## Controller Response
___
> The Controller layer receives the response from the Service layer and returns an appropriate HTTP response to the client, indicating the success or failure of the requested operation.

## Security and Authentication 
___
> This application utilizes Spring Security for secure authentication. Upon successful login, which must be included in the headers of subsequent API requests for authorization. It contains encoded information about the user and is verified on the server to ensure the authenticity of the request. This adds a robust layer of security to the application, safeguarding user data and preventing unauthorized access.


## Summary
___
This is a README file for explain the details about the project. This is a Wishlist Application project which is used to signup user, login user , wishlist item etc. In this project we can perform the following functions given below :-

* SignUp a User.
* SignIn a User.
* Get user Wishlist.
* Add Wishlist item.
* Delete Wishlist item.


## Installation and Usage
* Clone the repository to your local machine.
* Make sure you have Java and Maven installed.
* Make sure you have MySQL workbench installed.
* Set up the database according to the configuration in the application properties file.
* Run the application using your preferred IDE.
* Access the API endpoints using tools like Postman , Swagger or your web browser.


## API Endpoints

### SignUp a User

- **Endpoint:** `/api/signUp`
- **Method:** `POST`
- **Request Body:**
  
    ```json
    {
        "userName": "John",
        "email": "john.smith@gmail.com",
        "password": "9876543210"
    }

    ```

### SignIn a User

- **Endpoint:** `/api/signIn`
- **Method:** `POST`
- **Request Body:**

    ```json
    {
        "userName": "John",
        "password": "9876543210"
    }

    ```

### Get a List of WishList Items

- **Endpoint:** `/api/wishlists/get`
- **Method:** `GET`

### Add a WishList Item

- **Endpoint:** `/api/wishlists/add`
- **Method:** `POST`

### Delete a WishList Item

- **Endpoint:** `/api/wishlists/delete`
- **Method:** `DELETE`

### Authentication

    ```json
    {
        "username": john
        "password": 9876543210
    }
    ```


## :frowning_man: Author
___
Rahul Chaurasiya
* Github : [@irahulchaurasiya](https://github.com/irahulchaurasiya/WishList_Xindus)


## :handshake: Contributing
___
Contributions, issues & feature requests are  welcome!

Feel free to contact me at the above github link.

## Show your Support
___
Give a :keycap_ten: if you liked this project.

## :memo: License
___
Copyright :copyright: Rahul Chaurasiya.

This project is licensed for Sunbase.

___
This README was generated with :heart: by Rahul Chaurasiya
