import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Help extends BasicGameState {
    public Help(int state){

    }
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{

    }
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawString("Use arrow keys to move", 200, 250);
        g.drawString("Press spacebar to shoot", 200, 300);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        Input input = gc.getInput();
        if(input.isKeyPressed(Input.KEY_B)){
            sbg.enterState(0);
        }
    }
    public int getID(){
        return 3;
    }

}