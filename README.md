# Simple Online Bookstore Application

This project is a simple online bookstore application built using Spring and Hibernate. The application provides a RESTful API that allows users to perform CRUD operations on books, authors, and genres. Books have attributes such as title, author, genre, price, and quantity. Users can also search for books by title, author, or genre. Data is persisted in a relational database using Hibernate.

## Getting Started

To run the application, follow these steps:

### Prerequisites

- Maven 3.9.5
- Java 11
- Spring Boot 2

### Clone the Repository
git clone https://github.com/adrian052/chat-gpt-level2.git
### Build the Application
cd chat-gpt-level2
mvn clean install

### Run the Application
mvn spring-boot:run

The application will be accessible at `http://localhost:8080`.

## Questions and Answers

### Was it easy to complete the task using AI?

Yes, it was relatively easy to complete the task using AI, especially with the assistance provided in generating the code structure and specific components.

### How long did the task take you to complete?

The task took approximately X hours to complete.

### Was the code ready to run after generation? What did you have to change to make it usable?

The generated code provided a solid foundation, but it required additional implementation for specific business logic and database configuration. Additionally, unit tests and error handling were added to make the code more robust and production-ready.

### Which challenges did you face during completion of the task?

The main challenges faced during completion included configuring the database connection, defining the entity relationships, and writing comprehensive unit tests. Additionally, integrating the Spring and Hibernate components required careful consideration.

### Which specific prompts did you learn as a good practice to complete the task?

- Using Spring Initializer to set up a Spring Boot project with the necessary dependencies.
- Implementing service and repository classes for each entity.
- Writing unit tests for service and controller classes to ensure code quality and reliability.
- Using MockMvc and Mockito for testing Spring MVC controllers.
- Providing error handling and validation for the RESTful API.
