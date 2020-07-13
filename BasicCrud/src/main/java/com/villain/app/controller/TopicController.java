package com.villain.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.villain.app.model.Topic;

//Rest Controller class for crud operations
@RestController
public class TopicController {
	
	//Autowired TopicService Instance here
	@Autowired
	private TopicService topicServ;
	
	//Mapped Get All request
	@RequestMapping(method = RequestMethod.GET,value="/topics")
	public List<Topic> getAll(){
	return topicServ.getAll();
	}
	
	//Mapped Get specific topic request
	@RequestMapping(method = RequestMethod.GET, value = "/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicServ.getTopic(id);
	}
	
	//Mapped add topic request
	@RequestMapping(method = RequestMethod.POST, value = "/topics/")
	public String addTopic(@RequestBody Topic topic) {
		return topicServ.addTopic(topic);
	}
	
	//Mapped update topic request
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public String updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		return topicServ.update(id, topic);
	}
	
	//Mapped delete topic request
	@RequestMapping(method = RequestMethod.DELETE, value ="/topics/{id}")
	public String deleteTopic(@PathVariable String id) {
		return topicServ.delete(id);
	}

}
