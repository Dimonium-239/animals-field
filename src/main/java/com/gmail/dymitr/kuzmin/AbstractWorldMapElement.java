package com.gmail.dymitr.kuzmin;

public abstract class AbstractWorldMapElement implements IMapElement{

    protected Vector2D position;

    @Override
    public Vector2D getPosition(){
        return position;
    }

    @Override
    public int hashCode(){
        return position.hashCode();
    }

    public int compareTo(AbstractWorldMapElement o1){
        if(this.hashCode() == o1.hashCode())
            return 0;
        return 1;
    }
}
