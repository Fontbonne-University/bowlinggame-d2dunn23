package BowlingGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BowlingTest {
	
	private Game g;

	@Before
	public void setUp() throws Exception {
		
		g = new Game();

	}
	
	private void rollStrike() {
		g.roll(10);
	}


	private void rollMany(int j, int pins) {

		for(int i = 0; i< j; i++) {
			g.roll(pins);
		}

	}

	
	@Test
	public void canRoll() {
		g = new Game();
		g.roll(0);
	}
	
	@Test
	public void gutterGame() {

		rollMany(20, 0)	;	
		assertEquals(0, g.score());
	}
	
	@Test
	public void allones() {
		rollMany(20, 1);
		assertEquals(20, g.score());
			
	}
	
	
	@Test
	public void oneSpare() {
		g.roll(5);
		g.roll(5); //spare
		g.roll(3);
		rollMany(17,0);
		assertEquals(16, g.score());
	}
	
	@Test
	public void oneStrike() {
		rollStrike(); //strike
		g.roll(3);
		g.roll(4);
		rollMany(16, 0);
		assertEquals(24, g.score());
	}
	
	@Test
	public void perfectGame() {
		rollMany(12, 10);
		assertEquals(300, g.score());
	}
	
	@Test
	public void game1() {
		g.roll(6);
		g.roll(3);
		rollStrike();
		g.roll(5);
		g.roll(5); //spare
		rollMany(15, 0);
		assertEquals(39, g.score());
	}
	
	@Test
	public void game2() {
		g.roll(2);
		g.roll(2);
		g.roll(9);
		g.roll(0);
		g.roll(7);
		g.roll(3); //spare
		rollStrike();
		rollStrike();
		rollMany(10,0);
		assertEquals(63, g.score());
		
		
	}



	
}
