package co.edu.icesi.fi.tics.tssc.services;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.icesi.fi.tics.tssc.exceptions.NotEnoughGroupsException;
import co.edu.icesi.fi.tics.tssc.exceptions.NotEnoughSprintsException;
import co.edu.icesi.fi.tics.tssc.exceptions.NullGameException;
import co.edu.icesi.fi.tics.tssc.model.TsscGame;
import co.edu.icesi.fi.tics.tssc.repositories.GameRepository;

public class GameServiceImpl implements GameService{

	@Autowired
	private GameRepository gameRepository;
	
	@Override
	public TsscGame saveGame(TsscGame game) throws NotEnoughGroupsException, 
	NotEnoughSprintsException, NullGameException{
	
		if(game != null)
		{
			if(game.getNGroups()>0)
			{
				if(game.getNSprints()>0) {
					
					gameRepository.saveGame(game);
					
				}else throw new NotEnoughSprintsException();
			
			}else throw new NotEnoughGroupsException();
		
		}else throw new NullGameException();
		
		return game;
	}

	@Override
	public TsscGame editGame(TsscGame game) {
		// TODO Auto-generated method stub
		return null;
	}

}
