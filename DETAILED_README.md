<h1>Spring Boot Security and Final Enhancements</h1>
    <h2>Project Overview</h2>
        <body>
            This assignment is the final extension of Homeworks 5, 6, and 7.
            <br></br>
            To briefly explain what this project is, it is simply a personalized task board for campus assignments and activities.
            Think of this as a glorified to-do list that can be designed into a web. This project is
            merely the backend implementation of the website, and incorporates incredibly basic concepts
            of backend development with Spring Boot.
            <br></br>
            This is the first ever time I am  working with a framework, and now I can see how Spring Boot
            is really useful for building RESTful APIs. This assignment in particular is the most challenging,
            as I have absolutely no clue how security filters work before starting this assignment. One incredibly
            important takeaway is that CORS and CSRF are two distinct things when implementing security in a backend framework. 
            CSRF is disabled as the API is mainly a RESTful API expecting to take in JWT tokens. <b>Do note that security
            implementations as of now are incredibly basic, and do not have protections against XSS.</b> The CORS configuration
            as of now functions such that the React frontend in the future can communicate directly with the backend without
            being flagged: it can easily get and read data.
        </body>
    <h2>Starting the Application</h2>
        <body>
            When I pushed the README.md file into my HW6 project, I completely overlooked how there
            were no instructions on starting the application.
            <br></br>
            Thankfully, starting it is not a hefty task and is really easy. Make a new folder on your computer
            and run the following commands on your terminal (after cd'ing into it). 

    git clone https://github.com/alia0320/CISC3130-HW8.git

This copies all the files of this repository to the folder. Then run the next command below. Make sure you have
Apache Maven installed before doing this!

    mvn.cmd spring-boot:run

</body>
    <h2>Endpoints Documentation</h2>
        <h3>HTTP Requests</h3>
            <body> 
                 <ul>
                     <li><b>GET: </b> There are two methods inside the controller that determine what type of JSON body the API will return to the user. If you were to send a GET request to http://localhost:8080/api/tasks,
                     you would get whole list of tasks you created with the API. If there is nothing inside the list, it will still return a 200 OK status code with an empty list. If you were to send a GET request to 
                     http://localhost:8080/api/tasks/1, you would either get a 200 OK if you created a task with ID 1 or a 404 not found if there exists no tasks with that ID.</li>
                        <br></br>
                    <li><b>POST: </b> There exists one method inside the controller that deals with POST requests. Whatever the user sends needs to be checked, which the method does with the @Valid annotation. It will look at
                        field annotations in Task.java and check whether the user is entering the right amount of characters for certain data fields. Anything that Task.java does not have will be automatically dealt with by Spring (speaking
                        of the invalid syntax JSON body). It returns two status codes: 201 CREATED if a task passes validation or 400 BAD REQUEST if it fails validation. <br></br>
                        </li>
                    <li><b>PUT: </b> To update a task in the list, you must send a PUT request to http://localhost:8080/api/tasks/{id}. The "id" is in curly braces since the API will look for the task by the ID, so 
                         it is by the user's choice to decide which task they want to update. There are three types of HTTP status codes that can be generated from this request. One is 200 OK: the case that a user updates an existing
                        task with valid JSON body input. The other is 400 BAD REQUEST, which is triggered when the user is able to locate an existing task, but their updates are invalid due to the field annotations in Task.java or a 
                        poor JSON format. And the last is 404 not found, when the user tries to update a task with an ID that is not in the list.</li>
                        <br></br>
                    <li><b>DELETE: </b> This request works by having it sent to http://localhost:8080/api/tasks/{id}. It uses a @PathVariable annotation, meaning it works the same way how a GET request works if you were to specify
                        an ID. It can either send the user a 204 NO CONTENT message when an existing task is successfully deleted, or a 404 NOT FOUND if a task that the user is trying to delete doesn't exist in the first place.</li>
                </ul>
            You can also find more useful information about the endpoints via Swagger UI. While running the backend,
            you can visit:

http://localhost:8080/swagger-ui.html
</body>
        <h3>Database Query Endpoints</h3>
            <body>
                <ul>
                    <li><b>GET completed = true (/api/tasks/completed): </b> returns JSON body containing all tasks
                    where the completed data field is set to equal true. If there are no tasks, then
                    empty JSON body is returned.</li>
                    <br></br>
                    <li><b>GET completed = false (/api/tasks/incomplete): </b> returns JSON body containing all tasks
                    where the completed data field is set to equal false. If there are no tasks, then
                    empty JSON body is returned.</li>
                    <br></br>
                    <li><b>GET priority = HIGH (/api/tasks/priority/HIGH): </b> returns JSON body containing all tasks
                    where the priority field data is set to HIGH. If there are no tasks, then
                    empty JSON body is returned.</li>
                    <br></br>
                    <li><b>GET title LIKE keyword or description LIKE keyword (/api/tasks/search?keyword=): </b> returns JSON body containing all tasks
                    where the title or description has the user specified keyword. If there are no tasks, then
                    empty JSON body is returned.</li>
                    <br></br>
                    <li><b>GET paginated (/api/tasks/paginated?page=0&size=5): </b> returns JSON body containing first 5 tasks
                    of the page. If there are no tasks, then an empty JSON body is returned. Note that the URL does not include
                    a sorting priority, which the user can specify themselves.</li>
                    <br></br>
                </ul>
            </body>
        
