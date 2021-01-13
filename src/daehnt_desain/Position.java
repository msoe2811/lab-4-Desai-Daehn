package daehnt_desain;

/*
A class for the position of objects to check for collisions
Neel Desai
 */

public class Position {
	private int xPos;
	private int yPos;

	public Position(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
	}

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public void setX(int x) {
	    xPos = x;
	}

	public void setY(int y) {
	    yPos = y;
    }

    public double distanceForCollisions(Position otherPosition) {
	    int halfOfDistance = Object.OBJECT_SIZE / 2;
	    int centerX = getX() + halfOfDistance;
	    int centerY = getY() + halfOfDistance;
	    int otherObjectCenterX = otherPosition.getX() + halfOfDistance;
	    int otherObjectCenterY = otherPosition.getY() + halfOfDistance;

	    double xDistance = centerX - otherObjectCenterX;
        double yDistance = centerY - otherObjectCenterY;
        return Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
    }

    public boolean isInteracting(Position otherPosition, double distanceApart) {
	    return distanceForCollisions(otherPosition) <= distanceApart;
    }
}