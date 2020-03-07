package com.example.api.model;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Action {

@Field("time")
private String time;

@Field("type")
private String type;

@Field("properties")
private Properties properties;

private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public Action() {
}

/**
*
* @param time
* @param type
* @param properties
*/
public Action(String time, String type, Properties properties) {
super();
this.time = time;
this.type = type;
this.properties = properties;
}

public String getTime() {
return time;
}

public void setTime(String time) {
this.time = time;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public Properties getProperties() {
return properties;
}

public void setProperties(Properties properties) {
this.properties = properties;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

@Override
public String toString() {
return new ToStringBuilder(this).append("time", time).append("type", type).append("properties", properties).append("additionalProperties", additionalProperties).toString();
}

}