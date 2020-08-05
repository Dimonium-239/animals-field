package com.gmail.dymitr.kuzmin;

public enum MapDirection {
    NORTH {
        @Override
        public String toString() {
            return "∧";
        }
    },
    EAST {
        @Override
        public String toString() {
            return ">";
        }
    },
    SOUTH {
        @Override
        public String toString() {
            return "v";
        }
    },
    WEST {
        @Override
        public String toString() {
            return "<";
        }
    };

    //@formatter:off
    public MapDirection next() {
        switch (this){
            case NORTH: return EAST;
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
        }
        return this;
    }

    public MapDirection previous() {
        switch (this){
            case NORTH: return WEST;
            case WEST: return SOUTH;
            case SOUTH: return EAST;
            case EAST: return NORTH;
        }
        return this;
    }

    public Vector2D toUnitVector(){
        switch (this){
            case NORTH: return new Vector2D(0,1);
            case WEST: return new Vector2D(-1,0);
            case SOUTH: return new Vector2D(0,-1);
            case EAST: return new Vector2D(1,0);
        }
        return new Vector2D(0,0);
    }
    //@formatter:on
}
