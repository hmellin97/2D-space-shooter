import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Play extends BasicGameState {
    int xPos = 250;
    int yPos = 579;
    Controller c;
    boolean bulletTime = false;
    Music music;
    Sound shoot;
    Sound loseLife;
    Sound enemyHit;
    private ArrayList<Enemy> enemy;
    private ArrayList<Enemy> toRemove;
    int time;
    int difficulty;
    int enemyCount;
    int enemySpawnTimer;
    Image background;
    Image heart;
    Image ship;
    Image alien;
    int LIFE_COUNTER;
    public int SCORE;
    int refreshCharge;
    int charge;

    public Play(int state){
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException  {
        charge= 10;
        LIFE_COUNTER = 5;
        SCORE = 0;
        difficulty = 2;
        enemyCount = 0;
        enemySpawnTimer = 400;
        enemy = new ArrayList<>();
        toRemove = new ArrayList<>();
        c = new Controller();
        shoot  = new Sound("Sound/pew.ogg");
        loseLife = new Sound("Sound/LoseLife.ogg");
        enemyHit = new Sound("Sound/EnemyHit.ogg");
        music = new Music("Sound/bestsong.ogg");
        music.loop(1, 0.5f);
        alien=new Image("Images/alien.png");
        ship= new Image("Images/space2.png");
        background = new Image("Images/background.png");
        heart = new Image("Images/8bitheart.png");

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        background.draw();
        ship.draw(xPos,yPos-25);
        hearts(g);
        drawCharge(g);
        g.setColor(Color.white);
        g.drawString("Level:" + (difficulty-1),350, 13);
        g.drawString("Score:" + SCORE, 350, 35);
        g.drawRect(420,59,50,22);
        c.render(g);
        for (Enemy e: enemy){
            e.render(alien);
        }
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException  {
        keyPressed(gc);
        for(Bullet t: c.b){
            t.hitbox.setLocation(t.x, t.y);
        }
        for(Enemy e: enemy) {
            e.update(delta);
            e.hitbox.setLocation(e.x, e.y);
            if (e.y > 560) {
                loseLife.play();
                toRemove.add(e);
                LIFE_COUNTER--;
                if (LIFE_COUNTER == 0) {
                    getScore();
                    sbg.enterState(2);
                }
            }
        }
        enemy.removeAll(toRemove);


        time+=delta;

        //hur ofta enemies spawnar
        if(time>enemySpawnTimer){
            enemy.add(new Enemy());
            time=0;
        }
        if(enemyCount > 40){
            difficulty++;
            enemySpawnTimer = enemySpawnTimer-50;
            enemyCount=0;
        }
        refreshCharge+=delta;
        if((refreshCharge>400) && charge < 10){
            charge++;
            refreshCharge=0;
        }
        if(bulletTime){
            c.update();
        }
        for(Enemy e: enemy){
            for(Bullet t: c.b){
                if (e.getHitbox().intersects(t.getHitbox())) {
                    SCORE = SCORE + 100;
                    toRemove.add(e);
                    enemyCount++;
                    enemyHit.play(1, 0.4f);
                }
            }
        }
        enemy.removeAll(toRemove);
    }

    public void keyPressed(GameContainer gc){
        Input input = gc.getInput();
        if(input.isKeyDown(Input.KEY_LEFT) && xPos > 0){
            xPos = xPos -5;
        }
        if(input.isKeyDown(Input.KEY_RIGHT) && xPos < 479) {
            xPos = xPos + 5;
        }
        if(input.isKeyPressed(Input.KEY_SPACE) && charge >0) {
            charge--;
            c.addBullet(new Bullet(xPos+25, yPos-65, 2, 60));
            shoot.play(1f, 0.8f);
            bulletTime=true;
        }
    }

    public void hearts(Graphics g){
        for (int i = 1; i <LIFE_COUNTER+1 ; i++) {
            heart.draw(20*i+15*i,20);
        }
    }

    public void drawCharge(Graphics g){
        g.setColor(Color.white);
        g.drawString("Charge:", 350,60);
        g.setColor(Color.red);
        for (int i = 0; i <charge ; i++) {
            g.fillRect(420+5*i, 60, 2, 20);
        }
    }
    public void getScore(){try {
        String str = "Score: " + SCORE;
        File newTextFile = new File("Score.txt");
        FileWriter fw = new FileWriter(newTextFile);
        fw.write(str);
        fw.close();

    } catch (Exception e) {
        e.printStackTrace();}
    }

    public int getID(){
        return 1;
    }


}
