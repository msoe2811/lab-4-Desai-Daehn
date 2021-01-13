package daehnt_desain;

/*
A controller class for the application
Tyler Daehn
 */

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GardenController {
	private List<Object> entities;
	private FlowerPower BadRoseFlower;
	private FlowerPower GoodAsterFlower;
    private List<Bee> bees;

	@FXML
	private Pane beeImageBox;

	public GardenController(){
		entities = new ArrayList<>();
        bees = new ArrayList<>();
	}

	@FXML
	public void initialize() {
		beeImageBox.setStyle("-fx-background-color: linear-gradient(to bottom right, derive(forestgreen, 20%), derive(forestgreen, -40%));");
        bees.add(new StraightBee(new Image("file:bee-1.jpg"), beeImageBox, new Energy(100), new Position(0, 0)));
        bees.add(new RandoBee(new Image("file:bee-2.jpg"), beeImageBox, new Energy(100), new Position(0, 0)));
        GoodAsterFlower = new FlowerPower(new Image("file:aster.jpg"), beeImageBox, new Energy(50), new Position(0, 0));
        BadRoseFlower = new FlowerPower(new Image("file:rose.jpg"), beeImageBox, new Energy(-50), new Position(0, 0));

        entities.addAll(bees);
        entities.add(GoodAsterFlower);
        entities.add(BadRoseFlower);
        setPositions();

		GoodAsterFlower.constructAndMoveHealthBars();
        BadRoseFlower.constructAndMoveHealthBars();
		for (Bee bee: bees) {
		    bee.constructAndMoveHealthBars();

			Random random = new Random();
		    int randFlower = random.nextInt(getFlowers().length);
		    bee.NextFlower(getFlowers()[randFlower]);
        }
	}

	@FXML
	public void onKeyPressed(KeyEvent keyEvent) {
		if (keyEvent.getCode() == KeyCode.RIGHT) {
            bees.removeIf(bee -> !bee.BeeIsAlive());
			InteractionType();
			GoodAsterFlower.constructAndMoveHealthBars();
			BadRoseFlower.constructAndMoveHealthBars();
		}
	}

	private void InteractionType() {
        for (Bee bee : bees) {
			for (Bee otherBee : bees) {
				if (bee == otherBee) {
					continue;
				}
				if (bee.Interaction(otherBee)) {
					bee.getEnergy().takeEnergy(new Energy(-20));
				}
			}

			if (bee.Interaction(GoodAsterFlower)) {
				bee.energy.takeEnergy(GoodAsterFlower.energy);
				bee.NextFlower(BadRoseFlower);
			} else if (bee.Interaction(BadRoseFlower)) {
				bee.energy.takeEnergy(BadRoseFlower.energy);
				bee.NextFlower(GoodAsterFlower);
			}
		}

        for (Bee bee : bees) {
        	bee.constructAndMoveHealthBars();

        	if (!bee.getEnergy().EnergyMoreThanZero()) {
				bee.die();
				bees.remove(bee);
			}
		}
	}

	public FlowerPower[] getFlowers() {
	    return new FlowerPower[] {BadRoseFlower, GoodAsterFlower};
    }

    public Scene displayScene() {
		beeImageBox.setPrefWidth(800);
	    beeImageBox.setPrefHeight(600);
		Scene ret = new Scene(beeImageBox);
	    ret.addEventHandler(KeyEvent.KEY_PRESSED, this::onKeyPressed);
	    return ret;
    }

    private void setPositions() {
		Random random = new Random();

		for (Object object : entities) {
			int xPosition = random.nextInt(800 - Object.OBJECT_SIZE);
			int yPosition = random.nextInt(600 - Object.OBJECT_SIZE);

			object.getPosition().setX(xPosition);
			object.getPosition().setY(yPosition);
		}
	}
}