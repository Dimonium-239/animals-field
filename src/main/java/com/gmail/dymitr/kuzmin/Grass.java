package com.gmail.dymitr.kuzmin;

public class Grass extends AbstractWorldMapElement {

    public Grass(int x, int y){
        position = new Vector2D(x, y);
    }

    @Override
    public String toString(){
        return "*";
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Grass && ((Grass) object).getPosition().equals(this.position);
    }
}
