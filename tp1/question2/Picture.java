package question2;

import question1.Circle;
import question1.Square;
import question1.Triangle;

/**
 * This class represents a simple picture. You can draw the picture using the
 * draw method. But wait, there's more: being an electronic picture, it can be
 * changed. You can set it to black-and-white display and back to colors (only
 * after it's been drawn, of course).
 * 
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 1.1 (24 May 2001)
 */
public class Picture {
    private Square wall;
    private Square window;
    private Triangle roof;
    private Circle sun;
    private Circle sun2;
    private boolean terreEstFixe=true;

    /**
     * Constructor for objects of class Picture
     */
    public Picture() {
        // nothing to do... instance variables are automatically set to null
    }

    /**
     * Draw this picture.
     */
    public void draw() {
        if (terreEstFixe && sun==null){ 
            /** terreEstFixe devient false quand on execute coucherSoleil() , 
             * c-a-d on verifie que cette var est true et que sun n'est pas encore créée 
             * pour ne pas rexecuter draw() et avoir un second seleil bleu sur l'ecran ou caché en bas*/ 
                                        
             wall = new Square();
             wall.moveVertical(80);
             wall.changeSize(100);
             wall.makeVisible();

             window = new Square();
             window.changeColor("black");
             window.moveHorizontal(20);
             window.moveVertical(100);
             window.makeVisible();

             roof = new Triangle();
             roof.changeSize(50, 140);
             roof.moveHorizontal(60);
             roof.moveVertical(70);
             roof.makeVisible();

             sun = new Circle();
             sun.changeColor("blue");
             sun.moveHorizontal(180);
             sun.moveVertical(-10);
             sun.changeSize(60);
             sun.makeVisible();
        
             sun2 = new Circle();
             sun2.changeColor("yellow");
             sun2.makeVisible();
             sun2.changeSize(30);
             sun2.moveHorizontal(245);
             sun2.moveVertical(-10);
        }
        else{
            sun.makeInvisible();
            sun=null; //Pour que si on reexecute draw on recommence de nouveau c-a-d sans le soleil bleu en bas et avec un nouveau soleil bleu en haut
            terreEstFixe=true;
            draw();
        }
    }
    /**
     * Ajouter une nouvelle méthode à la classe Picture permettant au soleil
     * ( bleu) de se coucher (si la terre est fixe...), voir la méthode 
     * slowMoveVertical de la classe "Circle"
       */
    public void coucherSoleil(){
        if(sun != null) //pour ne pas avoir une erreure si on execute coucherSoleil() avant draw()
        {
            if(terreEstFixe)
            {
                sun.slowMoveVertical(230);
                terreEstFixe = false;
            } 
            
        }   
    }

    /**
     * Change this picture to black/white display
     */
    public void setBlackAndWhite() {
        if (wall != null) // only if it's painted already...
        {
            wall.changeColor("black");
            window.changeColor("white");
            roof.changeColor("black");
            sun.changeColor("black");
            sun2.changeColor("black");
        }
    }

    /**
     * Change this picture to use color display
     */
    public void setColor() {
        if (wall != null) // only if it's painted already...
        {
            wall.changeColor("red");
            window.changeColor("black");
            roof.changeColor("green");
            sun.changeColor("blue");
            sun2.changeColor("yellow");
        }
    }
   
  
}
