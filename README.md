# skyrim-alchemy-calculator-outer-api
The Skyrim Alchemy Calculator is a full-stack application with an Angular front-end and Spring backend, designed to let users input their collected ingredients to find and prioritize potion recipes for maximizing gold or exploration, featuring a comprehensive ingredient database and a user-friendly interface for all devices.

1.	Project Planning and Requirements Gathering
a.	Define Objectives: Clearly articulate the goals of your application.
i.	The primary goal of the Skyrim Alchemy Calculator application is to provide a user-friendly tool that helps players of Skyrim efficiently utilize their collected ingredients to craft potions, with a focus on maximizing economic returns (gold) or expanding their alchemical knowledge (discovery of recipes). This tool aims to enhance the gaming experience by providing a comprehensive, easy-to-navigate database and calculator for potion crafting.
b.	Gather requirements: Compile detailed function and non-functional requirements from stakeholders.
i.	Ingredient Input: Users can input a list of ingredients they currently possess.
ii.	Potion Calculation: The app calculates all possible potions that can be crafted from the given ingredients.
iii.	Optimization Options: Users can select to optimize potion crafting for either maximum gold value or discovery of new potion recipes.
iv.	Database Access: Access to a detailed database of all Skyrim ingredients, including effects and possible potion combinations.
v.	Responsive Design: The application should be accessible and fully functional on both desktop and mobile platforms.

Non-Functional Requirements:

1.	Performance: The application should load and respond to user inputs quickly, with potion calculations completed within seconds.
2.	Usability: The interface should be intuitive, requiring minimal instructions for new users to navigate and use the application effectively.
3.	Scalability: The backend should be capable of handling an increase in user numbers without significant degradation in performance.
4.	Security: User data, if collected, should be stored securely, and the application should be protected against common security threats.
c.	Research and Tool section: Choose additional tools, databases, third-party services, and hosting platforms.
Frontend:

Framework: Angular is already selected for its robust ecosystem and comprehensive features for building dynamic single-page applications.
Backend:

Framework: Spring (specifically Spring Boot) for its ease of use, scalability, and support for RESTful services, which will be essential for handling database operations and user requests.
Database:

Type: A relational database like PostgreSQL or MySQL, for storing ingredient data and potion recipes due to their structured nature and the relationships between data entities.
Hosting/Deployment:

Platform: Consider using AWS, Heroku, or DigitalOcean. AWS offers extensive services and scalability. Heroku provides simplicity and ease of use for deployment. DigitalOcean offers straightforward pricing and is developer-friendly.
Third-Party Services:

Authentication (if needed): Implement OAuth or JWT for secure user authentication. Firebase Authentication is also a good option for its simplicity and integration capabilities.
APIs: If real-time data or additional game information is needed, look into existing APIs that provide game data or community-driven content.
Development Tools:

Version Control: Git, with GitHub or GitLab for repository hosting, to track changes and collaborate on code.
Project Management: Trello, Jira, or Asana for task management and sprint planning.
Testing: Use Jest for front-end testing and groovy  for backend testing to ensure code reliability and bug-free releases.
