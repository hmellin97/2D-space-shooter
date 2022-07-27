import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.io.BufferedReader;
import java.io.FileReader;

public class Gameover extends BasicGameState {

    public Gameover(int state){
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.setColor(Color.white);
        String s= readScore();
        graphics.drawString("Game over",200,240);
        graphics.drawString("Try again?", 200, 300);
        graphics.drawString("Press T", 200, 330);
        graphics.drawString("Main menu", 200, 400);
        graphics.drawString(s, 200, 270);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        if(input.isKeyDown(Input.KEY_T)){
            sbg.getState(1).init(gc, sbg);
            sbg.enterState(1);
        }
        if(input.isKeyDown(Input.KEY_M)){
            sbg.getState(1).init(gc, sbg);
            sbg.enterState(0);
        }
    }
    public String readScore(){
        try (BufferedReader br = new BufferedReader(new FileReader("Score.txt"))) {
            String line = br.readLine();
            return line;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getID() {
        return 2;
    }
}