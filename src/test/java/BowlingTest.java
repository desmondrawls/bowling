import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class BowlingTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void gutterGame_scoredAs_0() throws Exception {
        rollMany(20, 0);

        assertThat(game.score(), equalTo(0));
    }

    @Test
    public void onePin_scoredAs_1() throws Exception {
        rollMany(19, 0);
        rollMany(1, 1);

        assertThat(game.score(), equalTo(1));
    }

    @Test
    public void spare_scoredBy_addingTheNextRoll() throws Exception {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);

        assertThat(game.score(), equalTo(16));
    }

    @Test
    public void strike_scoredBy_addTheNextFrame() throws Exception {
        game.roll(10);
        game.roll(2);
        game.roll(3);
        rollMany(17, 0);

        assertThat(game.score(), equalTo(20));
    }

    @Test
    public void perfectGame_scoredAs_300() throws Exception {
        rollMany(12, 10);

        assertThat(game.score(), equalTo(300));
    }

    private void rollMany(int rolls, int pins){
        for(int i = 0; i < rolls; i++){
            game.roll(pins);
        }
    }

    private void rollSpare() {
        rollMany(2, 5);
    }
}
