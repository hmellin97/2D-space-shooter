import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import java.util.Random;

/**
 * Enemy class generates an enemy for the player to shoot at.
 * The position of the enemy is in the beginning at the top of the screen at a randomly generated position.
 *
 */
public class Enemy {

    float y = 0;
    Random rand = new Random();
    int x = rand.nextInt(430);
    int randSpeed = rand.nextInt(4);
    public Rectangle hitbox;

    public Enemy() {
        hitbox = new Rectangle(x, y, 70, 20);

    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

    }

    public void render(Image g) throws SlickException {
        g.draw(x,y);
    }


    public void update(int delta) throws SlickException {
        //y += 3;
        y+= randSpeed + 1;
    }

}
