package co.edu.icesi.fi.tics.tssc.repositories;

import co.edu.icesi.fi.tics.tssc.model.TsscGame;

public interface GameRepository {
	
	public void saveGame(TsscGame game);
	public void editGame(TsscGame game);
	public TsscGame getGame(Long id);

}
