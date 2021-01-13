package daehnt_desain;
/*
A class for the energy of the flowers and bees
Tyler Daehn
 */

public class Energy {
	private int energy;

	public Energy(int energy){
        this.energy = energy;
	}

    public Energy(Energy energy) {
	    this(energy.energy);
    }

    public void tickEnergyDrop() {
		energy -= 2;
	}

	public void takeEnergy(Energy other) {
		this.energy += other.energy;
		other.energy = 0;
	}

    public boolean EnergyMoreThanZero() {
	    return energy > 0;
    }

    public int getEnergy() {
	    return energy;
    }
}