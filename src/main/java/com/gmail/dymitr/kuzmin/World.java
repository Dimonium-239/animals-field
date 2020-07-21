package com.gmail.dymitr.kuzmin;

import java.util.*;

public class World {

    public static void main(String[] args) {
        Vector2D position1 = new Vector2D(0, 1);
        System.out.println(position1);
        Vector2D position2 = new Vector2D(1, 0);
        System.out.println(position2);

        System.out.println(position1.lowerLeft(position2));
    }

    static MoveDirection[] argsToDirections(String[] args) {
        //@formatter:off
        return Arrays.stream(args).map(x -> {
            switch (x){
                case "f": return MoveDirection.FORWARD;
                case "b": return MoveDirection.BACKWARD;
                case "r": return MoveDirection.RIGHT;
                case "l": return MoveDirection.LEFT;
                default: return null;
            }
        }).toArray(MoveDirection[]::new);
    }
    //@formatter:on

    static void run(MoveDirection[] args) {
        Arrays.asList(args).forEach(arg -> {
            switch (arg) {
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
            }
        });
    }

}
