package com.gmail.dymitr.kuzmin;

import java.util.ArrayList;

public class Animal extends AbstractWorldMapElement{

    private MapDirection mapDirection = MapDirection.NORTH;
    private ArrayList<IPositionChangeObserver> observers = new ArrayList<>();
    private IWorldMap map;

    public Animal() {}

    public Animal(IWorldMap map) {
        position = new Vector2D(2, 2);
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2D initialPosition) {
        this.position = initialPosition;
        this.map = map;
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    public void positionChanged(Vector2D oldPosition, Vector2D newPosition){
        for (IPositionChangeObserver observer : observers)
            observer.positionChanged(oldPosition, newPosition);
    }

    @Override
    public String toString() {
        return this.mapDirection.toString();
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Animal && ((Animal) object).getPosition().equals(this.position);
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
