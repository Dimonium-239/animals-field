package com.gmail.dymitr.kuzmin;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class GrassField extends AbstractWorldMap {
    private HashMap<Vector2D, Grass> grasses = new HashMap<>();

    public GrassField(int grassQuantity) {
        generateGrass(grassQuantity);
    }

    private void updateCorners(Vector2D position) {
        if (upperRight == null)
            upperRight = position;
        else upperRight = upperRight.upperRight(position);
        if (lowerLeft == null)
            lowerLeft = position;
        else  lowerLeft = lowerLeft.lowerLeft(position);
    }

    private void generateGrass(int grassQuantity) {
        Random rand = new Random();
        while (grasses.size() != grassQuantity) {
            Vector2D newPosition = new Vector2D(rand.nextInt((int) (Math.sqrt(grassQuantity) + 1)),
                    rand.nextInt((int) (Math.sqrt(grassQuantity) + 1)));
            if (!isOccupied(newPosition))
                grasses.put(new Vector2D(newPosition.x, newPosition.y), new Grass(newPosition.x, newPosition.y));
        }
    }

    private void eatGrass(Vector2D position) {
        int grassQuantity = grasses.size();
        grasses.remove(position);
        generateGrass(grassQuantity);
    }

    @Override
    public boolean place(Animal animal) {
        if (!animals.containsKey(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
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

            currentAnimal.move(direction);
            eatGrass(currentAnimal.getPosition());

            updateCorners(currentAnimal.getPosition());

            animals.remove(oldPosition);
            animals.put(currentAnimal.getPosition(), currentAnimal);

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
        updateCorners(position);
        if (animals.containsKey(position)) {
            return animals.get(position);
        }
        if (grasses.containsKey(position)) {
            return grasses.get(position);
        }
        return null;
    }

    /*
    private Vector2D grassUpperRight() {
        if (grasses.size() == 0 && animals.size() == 0) return null;

        Iterator<Animal> animalIterator = animals.iterator();
        Iterator<Grass> grassIterator = grasses.iterator();

        Vector2D upperRightPoint;

        if (animalIterator.hasNext()) {
            Animal currentAnimal = animalIterator.next();
            upperRightPoint = currentAnimal.getPosition().upperRight(currentAnimal.getPosition());
        } else {
            Grass currentGrass = grassIterator.next();
            upperRightPoint = currentGrass.getPosition().upperRight(currentGrass.getPosition());
        }
        for (Animal currentAnimal : animals)
            upperRightPoint = upperRightPoint.upperRight(currentAnimal.getPosition());
        for (Grass currentGrass : grasses)
            upperRightPoint = upperRightPoint.upperRight(currentGrass.getPosition());

        upperRightPoint = upperRightPoint.add(new Vector2D(1, 1));

        return upperRightPoint;
    }

    @Deprecated
    private Vector2D grassLowerLeft() {
        if (grasses.size() == 0 && animals.size() == 0) return null;

        Iterator<Animal> animalIterator = animals.iterator();
        Iterator<Grass> grassIterator = grasses.iterator();

        Vector2D lowerLeftPoint;

        if (animalIterator.hasNext()) {
            Animal currentAnimal = animalIterator.next();
            lowerLeftPoint = currentAnimal.getPosition().lowerLeft(currentAnimal.getPosition());
        } else {
            Grass currentGrass = grassIterator.next();
            lowerLeftPoint = currentGrass.getPosition().lowerLeft(currentGrass.getPosition());
        }
        for (Animal currentAnimal : animals)
            lowerLeftPoint = lowerLeftPoint.lowerLeft(currentAnimal.getPosition());
        for (Grass currentGrass : grasses)
            lowerLeftPoint = lowerLeftPoint.lowerLeft(currentGrass.getPosition());

        lowerLeftPoint = lowerLeftPoint.subtract(new Vector2D(1, 1));

        return lowerLeftPoint;
    }
    */
}
