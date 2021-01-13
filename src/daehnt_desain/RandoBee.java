package daehnt_desain;

/*
A class for the random moving bee
Neel Desai
 */

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import java.util.Random;

public class RandoBee extends Bee {
	public RandoBee(Image image, Pane pane, Energy energy, Position position) {
        super(image, pane, energy, position);
    }

    public void moveBee() {
        energy.tickEnergyDrop();
	    Random random = new Random();
        int randomXDirection = random.nextInt(2);
        if (randomXDirection == 0) randomXDirection = -1;
        int randomYDirection = random.nextInt(2);
        if (randomYDirection == 0) randomYDirection = -1;

        int randomXValue = random.nextInt(30) + 20;
        int randomYValue = random.nextInt(30) + 20;

        int newXPosition = getPosition().getX() + (randomXDirection * randomXValue);
        int newYPosition = getPosition().getY() + (randomYDirection * randomYValue);
        if (newXPosition < 0 || newXPosition > 800 - OBJECT_SIZE) {
            newXPosition = getPosition().getX() + (-randomXDirection * randomXValue);
        }
        if (newYPosition < 0 || newYPosition > 600 - OBJECT_SIZE) {
            newYPosition = getPosition().getY() + (-randomYDirection * randomYValue);
        }

        getPosition().setX(newXPosition);
        getPosition().setY(newYPosition);
    }
}