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
   
