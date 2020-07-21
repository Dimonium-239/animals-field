package com.gmail.dymitr.kuzmin;

public class Vector2D {
    public final int x;
    public final int y;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Vector2D)) return false;
        Vector2D other = (Vector2D) object;
        return this.x == other.x && this.y == other.y;
    }

    public boolean precedes(Vector2D other) {
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2D other) {
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2D upperRight(Vector2D other) {
        int x = this.x >= other.x ? this.x : other.x;
        int y = this.y >= other.y ? this.y : other.y;
        return new Vector2D(x, y);
    }

    public Vector2D lowerLeft(Vector2D other) {
        int x = this.x <= other.x ? this.x : other.x;
        int y = this.y <= other.y ? this.y : other.y;
        return new Vector2D(x, y);
    }

    public Vector2D add(Vector2D other) {
        return new Vector2D(this.x + other.x, this.y + other.y);
    }

    public Vector2D subtract(Vector2D other) {
        return new Vector2D(this.x - other.x, this.y - other.y);
    }

    public Vector2D opposite() {
        return new Vector2D(-this.x, -this.y);
    }
}
