package com.gmail.dymitr.kuzmin;

public class Animal {
    private MapDirection mapDirection = MapDirection.NORTH;
    private Vector2D position = new Vector2D(2, 2);

    @Override
    public String toString() {
        return "[" + position.toString() + ", " + mapDirection.toString() + "]";
    }

    public void move(MoveDirection direction) {
        if (direction == MoveDirection.RIGHT)
            mapDirection = mapDirection.next();
        if (direction == MoveDirection.LEFT)
            mapDirection = mapDirection.next();
        if (direction == MoveDirection.FORWARD && position.add(mapDirection.toUnitVector()).precedes(new Vector2D(4,4))){
            position = position.add(mapDirection.toUnitVector());
        }
        if (direction == MoveDirection.BACKWARD && position.subtract(mapDirection.toUnitVector()).follows(new Vector2D(0,0))){
            position = position.subtract(mapDirection.toUnitVector());
        }
    }
}
