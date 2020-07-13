package com.villain.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.villain.app.model.Topic;

// Service class of crud operations
@Service
public class TopicService {
	
	//Static Database (Fake database)
	private List<Topic> topics = new ArrayList<>(
			Arrays.asList(
					new Topic("Java", "Advance Java", "Java Course"),
					new Topic("Python", "Advance Python", "Python Course"),
					new Topic("NodeJS", "Advance NodeJS", "NodeJS Course"),
					new Topic("AngularJS", "Advance AngularJS", "AngularJS Course")
					));
	
	//Get All data
	public List<Topic> getAll(){
		return topics;
	}
	
	//Get specific date from list according to id of topic
	public Topic getTopic(String id) {
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		
	}

	//Add new Topic in list
	public String addTopic(Topic topic) {
		topics.add(topic);
		return "row is Added";
	}
	
	//Update specific topic in list according to id of topic
	public String update(String id, Topic topic) {
		String msg="";
		for(int i=0; i<topics.size(); i++) {
			if(topics.get(i).getId().equals(id)) {
				topics.set(i, topic);
				msg="Row is updated";
			}
		}
		return msg;
	}
	
	//Delete specific topic from list according to id of topic
	public String delete(String id) {
		
		topics.removeIf(t->t.getId().equals(id));
		return "row is deleted";
	}

}
