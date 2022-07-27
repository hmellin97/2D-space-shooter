import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {
    Image logo;
    public Menu(int state){

    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException  {
        logo = new Image("Images/logo.png");
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawString("Press P to play", 180, 250);
        g.drawString("Help", 180, 300);
        g.drawImage(logo, 50, 100);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException  {
        Input input = gc.getInput();
        if(input.isKeyDown(Input.KEY_P)){
            sbg.enterState(1);
        }
        if(input.isKeyDown(Input.KEY_H)){
            sbg.enterState(3);
        }
    }




    public int getID(){
        return 0;
    }


}