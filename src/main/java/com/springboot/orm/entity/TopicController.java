package com.springboot.orm.entity;

import java.util.Arrays;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TopicController {

	@Autowired
	private TopicService topicservice;

	@RequestMapping("/topics")
	public List<Topics> getAll() {

		return topicservice.getAll();
	}

	// how to return only the course requested by id

	@RequestMapping("/topics/{id}")
	public Topics getCoursebyId(@PathVariable String id) {

		return topicservice.getOne(id);
	}

	// how to add course into existing data

	@RequestMapping(value = "/topics/add", method = RequestMethod.POST)
	public void addCoursebyId(@RequestBody Topics topic) {

		topicservice.addTopic(topic);

		System.out.println("added your topic with post request" + topic);
	}

	// how to user put and delelte

	@RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
	public void putupdateCoursebyId(@RequestBody Topics topic, @PathVariable String id) {

		topicservice.updateTopic(id, topic);

		System.out.println("updated topic with put request" + topic);
	}
	
	@RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
	public void deleteCorsebyId(@PathVariable String id) {
			topicservice.deleteTopic(id);
	}

}
