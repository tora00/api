package com.example.api.model;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Properties {

@Field("locationX")
private Integer locationX;

@Field("locationY")
private Integer locationY;

@Field("viewedId")
private String viewedId;

@Field("pageFrom")
private String pageFrom;

@Field("pageTo")
private String pageTo;

private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public Properties() {
}

/**
*
* @param locationY
* @param viewedId
* @param locationX
* @param pageTo
* @param pageFrom
*/
public Properties(Integer locationX, Integer locationY, String viewedId, String pageFrom, String pageTo) {
super();
this.locationX = locationX;
this.locationY = locationY;
this.viewedId = viewedId;
this.pageFrom = pageFrom;
this.pageTo = pageTo;
}

public Integer getLocationX() {
return locationX;
}

public void setLocationX(Integer locationX) {
this.locationX = locationX;
}

public Integer getLocationY() {
return locationY;
}

public void setLocationY(Integer locationY) {
this.locationY = locationY;
}

public String getViewedId() {
return viewedId;
}

public void setViewedId(String viewedId) {
this.viewedId = viewedId;
}

public String getPageFrom() {
return pageFrom;
}

public void setPageFrom(String pageFrom) {
this.pageFrom = pageFrom;
}

public String getPageTo() {
return pageTo;
}

public void setPageTo(String pageTo) {
this.pageTo = pageTo;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

@Override
public String toString() {
return new ToStringBuilder(this).append("locationX", locationX).append("locationY", locationY).append("viewedId", viewedId).append("pageFrom", pageFrom).append("pageTo", pageTo).append("additionalProperties", additionalProperties).toString();
}

}