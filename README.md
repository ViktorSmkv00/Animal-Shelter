# Animal Shelter

 A REST API built with Spring Boot used for managing an animal shelter, allowing users to add, update, retrieve, delete, and search animals. Features include REST APIs, Tomcat hosting, and integration with Postman for testing CRUD operations. 

 
 ## Features


- **Adding New Animals** 
- **Retrieve Animals by Species** 
- **Retrieve Animals by Id** 
- **Retrieve All Animals**
- **Update Added Animals**
- **Remove Animals** 


## Technologies Used

- **Java**: Developed using Java programming language.
- **Spring Boot**: Leveraged Spring Boot framework for rapid application development.
- **Tomcat**: Hosted the application on Tomcat server.
- **RESTful API**: Implemented RESTful APIs to enable communication with the application.
- **Postman**: Tested CRUD operations using Postman for API testing.
- **XML:** Data of all added animals is stored in an XML file.
- **JSON:** Submitted animal data and returned results are formatted in JSON.

## Getting Started

### Prerequisites

- Java JDK 8 or higher installed on your system
- Maven build tool installed
- Apache Tomcat installed

   The application will be hosted on Tomcat at [http://localhost:8080](http://localhost:8080).

2. Use Postman or any other API testing tool to interact with the application.

   - **Add New Animal**: Send a `POST` request to `http://localhost:8080/api/animals` with the animal details(type, name, date of birth) in the request body.
   - **Retrieve Animals By Type**: Send a `GET` request to `http://localhost:8080/api/animals/Type/{type}`.
   - **Retrieve Animals By Id**: Send a `GET` request to `http://localhost:8080/api/animals/{id}`.
   - **Retrieve All Animals**: Send a `GET` request to `http://localhost:8080/api/animals`.
   - **Delete Animal by Id**: Send a `DELETE` request to `http://localhost:8080/api/animals/{id}`.
   - **Update Animal by Id**: Send a `PUT` request to `http://localhost:8080/api/animals/{id}`.


## Instructions for Use

1. Clone the repository to your local machine.
2. Ensure you have Java installed.
3. Compile and run the application.
4. Follow the on-screen prompts to interact with the application and manage animal data.


### Acknowledgments

- This project showcases my skills in Java, Spring Boot, RESTful APIs, and Tomcat server deployment.

