# skyrim-alchemy-calculator-outer-api
The Skyrim Alchemy Calculator is a simple full-stack application with an Angular front-end and Spring backend, designed to let users input their collected ingredients to find and prioritize potion recipes for maximizing gold or exploration, featuring a comprehensive ingredient database and a user-friendly interface for all devices.
# Skyrim Alchemy Calculator

## Project Planning and Requirements Gathering

### Define Objectives
Clearly articulate the goals of your application.

#### Objectives
The primary goal of the Skyrim Alchemy Calculator application is to provide a user-friendly tool that helps players of Skyrim efficiently utilize their collected ingredients to craft potions, with a focus on maximizing economic returns (gold) or expanding their alchemical knowledge (discovery of recipes). This tool aims to enhance the gaming experience by providing a comprehensive, easy-to-navigate database and calculator for potion crafting.

### Gather Requirements
Compile detailed function and non-functional requirements from stakeholders.

#### Functional Requirements
- **Ingredient Input**: Users can input a list of ingredients they currently possess.
- **Potion Calculation**: The app calculates all possible potions that can be crafted from the given ingredients.
- **Optimization Options**: Users can select to optimize potion crafting for either maximum gold value or discovery of new potion recipes.
- **Database Access**: Access to a detailed database of all Skyrim ingredients, including effects and possible potion combinations.
- **Responsive Design**: The application should be accessible and fully functional on both desktop and mobile platforms.

#### Non-Functional Requirements
1. **Performance**: The application should load and respond to user inputs quickly, with potion calculations completed within seconds.
2. **Usability**: The interface should be intuitive, requiring minimal instructions for new users to navigate and use the application effectively.
3. **Scalability**: The backend should be capable of handling an increase in user numbers without significant degradation in performance.

### Research and Tool Selection
Choose additional tools, databases, third-party services, and hosting platforms.

#### Frontend
- **Framework**: Angular is selected for its robust ecosystem and comprehensive features for building dynamic single-page applications.

#### Backend
- **Framework**: Spring (specifically Spring Boot) for its ease of use, scalability, and support for RESTful services, which will be essential for handling database operations and user requests.

#### Database
- **Type**: A relational database like PostgreSQL or MySQL, for storing ingredient data and potion recipes due to their structured nature and the relationships between data entities.

#### Hosting/Deployment
- **Platform**: Consider using AWS, Jenkins, or Docker.
  - **AWS**: Offers extensive services and scalability.
  - **Jenkins**: Provides powerful automation for building, testing, and deploying code.
  - **Docker**: Simplifies application deployment by using containerization, ensuring consistency across different environments.
  - **APIs**: If real-time data or additional game information is needed, look into existing APIs that provide game data or community-driven content.

### Overall System Architecture with DevOps

| **Component**             | **Description**                                                                                       |
|---------------------------|-------------------------------------------------------------------------------------------------------|
| Frontend (Angular)        | Develop the Angular application.                                                                     |
|                           | Containerize the frontend application using Docker.                                                  |
| Backend (Spring Boot)     | Develop the Spring Boot application.                                                                 |
|                           | Containerize the backend application using Docker.                                                    |
| Database (PostgreSQL)     | Use PostgreSQL for data storage.                                                                     |
|                           | Optionally, run PostgreSQL in a Docker container for consistency across environments.                |
| Continuous Integration/Continuous Deployment (CI/CD) |                                                                                              |
| Jenkins                   | Automate the build, test, and deployment process.                                                     |
|                           | Trigger builds on code commits.                                                                       |
|                           | Build Docker images for both the frontend and backend.                                                |
|                           | Push Docker images to a Docker registry (Docker Hub, AWS ECR, etc.).                                  |
|                           | Deploy the application to AWS.                                                                       |
| Containerization          |                                                                                                       |
| Docker                    | Use Docker to containerize the frontend, backend, and database (optional).                             |
|                           | Define Dockerfiles for the frontend and backend applications.                                          |
|                           | Use Docker Compose for local development and testing.                                                  |
| Hosting and Deployment    |                                                                                                       |
| AWS                       | Use AWS services such as EC2, ECS, or EKS to run your Docker containers.                               |
|                           | Store application data in AWS RDS (PostgreSQL).                                                        |
|                           | Use AWS S3 for storing static assets if needed.                                                        |
|                           | Use AWS CloudWatch for logging and monitoring.                                                         |


#### Development Tools
- **Version Control**: Git, with GitHub or GitLab for repository hosting, to track changes and collaborate on code.
- **Testing**: Use Jest for front-end testing and Groovy for backend testing to ensure code reliability and bug-free releases.

