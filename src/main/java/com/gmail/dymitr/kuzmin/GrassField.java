package com.gmail.dymitr.kuzmin;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class GrassField extends AbstractWorldMap{
    private HashSet<Grass> grasses = new HashSet<>();

    public GrassField(int grassQuantity){
        generateGrass(grassQuantity);
        initCorners();
    }

    private void initCorners(){
        lowerLeft = grassLowerLeft();
        upperRight = grassUpperRight();
    }

    private void generateGrass(int grassQuantity){
        Random rand = new Random();
        while (grasses.size() != grassQuantity){
            Vector2D newPosition = new Vector2D(rand.nextInt((int) (Math.sqrt(grassQuantity) + 1)),
                    rand.nextInt((int) (Math.sqrt(grassQuantity) + 1)));
            if (!isOccupied(newPosition)) {
                grasses.add(new Grass(newPosition.x, newPosition.y));
            }
        }
    }

    private void eatGrass(Vector2D position){
        int grassQuantity = grasses.size();
        for(Grass grass : grasses)
            if (grass.getPosition().equals(position)) {
                grasses.remove(grass);
                break;
            }
        generateGrass(grassQuantity);
        initCorners();
    }

    @Override
    public void run(MoveDirection[] directions) {
        Iterator<Animal> animalIterator = animals.iterator();

        Window w = new Window();
        w.createWindow();

        for (MoveDirection direction : directions) {
            if (!animalIterator.hasNext())
                animalIterator = animals.iterator();
            Animal currentAnimal = animalIterator.next();
            currentAnimal.move(direction);
            eatGrass(currentAnimal.getPosition());

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
        return !isOccupiedByAnimal(position);
    }

    @Override
    public Object objectAt(Vector2D position) {
        for (Animal animal : animals)
            if (animal.getPosition().equals(position))
                return animal;
        for (Grass grass : grasses)
            if (grass.getPosition().equals(position))
                return grass;
        return null;
    }

    private boolean isOccupiedByAnimal(Vector2D position){
        for (Animal animal : animals)
            if (animal.getPosition().equals(position)) return true;
        return false;
    }

    private Vector2D grassUpperRight(){
        if (grasses.size() == 0 && animals.size() == 0) return null;

        Iterator<Animal> animalIterator = animals.iterator();
        Iterator<Grass> grassIterator = grasses.iterator();

        Vector2D upperRightPoint;

        if (animalIterator.hasNext()) {
            Animal currentAnimal = animalIterator.next();
            upperRightPoint = currentAnimal.getPosition().upperRight(currentAnimal.getPosition());
        }
        else {
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

    private Vector2D grassLowerLeft(){
        if (grasses.size() == 0 && animals.size() == 0) return null;

        Iterator<Animal> animalIterator = animals.iterator();
        Iterator<Grass> grassIterator = grasses.iterator();

        Vector2D lowerLeftPoint;

        if (animalIterator.hasNext()) {
            Animal currentAnimal = animalIterator.next();
            lowerLeftPoint = currentAnimal.getPosition().lowerLeft(currentAnimal.getPosition());
        }
        else {
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

}
