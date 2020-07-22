package com.gmail.dymitr.kuzmin;

import java.util.Arrays;

public class OptionsParser {
    public MoveDirection[] parse(String[] args) {
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
}

