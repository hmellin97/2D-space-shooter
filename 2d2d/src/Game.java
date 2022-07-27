import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
public class Game extends StateBasedGame{
    int menu = 0;
    int play = 1;
    int gameover = 2;
    int help = 3;

    public Game(){
        super("2D-Shooter");
        this.addState(new Menu(menu));
        this.addState(new Play(play));
        this.addState(new Gameover(gameover));
        this.addState(new Help(help));
    }

    public void initStatesList(GameContainer gc) throws SlickException{
        gc.setShowFPS(false);
        this.getState(menu).init(gc,this);
        this.getState(play).init(gc, this);
        this.getState(gameover).init(gc,this);
        this.getState(help).init(gc, this);
        this.enterState(menu);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Game());
        app.setDisplayMode(500,600, false);
        app.setTargetFrameRate(100);
        app.start();
    }
}