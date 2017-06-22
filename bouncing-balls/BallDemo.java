import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int noOfBalls)
    {
        int ground = 400;   // position of the ground line
        
        
        ArrayList<BouncingBall> balls=new ArrayList<BouncingBall>();
        for(int i=0;i<noOfBalls;i++)
        {
            int randNum1=rand(75);
            
            int r=rColor();
            int g=rColor();
            int b=rColor();
            Color randColor=new Color(r,g,b);
            balls.add(new BouncingBall((50+(30*i)), 50+(i*10), randNum1, randColor, ground, myCanvas));
            
        }
        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

            // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(40);
            for(BouncingBall ball : balls){
                  
                ball.draw();
                
                ball.move();
                
 
            
            }
            // stop once ball has travelled a certain distance on x axis
            if((balls.get(0)).getXPosition() >= 600)
                {
                    finished = true;
                }
        }        
    }
    
    private int rand(int n)
    {
        Random r= new Random();
        int i=0;
        while (i<10){
            i=r.nextInt(n);
        }
        return i;
    }
    private int rColor()
    {
        Random r= new Random();
        int i=r.nextInt(255);
        return i;
    }
}
