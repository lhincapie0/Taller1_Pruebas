package co.edu.icesi.fi.tics.tssc.services;


import co.edu.icesi.fi.tics.tssc.exceptions.NotEnoughGroupsException;
import co.edu.icesi.fi.tics.tssc.exceptions.NotEnoughSprintsException;
import co.edu.icesi.fi.tics.tssc.exceptions.NullGameException;
import co.edu.icesi.fi.tics.tssc.model.TsscGame;

public interface GameService {

	public TsscGame saveGame(TsscGame game) throws 
	NotEnoughGroupsException, NotEnoughSprintsException, NullGameException;
	public TsscGame editGame(TsscGame game);

}
