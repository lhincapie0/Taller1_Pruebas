package co.edu.icesi.fi.tics.tssc.services;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.icesi.fi.tics.tssc.model.TsscStory;
import co.edu.icesi.fi.tics.tssc.repositories.GameRepository;
import co.edu.icesi.fi.tics.tssc.repositories.StoryRepository;

public class StoryServiceImpl implements StoryService{
	
	@Autowired
	private StoryRepository storyRepository;
	@Autowired
	private GameRepository gameRepository;

	@Override
	public TsscStory saveStory(TsscStory story) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TsscStory editStory(TsscStory story) {
		// TODO Auto-generated method stub
		return null;
	}

}
