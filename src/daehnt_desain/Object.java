package daehnt_desain;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/*
A class for the objects on the pane
Tyler Daehn
 */

public class Object {
    private final ImageView imageView;
    private final Pane pane;
    private Position position;
    protected Energy energy;
    private Energy beginningEnergy;
    private Rectangle DrainedBar;
    private Rectangle healthBar;

    public static final int OBJECT_SIZE = 80;
    private static final int HEALTH_SIDE_PADS = 5;
    private static final int HEALTH_HEIGHT = 10;
    private static final int HEALTH_WIDTH = 70;
    private static final int HEALTH_BOTTOM_PAD = 60;

	public Object(Image image, Pane pane, Energy energy, Position position) {
	    this.pane = pane;
        this.imageView = new ImageView(image);
        this.imageView.setFitWidth(OBJECT_SIZE);
        this.imageView.setFitHeight(OBJECT_SIZE);
        pane.getChildren().add(this.imageView);
        this.DrainedBar = new Rectangle(HEALTH_WIDTH, HEALTH_HEIGHT, Color.GRAY);
        pane.getChildren().add(this.DrainedBar);
        this.healthBar = new Rectangle(HEALTH_WIDTH, HEALTH_HEIGHT, Color.GREEN);
        pane.getChildren().add(this.healthBar);
        this.position = position;
        this.energy = energy;
        this.beginningEnergy = new Energy(energy);
	}

	public void constructAndMoveHealthBars() {
        healthBar.setWidth(HEALTH_WIDTH * Math.abs((double) energy.getEnergy() / beginningEnergy.getEnergy()));
        if (energy.EnergyMoreThanZero()) {
            healthBar.setFill(Color.GREEN);
        } else {
            healthBar.setFill(Color.RED);
        }
        imageView.relocate(position.getX(), position.getY());
        DrainedBar.relocate(position.getX() + HEALTH_SIDE_PADS, position.getY() + HEALTH_BOTTOM_PAD);
        healthBar.relocate(position.getX() + HEALTH_SIDE_PADS, position.getY() + HEALTH_BOTTOM_PAD);
    }

    public boolean Interaction(Object otherObject) {
	    double radius = (imageView.getFitHeight() + imageView.getFitWidth()) / 4;
	    boolean colliding =  position.isInteracting(otherObject.position, radius * 2);
	    return colliding;
    }

    protected void die() {
        pane.getChildren().removeAll(this.imageView, this.healthBar, this.DrainedBar);
    }

    public Energy getEnergy() {
        return energy;
    }

    public Position getPosition() {
        return position;
    }
}