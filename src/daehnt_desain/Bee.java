package daehnt_desain;

/*
An abstract class for the Bee object
Neel Desai
 */

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public abstract class Bee extends Object {
	public Bee(Image image, Pane container, Energy energy, Position position) {
		super(image, container, energy, position);
	}

	public abstract void moveBee();

	public boolean BeeIsAlive() {
		moveBee();
		if (!energy.EnergyMoreThanZero()) {
			die();
			return false;
		}
		return true;
	}

	public void NextFlower(FlowerPower flowerPower) {
	}
}