# User Management API

The User Management API is a simple CRUD (Create, Read, Update, Delete) API designed for managing user records. It provides endpoints to perform various user-related operations.

## Endpoints

1. **Create User**

   Create a new user with the specified details.

    - Method: `POST`
    - Endpoint: `/api/save`
    - Request Body:
      ```json
      {
        "id" : 1,
        "firstName": "John",
        "lastName": "Doe",
        "email": "john.doe@example.com"
      }
      ```
    - Response:
      ```json
      {
        "id" : 1,
        "firstName": "John",
        "lastName": "Doe",
        "email": "john.doe@example.com"
      }
      ```

2. **Get User by ID**

   Retrieve user details by their unique ID.

    - Method: `GET`
    - Endpoint: `/api/user/{id}`
    - Response:
      ```json
      {
        "id" : 1,
        "firstName": "John",
        "lastName": "Doe",
        "email": "john.doe@example.com"
      }
      ```

3. **Get All Users**

   Retrieve a list of all users from the database.

    - Method: `GET`
    - Endpoint: `/api/users`
    - Response:
      ```json
      [
        {
        "id" : 1,
        "firstName": "John",
        "lastName": "Doe",
        "email": "john.doe@example.com"
        },
        {
        "id" : 2,
        "firstName": "John",
        "lastName": "Cena",
        "email": "john.cena@example.com"
        }
      ]
      ```

4. **Update User by ID**

   Update user details by their unique ID.

    - Method: `PUT`
    - Endpoint: `/api/update/{id}`
    - Request Body:
      ```json
      {
        "firstName": "John",
        "lastName": "Cena",
        "email": "john.cena@example.com"
      }
      ```
    - Response:
      ```json
      {
        "id" : 2,
        "firstName": "John",
        "lastName": "Cena",
        "email": "john.cena@example.com"
      }
      ```

5. **Delete User**

   Delete a user by their unique ID.

    - Method: `DELETE`
    - Endpoint: `/api/user/{id}`
    - Response: `HTTP 204 No Content`

## OpenAPI Specification (Swagger)

This API is documented using the OpenAPI Specification (formerly known as Swagger). The OpenAPI documentation can be accessed by visiting the following URL in your web browser:

```
http://localhost:8080/swagger-ui/index.html
```

The OpenAPI documentation provides a detailed overview of all the available endpoints, request/response schemas, and other relevant information about the API.

Feel free to explore and use the User Management API for managing user records in your application!

---

