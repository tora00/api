# Logging API
 A simple api that allows for insertion or retrieval of log data in JSON format using POST and GET requests.
 
 A hosted version is available on https://kevin-naval-api-test.herokuapp.com/

**Usage**
---
**Insert**
 * **URL**
  https://kevin-naval-api-test.herokuapp.com/postlogs
 
 * **Method:**
  POST
   
  * **Request Payload Format**
  
    JSON
   
   * **Success Response:**
   
     * **Code:** 201<br/>
      **Content:** `Log successfully added`
    
   * **Error Response:**
   
     * **Code:** 400
    
       **Content:** `Invalid format`


**Retrieval**
 * **URL**
  https://kevin-naval-api-test.herokuapp.com/getlogs
 
 * **Method:**
  GET
 
 * **URL Parameters**
  **Optional:**
  
   `userId=[string]`
   
   `type=[string]`
   
   `time=[string]`
   
  * **Response Payload Format**
  
    JSON
   
   * **Success Response:**
   
     * **Code:** 200<br/>
       **Content:**
      
        `{"_id":"5e63fcd4418f9e19f368e0bf","userId":"ABC123XYZ","sessionId":"XYZ456ABC","actions":[{"time":"2018-10-18T21:37:28-06:00","type":"CLICK","properties":{"locationX":52,"locationY":11,"viewedId":null,"pageFrom":null,"pageTo":null,"additionalProperties":{}},"additionalProperties":{}},{"time":"2018-10-18T21:37:30-06:00","type":"VIEW","properties":{"locationX":null,"locationY":null,"viewedId":"FDJKLHSLD","pageFrom":null,"pageTo":null,"additionalProperties":{}},"additionalProperties":{}},{"time":"2018-10-18T21:37:30-06:00","type":"NAVIGATE","properties":{"locationX":null,"locationY":null,"viewedId":null,"pageFrom":"communities","pageTo":"inventory","additionalProperties":{}},"additionalProperties":{}}],"additionalProperties":{}}`
    
   * **Sample Call:**<br/>
     `https://kevin-naval-api-test.herokuapp.com/getlogs?userId=ABC123XYZ`
     
 
**Follow Up**
---
 While this application is written for a technical assessment, it can be polished to accommodate scalability by adhering to certain factors. It is import to ensure that the app's codebase is accurately tracked by employing and effectively managing a revision control system and every developer working on the app are working with the same codebase. The API's architecture is also important to how well it can scale. An api built with a lot of unnecessary overheads can cause poor and slow performance. Making sure that the most efficient code is written (or even an external package/module if it's more efficient than manual implementation), will minimize the performance issues that can affect scaling. Of course, no matter how well we write code or manage repositories, one of the biggest limiting factors that can affect an application's scalability is the hardware the application is hosted in. Applications that are hosted in weak, non-specialized hardware may be able to handle light traffic, but no more than that. Powerhouse applications and services such as Google and Amazon see billions of traffic per month, in order to accommodate that much traffic, they house their own powerful hardware, spread across the world, providing a decentralized and efficient method to process traffic. However, for most other companies, this really isn't a feasible option because of the underlying costs. So the best option is to host their applications on platforms that offer cloud computing such as AWS and Heroku. These entities are able to easily provide scalability and computing efficiency, as well as lowering overall costs.
