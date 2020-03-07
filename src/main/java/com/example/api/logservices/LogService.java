package com.example.api.logservices;

import com.example.api.model.*;

import java.util.List;

public interface LogService {

	List<Log> findAll();
	
	List<Log> findByUserId(String userId);
	List<Log> findByActionType(String type);
	List<Log> findByActionTime(String time);
	List<Log> findByUidType(String userId, String type);
	List<Log> findByUidTime(String userId, String time);
	List<Log> findByTypeTime(String type, String time);
	List<Log> findByUidTypeTime(String userId, String type, String time);
	
	void deleteAllLogs();
	void deleteLogByUserId(String userId);
	void saveOne(Log log);
	void saveAll(List<Log> logs);
	
}
