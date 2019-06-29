package com.springboot.orm.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	List<Topics> topics = new ArrayList(
			Arrays.asList(new Topics("spring", "springframework", "spring framework description"),
					new Topics("java", "java 11", "whats new in java"),
					new Topics("javascript", "Dom and more", "js description")

			));

	public List<Topics> getAll() {
		return topics;
	}

	// get one topic
	public Topics getOne(String id) {

		return topics.stream().filter(f -> f.getId().equals(id)).findFirst().get();
	}

	public void updateTopic(String id, Topics t) {
		Topics topic = topics.stream().filter(f -> f.getId().equals(id)).findFirst().get();

		topic.setName(t.getName());
		topic.setDescription(t.getDescription());

	}

	public void addTopic(Topics t) {
		topics.add(t);
	}

	public void deleteTopic(String id) {
		Topics topic = topics.stream().filter(f -> f.getId().equals(id)).findFirst().get();
		topics.remove(topic);
	}

}
