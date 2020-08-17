package com.gmail.dymitr.kuzmin;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver{

    public SortedSet<AbstractWorldMapElement> entitiesX = new TreeSet<>(new Comparator<>() {
        @Override
        public int compare(AbstractWorldMapElement t1, AbstractWorldMapElement t2) {
            Vector2D pos1 = t1.getPosition();
            Vector2D pos2 = t2.getPosition();
            if (pos1.x > pos2.x) return 1;
            if (pos1.x < pos2.x) return -1;
            if (pos1.y > pos2.y) return 1;
            if (pos1.y < pos2.y) return -1;
            if (t1 instanceof Animal) return 1;
            if (t2 instanceof Animal) return -1;
            return 0;
            }
        });

    private SortedSet<AbstractWorldMapElement> entitiesY = new TreeSet<>(new Comparator<AbstractWorldMapElement>() {
        @Override
        public int compare(AbstractWorldMapElement t1, AbstractWorldMapElement t2) {
            Vector2D pos1 = t1.getPosition();
            Vector2D pos2 = t2.getPosition();
            if (pos1.y > pos2.y) return 1;
            if (pos1.y < pos2.y) return -1;
            if (pos1.x > pos2.x) return -1;
            if (pos1.x < pos2.x) return 1;
            if (t1 instanceof Animal) return 1;
            if (t2 instanceof Animal) return -1;
            return 0;
        }
    });

    public void place(AbstractWorldMapElement element){
        entitiesX.add(element);
        entitiesY.add(element);
    }

    public void remove(AbstractWorldMapElement element){
        if (element != null) {
            entitiesX.removeIf(entity -> entity.equals(element));
            entitiesY.removeIf(entity -> entity.equals(element));
        }
    }

    public Vector2D upperRight(){
        return new Vector2D(entitiesX.last().getPosition().x, entitiesY.last().getPosition().y);
    }

    public Vector2D lowerLeft(){
        return new Vector2D(entitiesX.first().getPosition().x, entitiesY.first().getPosition().y);
    }

    @Override
    public void positionChanged(Vector2D oldPosition, Vector2D newPosition) {
    }


}
