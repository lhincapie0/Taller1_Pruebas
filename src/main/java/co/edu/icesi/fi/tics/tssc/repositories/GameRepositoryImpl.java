package co.edu.icesi.fi.tics.tssc.repositories;

import java.util.HashMap;
import java.util.Map;

import co.edu.icesi.fi.tics.tssc.model.TsscGame;

public class GameRepositoryImpl implements GameRepository {

	private Map<Long, TsscGame> games;	
	
	public GameRepositoryImpl() {
		games = new HashMap<Long, TsscGame>();
	}

	
	
	@Override
	public void saveGame(TsscGame game) {
		
		games.put(game.getId(), game);
	

	}

	@Override
	public void editGame(TsscGame game) {
		TsscGame existingGame = games.get(game.getId());
		games.replace(game.getId(), game, existingGame);
		
	}



	@Override
	public TsscGame getGame(Long id) {
		return games.get(id);
	}

}
