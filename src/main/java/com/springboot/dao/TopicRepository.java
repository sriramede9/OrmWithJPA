package com.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.orm.entity.Topics;

public interface TopicRepository extends CrudRepository<Topics, String> {

	@Override
	default <S extends Topics> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Topics findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Iterable<Topics> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	
}
