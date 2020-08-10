package com.gmail.dymitr.kuzmin;

public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int height){
        lowerLeft = new Vector2D(0,0);
        upperRight = new Vector2D(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2D position) {
        return position.follows(new Vector2D(0,0))
                && position.precedes(upperRight)
                && !isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2D position) {
        for (Animal animal : animals)
            if (animal.getPosition().equals(position)) return animal;
        return null;
    }
}
