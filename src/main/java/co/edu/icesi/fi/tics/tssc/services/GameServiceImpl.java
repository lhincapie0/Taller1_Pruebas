package co.edu.icesi.fi.tics.tssc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.fi.tics.tssc.exceptions.NotEnoughGroupsException;
import co.edu.icesi.fi.tics.tssc.exceptions.NotEnoughSprintsException;
import co.edu.icesi.fi.tics.tssc.exceptions.NotExistingGame;
import co.edu.icesi.fi.tics.tssc.exceptions.NotExistingTopic;
import co.edu.icesi.fi.tics.tssc.exceptions.NullGameException;
import co.edu.icesi.fi.tics.tssc.model.TsscGame;
import co.edu.icesi.fi.tics.tssc.model.TsscTopic;
import co.edu.icesi.fi.tics.tssc.repositories.GameRepository;
import co.edu.icesi.fi.tics.tssc.repositories.TopicRepository;

@Service
public class GameServiceImpl implements GameService{

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Override
	public TsscGame saveGame(TsscGame game, TsscTopic topic) throws NotEnoughGroupsException, 
	NotEnoughSprintsException, NullGameException, NotExistingTopic{
		if(game!=null)
		{
			if(game.getNGroups()>0)
			{
				if(game.getNSprints()>0)
				{
					if(topic== null)
					{
						gameRepository.saveGame(game);
						return game;
					}else
					{
						if(topicRepository.getTopic(topic.getId()) != null)
						{
							gameRepository.saveGame(game);
							game.setTsscTopic(topic);
							return game;	
						}else throw new NotExistingTopic();
					}
				}else throw new NotEnoughSprintsException();
			}else throw new NotEnoughGroupsException();
		}else throw new NullGameException();
	}

	@Override
	public TsscGame editGame(TsscGame game) throws NotExistingGame, NullGameException, NotEnoughGroupsException, NotEnoughSprintsException {

		if(game != null)
		{
			if(gameRepository.getGame(game.getId()) != null)
			{
				if(game.getNGroups()>0)
				{
					if(game.getNSprints()>0)
					{
						 gameRepository.editGame(game);
						 return game;
					}else throw new NotEnoughSprintsException();
				}else throw new NotEnoughGroupsException();
				
			}else throw new NotExistingGame();
			
		}else throw new NullGameException();
		
		
	}

}
