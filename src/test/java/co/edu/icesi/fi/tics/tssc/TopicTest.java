package co.edu.icesi.fi.tics.tssc;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.hibernate.criterion.NullExpression;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.edu.icesi.fi.tics.tssc.exceptions.NotEnoughGroupsException;
import co.edu.icesi.fi.tics.tssc.exceptions.NotEnoughSprintsException;
import co.edu.icesi.fi.tics.tssc.exceptions.NotExistingTopic;
import co.edu.icesi.fi.tics.tssc.exceptions.NullTopicException;
import co.edu.icesi.fi.tics.tssc.model.TsscTopic;
import co.edu.icesi.fi.tics.tssc.repositories.TopicRepository;
import co.edu.icesi.fi.tics.tssc.services.TopicServiceImpl;

public class TopicTest {

	
	@Mock
	private TopicRepository mock;
	
	@InjectMocks
	private TopicServiceImpl topicService;
	private TsscTopic topic;
	
	@BeforeEach
	public void init()
	{
		MockitoAnnotations.initMocks(this);
		topic = new TsscTopic();
		topic.setId(11111);
		topic.setName("Tema 1");
		topic.setGroupPrefix("t1");
		
	}
	
	@Test
	@DisplayName("Null topic")
	public void saveTest1()
	{
		assertThrows(NullTopicException.class, ()-> topicService.saveTopic(null));
		verifyZeroInteractions(mock);

	}
	
	@Test
	@DisplayName("Not enough groups")
	public void saveTest2()
	{
	
		topic.setDefaultSprints(4);
		assertThrows(NotEnoughGroupsException.class, ()-> topicService.saveTopic(topic));
		verifyZeroInteractions(mock);

	}
	
	@Test
	@DisplayName("Not enough sprints")
	public void saveTest3()
	{
	
		topic.setDefaultGroups(4);
		assertThrows(NotEnoughSprintsException.class, ()-> topicService.saveTopic(topic));
		verifyZeroInteractions(mock);
		//verify(mock,times(0)).saveTopic(topic);
	}
	
	@Test
	@DisplayName("Good creation")
	public void saveTest4()
	{
		topic.setDefaultGroups(4);
		topic.setDefaultSprints(4);
		when(mock.saveTopic(topic)).thenReturn(topic);

		try {
			topicService.saveTopic(topic);
			
		} catch (NullTopicException e) {
		} catch (NotEnoughGroupsException e) {
		} catch (NotEnoughSprintsException e) {
		}
		verify(mock, times(1)).saveTopic(topic);
	}
	
	@Test 
	@DisplayName("Not existing topic for editting")
	public void editTest1() {
		assertThrows(NotExistingTopic.class, ()-> topicService.editTopic(topic));
		verify(mock, times(0)).editTopic(topic);
		//The zero interactions doesn´t work here because inside the method the service accesses to the repository to check if there is an existing topic 
		//	verifyZeroInteractions(mock);

	}
	
	
	@Test 
	@DisplayName("Null topic for editting")
	public void editTest2() {
		assertThrows(NullTopicException.class, ()-> topicService.editTopic(null));
		verifyZeroInteractions(mock);
	}
	
	@Test 
	@DisplayName("Good topic for editting")
	public void editTest3() {
		topic.setDefaultSprints(4);
		topic.setDefaultGroups(3);

		try {
			topicService.saveTopic(topic);
			topic.setName("Edited topic");
			topicService.editTopic(topic);
			verify(mock, times(1)).editTopic(topic);

		} catch (NullTopicException |NotEnoughGroupsException | NotEnoughSprintsException | NotExistingTopic e ) {
			
		}
		//when(mock.editTopic(topic)).thenReturn(topic);


		


	}
	
}
