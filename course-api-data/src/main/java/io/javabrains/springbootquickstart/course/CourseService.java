package io.javabrains.springbootquickstart.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository topicRepository;
	
	private List<Course> topics=new ArrayList<>(Arrays.asList(
			new Course("springData", "Spring Framework ", "Spring Framework Description"),
			new Course("java", "Core Java", "Core Java Description"),
			new Course("javasctipt", "JavaSctipt", "Spring Framework Description")
			));
	
	public List<Course> getAllTopics(){
		//return topics;
		List<Course> topics=new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);//Java 8 Lamda Basic
		return topics;
	}
	public Course getTopic(String id) {
			return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		}
	
	public void addTopic(Course topic) {
		// TODO Auto-generated method stub
		//topics.add(topic);
		topicRepository.save(topic);
	}
	public void updateTopic(String id, Course topic) {
		// TODO Auto-generated method stub
		for (int i = 0; i < topics.size(); i++) {
			Course t=topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}
	public void deleteTopic(String id) {
		topics.removeIf(t->t.getId().equals(id));
	}
}
