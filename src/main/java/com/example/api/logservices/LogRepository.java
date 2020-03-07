package com.example.api.logservices;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.api.model.Log;

/**
 * Simple interface that adds custom methods based on get parameters for db access.
 * 
 * @author Kevin
 *
 */
@Repository
public interface LogRepository extends MongoRepository<Log,String>{
	
	@Query("{'userId' : ?0}")
	List<Log> findByUserId(String userId);
	
	@Query("{'actions.type' : ?0}")
	List<Log> findByActionType(String type);
	
	@Query("{'actions.time' : ?0}")
	List<Log> findByActionTime(String time);
	
	@Query("{'userId' : ?0, 'actions.type' : ?1}")
	List<Log> findByUidType(String userId, String type);
	
	@Query("{'userId' : ?0, 'actions.time' : ?1}")
	List<Log> findByUidTime(String userId, String time);
	
	@Query("{'actions.type' : ?0, 'actions.time' : ?1}")
	List<Log> findByTypeTime(String type, String time);
	
	@Query("{'userId' : ?0, 'actions.type' : ?1, 'actions.time' : ?2}")
	List<Log> findByUidTypeTime(String userId, String type, String time);
}
