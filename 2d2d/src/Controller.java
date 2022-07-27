/**
 * Created by ElevPC on 2017-05-08.
 */
import org.newdawn.slick.*;
import org.newdawn.slick.SlickException;

import java.util.LinkedList;
public class Controller {
    public LinkedList<Bullet> b = new LinkedList<Bullet>();
    Bullet tempBullet;

    public Controller(){

    }
    public void update() throws SlickException{
        for (int i = 0; i <b.size() ; i++) {
            tempBullet=b.get(i);
            if(tempBullet.getY() < 0){
                removeBullet(tempBullet);
            }
            tempBullet.update();
        }
    }

    public void render(Graphics g) throws SlickException{
        for (int i = 0; i <b.size() ; i++) {
            tempBullet=b.get(i);
            tempBullet.render(g);
        }
    }
    public void addBullet(Bullet block){
        b.add(block);
    }
    public void removeBullet(Bullet block){
        b.remove(block);
    }
}
