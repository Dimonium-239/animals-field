package com.gmail.dymitr.kuzmin;

public class Animal {
    private MapDirection mapDirection = MapDirection.NORTH;
    private Vector2D position = new Vector2D(2, 2);
    private IWorldMap map;

    public Animal() {
    }

    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2D initialPosition) {
        this.position = initialPosition;
        this.map = map;
    }

    public Vector2D getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return this.mapDirection.toString();
    }

    public void move(MoveDirection direction) {
        Vector2D newPosition = position;
        if (direction == MoveDirection.RIGHT)
            mapDirection = mapDirection.next();
        else if (direction == MoveDirection.LEFT)
            mapDirection = mapDirection.previous();
        else if (direction == MoveDirection.FORWARD)
            newPosition = position.add(mapDirection.toUnitVector());
        else if (direction == MoveDirection.BACKWARD)
            newPosition = position.subtract(mapDirection.toUnitVector());
        if (map.canMoveTo(newPosition))
            position = newPosition;
    }
}
