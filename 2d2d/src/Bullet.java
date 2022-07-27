import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.Sound;

public class Bullet {
    int x;
    int y;
    int width;
    int height;
    Rectangle hitbox;

    public Bullet(int x, int y, int width, int height){
        this.x=x;
        this.y=y;
        this.width= width;
        this.height = height;
        hitbox = new Rectangle(x,y,width,height);
    }

    public Rectangle getHitbox(){
        return hitbox;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{


    }

    public void render(Graphics g) throws SlickException {
        g.setColor(Color.red);
        g.drawOval(x,y,width,height);
    }
    public void update() throws SlickException  {
        y -= 10;
    }



    public int getY(){
        return y;
    }
}