package co.edu.icesi.fi.tics.tssc;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.edu.icesi.fi.tics.tssc.model.TsscGame;
import co.edu.icesi.fi.tics.tssc.model.TsscTopic;
import co.edu.icesi.fi.tics.tssc.repositories.GameRepository;
import co.edu.icesi.fi.tics.tssc.repositories.GameRepositoryImpl;
import co.edu.icesi.fi.tics.tssc.repositories.TopicRepository;
import co.edu.icesi.fi.tics.tssc.services.TopicServiceImpl;

public class GameTest {
	

	@Mock
	private GameRepository mock;
	
	@InjectMocks
	private GameRepositoryImpl gameService;
	private TsscGame game;
	
	@BeforeEach
	public void init()
	{
		MockitoAnnotations.initMocks(this);
		game = new TsscGame();
		game.setAdminPassword("1235");
		game.setGuestPassword("guest");
		game.setNGroups(3);
		game.setNSprints(6);
		
	}

}
