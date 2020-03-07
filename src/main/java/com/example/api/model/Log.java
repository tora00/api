package com.example.api.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "Log")
public class Log {
	
@Id
private ObjectId _id;

@Field("userId")
private String userId;

@Field("sessionId")
private String sessionId;

@Field("actions")
private List<Action> actions = null;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public Log() {
}

/**
*
* @param sessionId
* @param userId
* @param actions
*/
public Log(ObjectId _id, String userId, String sessionId, List<Action> actions) {
super();
this._id = _id;
this.userId = userId;
this.sessionId = sessionId;
this.actions = actions;
}

public String get_id() {
    return _id.toHexString();
}

public void set_id(ObjectId _id) {
    this._id = _id;
}

public String getUserId() {
return userId;
}

public void setUserId(String userId) {
this.userId = userId;
}

public String getSessionId() {
return sessionId;
}

public void setSessionId(String sessionId) {
this.sessionId = sessionId;
}

public List<Action> getActions() {
return actions;
}

public void setActions(List<Action> actions) {
this.actions = actions;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

@Override
public String toString() {
return new ToStringBuilder(this).append("userId", userId).append("sessionId", sessionId).append("actions", actions).append("additionalProperties", additionalProperties).toString();

}

}