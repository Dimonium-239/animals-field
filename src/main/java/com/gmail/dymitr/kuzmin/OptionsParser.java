package com.gmail.dymitr.kuzmin;

import java.util.ArrayList;

public class OptionsParser {
    public MoveDirection[] parse(String[] args) throws IllegalArgumentException {
        ArrayList<MoveDirection> moveDirections = new ArrayList<>();

        for (String arg : args){
            switch (arg) {
                case "f" -> moveDirections.add(MoveDirection.FORWARD);
                case "b" -> moveDirections.add(MoveDirection.BACKWARD);
                case "r" -> moveDirections.add(MoveDirection.RIGHT);
                case "l" -> moveDirections.add(MoveDirection.LEFT);
                default -> throw new IllegalArgumentException(arg + " is not legal move specification");
            }
        }

        return moveDirections.toArray(MoveDirection[]::new);
    }
}

