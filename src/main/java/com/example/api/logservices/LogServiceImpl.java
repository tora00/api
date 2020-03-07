package com.example.api.logservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.model.Log;

@Service
public class LogServiceImpl implements LogService{

	@Autowired
	private LogRepository logRepository;
	
	@Override
	public List<Log> findAll() {
		return logRepository.findAll();
	}
	
	@Override
	public void deleteAllLogs() {
		logRepository.deleteAll();
		
	}

	@Override
	public void deleteLogByUserId(String userId) {
		logRepository.deleteById(userId);
		
	}

	@Override
	public void saveOne(Log log) {
		logRepository.save(log);
		
	}

	@Override
	public void saveAll(List<Log> logs) {
		logRepository.saveAll(logs);
		
	}

	@Override
	public List<Log> findByUserId(String userId) {
		return logRepository.findByUserId(userId);
	}

	@Override
	public List<Log> findByActionType(String type) {
		return logRepository.findByActionType(type);
	}
	
	@Override
	public List<Log> findByActionTime(String time) {
		return logRepository.findByActionTime(time);
	}

	@Override
	public List<Log> findByUidType(String userId, String type) {
		return logRepository.findByUidType(userId, type);
	}
	
	@Override
	public List<Log> findByUidTime(String userId, String time) {
		return logRepository.findByUidTime(userId, time);
	}
	
	@Override
	public List<Log> findByTypeTime(String type, String time) {
		return logRepository.findByTypeTime(type, time);
	}
	
	@Override
	public List<Log> findByUidTypeTime(String userId, String type, String time) {
		return logRepository.findByUidTypeTime(userId, type, time);
	}


}
