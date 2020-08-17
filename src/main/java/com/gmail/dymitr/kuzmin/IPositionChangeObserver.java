package com.gmail.dymitr.kuzmin;

public interface IPositionChangeObserver {

    void positionChanged(Vector2D oldPosition, Vector2D newPosition);
}
