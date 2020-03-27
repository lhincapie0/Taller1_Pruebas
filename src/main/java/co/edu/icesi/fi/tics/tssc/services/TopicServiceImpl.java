package co.edu.icesi.fi.tics.tssc.services;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.icesi.fi.tics.tssc.exceptions.NotEnoughGroupsException;
import co.edu.icesi.fi.tics.tssc.exceptions.NotEnoughSprintsException;
import co.edu.icesi.fi.tics.tssc.exceptions.NotExistingTopic;
import co.edu.icesi.fi.tics.tssc.exceptions.NullTopicException;
import co.edu.icesi.fi.tics.tssc.model.TsscTopic;
import co.edu.icesi.fi.tics.tssc.repositories.TopicRepository;

public class TopicServiceImpl implements TopicService{
	
	@Autowired
	private TopicRepository topicRepository;

	@Override
	public void saveTopic(TsscTopic topic) throws NullTopicException, NotEnoughGroupsException, NotEnoughSprintsException{
		if(topic != null)
		{
			if(topic.getDefaultGroups()>0)
			{
				if(topic.getDefaultSprints()>0)
				{
					topicRepository.saveTopic(topic);
				}else throw new NotEnoughSprintsException();
			}else throw new NotEnoughGroupsException();
				
		}else throw new NullTopicException();
			
	}

	@Override
	public void editTopic(TsscTopic topic) throws NullTopicException, NotExistingTopic {
		if(topic != null)
		{
			if(topicRepository.getTopic(topic.getId()) != null)
			{
				topicRepository.editTopic(topic);
			}else throw new NotExistingTopic();
		}else throw new NullTopicException();
	}

}
