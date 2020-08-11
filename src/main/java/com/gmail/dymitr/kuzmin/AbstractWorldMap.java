package com.gmail.dymitr.kuzmin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public abstract class AbstractWorldMap implements IWorldMap{

    protected HashMap<Vector2D, Animal> animals = new HashMap<>();

    protected MapVisualizer visualizer = new MapVisualizer(this);

    protected Vector2D lowerLeft;
    protected Vector2D upperRight;

    @Override
    public boolean place(Animal animal) {
        animals.put(animal.getPosition(), animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2D position) {
        return objectAt(position) != null;
    }

    @Override
    public String toString(){
        return visualizer.draw(lowerLeft, upperRight);
    }

    @Override
    public void run(MoveDirection[] directions) {
        Iterator<Animal> animalIterator = animals.values().iterator();

        Window w = new Window();
        w.createWindow();

        for (MoveDirection direction : directions) {
            if (!animalIterator.hasNext())
                animalIterator = animals.values().iterator();
            animalIterator.next().move(direction);

            w.updateLabel(this.toString());
            //System.out.println(this.toString());

            try {
                TimeUnit.MILLISECONDS.sleep(750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
