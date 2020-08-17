package com.gmail.dymitr.kuzmin;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class GrassField extends AbstractWorldMap{
    private HashMap<Vector2D, Grass> grasses = new HashMap<>();
    protected MapBoundary mapBoundary = new MapBoundary();

    public GrassField(int grassQuantity) {
        generateGrass(grassQuantity);
    }

    private void generateGrass(int grassQuantity) {
        Random rand = new Random();
        while (grasses.size() != grassQuantity) {
            Vector2D newPosition = new Vector2D(rand.nextInt((int) (Math.sqrt(grassQuantity) + 1)),
                    rand.nextInt((int) (Math.sqrt(grassQuantity) + 1)));
            if (!isOccupied(newPosition)){
                Grass newGrass = new Grass(newPosition.x, newPosition.y);
                grasses.put(new Vector2D(newPosition.x, newPosition.y), newGrass);
                mapBoundary.place(newGrass);
            }
        }
    }

    private void eatGrass(Vector2D position) {
        int grassQuantity = grasses.size();
        mapBoundary.remove(grasses.get(position));
        grasses.remove(position);
        generateGrass(grassQuantity);
    }

    @Override
    public boolean place(Animal animal) {
        if (!animals.containsKey(animal.getPosition())) {
            animal.addObserver(this);
            animal.addObserver(this.mapBoundary);
            animals.put(animal.getPosition(), animal);
            mapBoundary.place(animal);
            upperRight = mapBoundary.upperRight();
            lowerLeft = mapBoundary.lowerLeft();
            return true;
        }
        return false;
    }


    @Override
    public void run(MoveDirection[] directions) {
        ArrayList<Animal> valueList = new ArrayList<>(animals.values());

        Window w = new Window();
        w.createWindow();

        Iterator<Animal> valueIterator = valueList.iterator();
        for (MoveDirection direction : directions) {
            if (!valueIterator.hasNext())
                valueIterator = valueList.iterator();
            Animal currentAnimal = valueIterator.next();

            Vector2D oldPosition = currentAnimal.getPosition();

            mapBoundary.remove(currentAnimal);

            currentAnimal.move(direction);
            eatGrass(currentAnimal.getPosition());

            mapBoundary.place(currentAnimal);

            positionChanged(oldPosition, currentAnimal.getPosition());

            upperRight = mapBoundary.upperRight();
            lowerLeft = mapBoundary.lowerLeft();

            System.out.println(upperRight + " | " + lowerLeft);
            System.out.println(mapBoundary.entitiesX);

            w.updateLabel(this.toString());
            //System.out.println(this.toString());

            try {
                TimeUnit.MILLISECONDS.sleep(750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2D position) {
        return !animals.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2D position) {
        if (animals.containsKey(position)) {
            return animals.get(position);
        }
        if (grasses.containsKey(position)) {
            return grasses.get(position);
        }
        return null;
    }
}
