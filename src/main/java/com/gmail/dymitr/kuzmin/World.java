package com.gmail.dymitr.kuzmin;

public class World {

    public static void main(String[] args) {
        MoveDirection[] directions;
        try {
            directions = new OptionsParser().parse(args);
            IWorldMap map = new GrassField(10);
            map.place(new Animal(map, new Vector2D(2,2)));
            map.place(new Animal(map, new Vector2D(1,1)));
            map.run(directions);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
