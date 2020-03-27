package co.edu.icesi.fi.tics.tssc.repositories;

import co.edu.icesi.fi.tics.tssc.model.TsscStory;

public interface StoryRepository {

	
	public void saveStory(TsscStory story);
	public void editStory(TsscStory story);
}
