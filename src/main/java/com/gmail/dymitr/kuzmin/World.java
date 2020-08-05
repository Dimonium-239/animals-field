package com.gmail.dymitr.kuzmin;

import java.util.*;

public class World {

    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2D(3,2)));
        map.run(directions);

    }

    static void run(MoveDirection[] args) {
        Animal an = new Animal();
        System.out.println(an.toString());
        Arrays.asList(args).forEach(arg -> {
            an.move(arg);
            /*switch (arg) {
                case FORWARD:
                    System.out.println("Animal: forward");
                    break;
                case BACKWARD:
                    System.out.println("Animal: backward");
                    break;
                case RIGHT:
                    System.out.println("Animal: right");
                    break;
                case LEFT:
                    System.out.println("Animal: left");
                    break;
                default:
                    System.out.println();
            }*/
        });
        System.out.println(an.toString());
    }

}
