package com.springboot.orm.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	List<Topics> topics = new ArrayList(
			Arrays.asList(new Topics("spring", "springframework", "spring framework description"),
					new Topics("java", "java 11", "whats new in java"),
					new Topics("javascript", "Dom and more", "js description")

			));

	public List<Topics> getAll() {
		Iterator i = topicRepository.findAll().iterator();

		List<Topics> topicslist = new ArrayList();
		;

		while (i.hasNext()) {
			topicslist.add((Topics) i.next());
		}

		return topicslist;
	}

	// get one topic
	public Topics getOne(String id) {

		Topics findOne = null;
		if (topicRepository.exists(id)) {
			findOne = topicRepository.findOne(id);
		}

		return findOne;
	}

	public void updateTopic(String id, Topics t) {
		Topics findOne = null;

		Topics topic = topics.stream().filter(f -> f.getId().equals(id)).findFirst().get();

		if (topicRepository.exists(id)) {

			findOne = topicRepository.findOne(id);
		}
		;

		findOne.setName(t.getName());
		findOne.setDescription(t.getDescription());

		topicRepository.save(findOne);
	}

	public void addTopic(Topics t) {

		topicRepository.save(t);

		// topics.add(t);
	}

	public void deleteTopic(String id) {
		Topics topic = topics.stream().filter(f -> f.getId().equals(id)).findFirst().get();
		topics.remove(topic);

		if (topicRepository.exists(id)) {

			topicRepository.delete(id);
		}

	}

}
