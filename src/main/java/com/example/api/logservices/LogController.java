package com.example.api.logservices;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.api.model.Log;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.Arrays;
import java.util.List;


/**
 * Handles POST and GET access types
 * @author Kevin
 *
 */
@RestController
public class LogController{

	
	@Autowired
	private LogService logService;
	
	/**
	 * Method that handles POST requests with a JSON payload.
	 * Checks if payload is a valid JSON Object or JSON Array format then saves to the database
	 * @param item JSON Payload
	 * @return
	 */
	@PostMapping(path="/postlogs", consumes="application/json", produces="application/json")
	public ResponseEntity<?> addLog(@RequestBody String item) {

		try {
			
			
			Gson gson = new Gson();
			
			item = item.trim();
			char first= item.charAt(0);
			if(first=='[') {
				Log[] logs = gson.fromJson(item, Log[].class);
				logService.saveAll(Arrays.asList(logs));
			}
			else if(first=='{') {
				Log log = gson.fromJson(item, Log.class);
				logService.saveOne(log);
			}
		}
		catch(Exception e) {
			return new ResponseEntity("Invalid format",HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity("Log Successfully Added",HttpStatus.CREATED);

			
	}
	
	/**
	 * Method that handles GET requests with some optional parameters. Retrieves matching documents from the mongodb database in JSON format
	 * @param userId Corresponds to mongoDB's userId field
	 * @param type	Corresponds to mongoDB's type field
	 * @param time Corresponds to mongoDB's time field in String format.
	 * @return
	 */
	@GetMapping(path="/getlogs")
	@ResponseBody
	public List<Log> getLogs(@RequestParam(required=false) String userId, @RequestParam(required=false) String type, @RequestParam(required=false) String time) {
		
		if(userId!=null || type!=null || time!=null) {
			
			if(userId!=null && type!=null && time!=null)
				return logService.findByUidTypeTime(userId, type, time);
			else if(userId!=null && type!=null)
				return logService.findByUidType(userId, type);
			else if(userId!=null && time!=null)
				return logService.findByUidTime(userId, time);
			else if(time!=null && type!=null)
				return logService.findByTypeTime(type, time);
			else if(userId!=null)
				return logService.findByUserId(userId);
			else if(type!=null)
				return logService.findByActionType(type);
		}
		else {
			System.out.println("User id and type not found, defaulting to find all");
			return logService.findAll();
		}
		return null;
	}
	
}