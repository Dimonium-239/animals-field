package com.gmail.dymitr.kuzmin;

public abstract class AbstractWorldMapElement implements IMapElement{

    protected Vector2D position;

    @Override
    public Vector2D getPosition(){
        return position;
    }

}
