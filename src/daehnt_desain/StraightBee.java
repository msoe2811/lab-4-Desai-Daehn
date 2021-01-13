package daehnt_desain;
/*
A class for the straight moving bee
Neel Desai
 */

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class StraightBee extends Bee {
    private FlowerPower flowerPower;

	public StraightBee(Image image, Pane container, Energy energy, Position position) {
        super(image, container, energy, position);
    }

    public void moveBee() {
        energy.tickEnergyDrop();
        int xDirection = Integer.compare(flowerPower.getPosition().getX(), getPosition().getX());
        int yDirection = Integer.compare(flowerPower.getPosition().getY(), getPosition().getY());
        getPosition().setX(getPosition().getX() + (xDirection * 25));
        getPosition().setY(getPosition().getY() + (yDirection * 25));
    }

    public void NextFlower(FlowerPower flowerPower) {
	    this.flowerPower = flowerPower;
    }
}