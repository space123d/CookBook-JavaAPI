<h1><a id="CookBookJavaAPI_0"></a>CookBook-JavaAPI</h1>
<p>This API is built using spring boot java  RESTful services.<br>
This API is then consumed by the Mendix <a href="http://Application.It">Application.It</a> allows users to search for recipes and provide the recipe details such as ingredients,directions,cooking technique etc. You can even rate the recipes.</p>
<h1><a id="How_to_Run_3"></a>How to Run:</h1>
<p>•   Download the zip or clone the Git repository.<br>
•   Unzip the zip file (if you downloaded one)<br>
•   Open Command Prompt and Change directory (cd) to folder containing pom.xml<br>
•   Open Eclipse<br>
•   File -&gt; Import -&gt; Existing Maven Project -&gt; Navigate to the folder where you unzipped the zip<br>
•   Build the Project by right clicking project -&gt; RunAs -&gt; Maven Build(mvn clean package)<br>
•   After the build choose the Spring Boot Application file (search for @SpringBootApplication or RestfulWebServicesApplication.java)<br>
•   Right Click on the file and Run as Java Application.</p>
<h1><a id="Tools_required_12"></a>Tools required:</h1>
<p>•   Eclipse/Intellij IDE<br>
•   Postman/Fiddler<br>
•   JDK 1.8 or higher<br>
•   Maven 3.2+</p>
<h1><a id="REST_APIs_Endpoints_URL_17"></a>REST APIs Endpoints URL</h1>
<p>To get all available recipes: GET: <a href="http://localhost:8080/rest/get/recipes">http://localhost:8080/rest/get/recipes</a><br>
To get all available categories GET : <a href="http://localhost:8080/rest/get/recipes/categories">http://localhost:8080/rest/get/recipes/categories</a><br>
To get all available recipe names GET : <a href="http://localhost:8080/rest/get/recipes/names">http://localhost:8080/rest/get/recipes/names</a><br>
To get recipe searching by category GET: <a href="http://localhost:8080/rest/get/recipe/%7Bcategory%7D">http://localhost:8080/rest/get/recipe/{category}</a><br>
To get recipe searching by name GET : <a href="http://localhost:8080/rest/get/recipe/search/%7Btitle%7D">http://localhost:8080/rest/get/recipe/search/{title}</a><br>
To create new recipe POST : : <a href="http://localhost:8080/rest/post/recipes">http://localhost:8080/rest/post/recipes</a><br>
To modify/update recipe by name PUT: <a href="http://localhost:8080/rest/put/recipe/%7Btitle%7D">http://localhost:8080/rest/put/recipe/{title}</a><br>
To delete recipe by name DELETE: <a href="http://localhost:8080/rest/delete/recipe/%7Btitle%7D">http://localhost:8080/rest/delete/recipe/{title}</a><br>
Http Status for Successful GET: 200<br>
Http Status for Failure GET: 400/401<br>
Http Status for Created POST : 201<br>
Http Status for Delete DELETE : 200</p>
<h1><a id="To_view_your_H2_inmemory_datbase_31"></a>To view your H2 in-memory datbase</h1>
<p>The ‘test’ profile runs on H2 in-memory database. To view and query the database you can browse to <a href="http://localhost:8080/h2-console">http://localhost:8080/h2-console</a>.<br>
Default username is ‘sa’ with a blank password.<br>
Make sure JDBC Url:  jdbc:h2:mem:testdb</p>
<h1><a id="To_view_Swagger_2_API_docs_36"></a>To view Swagger 2 API docs</h1>
<p>Run the server and browse to localhost:8080/swagger-ui.html</p>
<h1><a id="To_run_the_Unit_Tests_40"></a>To run the Unit Tests</h1>
<p>Go to src/test/java/unittest/unittestController<br>
Right click on RecipeControllertest.java and RunAs Junit.<br>
Right click on Repositorybasictest.java and RunAs Junit</p>
<p>To run the basic Integration Tests<br>
Go to src/test/java/integrationtest<br>
Right click on RestfulWebServicesApplicationTests.java and RunAs Junit</p>
<h1><a id="Initial_Data_49"></a>Initial Data</h1>
<p>Initial Data is loaded from the path src/main/resources/json/Initialdata.json</p>
<h1><a id="Health_of_the_API_51"></a>Health of the API</h1>
<p>To view the health of the API goto <a href="http://localhost:8080">http://localhost:8080</a> (HAL Browser) and search for /actuator in the Explorer and click the link of ‘health’ available in the links section.</p>
