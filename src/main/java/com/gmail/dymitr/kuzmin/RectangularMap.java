package com.gmail.dymitr.kuzmin;

import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class RectangularMap implements IWorldMap {
    private int width;
    private int height;
    private HashSet<Animal> animals = new HashSet<>();
    private MapVisualizer visualizer = new MapVisualizer(this);

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean canMoveTo(Vector2D position) {
        return position.follows(new Vector2D(0,0))
                && position.precedes(new Vector2D(width, height))
                && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (!isOccupied(animal.getPosition())) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        Iterator<Animal> animalIterator = animals.iterator();
        Window w = new Window();
        w.createWindow();
        for (MoveDirection direction : directions) {
            if (!animalIterator.hasNext())
                animalIterator = animals.iterator();
            animalIterator.next().move(direction);
            w.updateLabel(this.toString());
            System.out.println(this.toString());
            try {
                TimeUnit.MILLISECONDS.sleep(750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2D position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2D position) {
        for (Animal animal : animals)
            if (animal.getPosition().equals(position)) return animal;
        return null;
    }

    @Override
    public String toString(){
        return visualizer.draw(new Vector2D(0,0), new Vector2D(width, height));
    }
}
