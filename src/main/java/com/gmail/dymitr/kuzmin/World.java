package com.gmail.dymitr.kuzmin;

public class World {

    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        map.place(new Animal(map, new Vector2D(0,0)));
        map.place(new Animal(map, new Vector2D(3,2)));
        map.run(directions);

    }
}
