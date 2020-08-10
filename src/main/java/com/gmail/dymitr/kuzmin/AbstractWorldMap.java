package com.gmail.dymitr.kuzmin;

import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public abstract class AbstractWorldMap implements IWorldMap{

    protected HashSet<Animal> animals = new HashSet<>();

    protected MapVisualizer visualizer = new MapVisualizer(this);

    protected Vector2D lowerLeft;
    protected Vector2D upperRight;

    @Override
    public boolean place(Animal animal) {
        return animals.add(animal);
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
        Iterator<Animal> animalIterator = animals.iterator();

        Window w = new Window();
        w.createWindow();

        for (MoveDirection direction : directions) {
            if (!animalIterator.hasNext())
                animalIterator = animals.iterator();
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
