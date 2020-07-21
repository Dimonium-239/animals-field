import com.gmail.dymitr.kuzmin.MapDirection;
import com.gmail.dymitr.kuzmin.Vector2D;

import org.junit.Test;
import org.junit.Assert;

public class MapDirectionTest {
    @Test
    public void toStringTest(){
        Assert.assertEquals("North", MapDirection.NORTH.toString());
        Assert.assertEquals("East", MapDirection.EAST.toString());
        Assert.assertEquals("South", MapDirection.SOUTH.toString());
        Assert.assertEquals("West", MapDirection.WEST.toString());
    }

    @Test
    public void nextTest(){
        Assert.assertEquals(MapDirection.EAST, MapDirection.NORTH.next());
        Assert.assertEquals(MapDirection.SOUTH, MapDirection.EAST.next());
        Assert.assertEquals(MapDirection.WEST, MapDirection.SOUTH.next());
        Assert.assertEquals(MapDirection.NORTH, MapDirection.WEST.next());
    }

    @Test
    public void previousTest(){
        Assert.assertEquals(MapDirection.WEST, MapDirection.NORTH.previous());
        Assert.assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous());
        Assert.assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous());
        Assert.assertEquals(MapDirection.NORTH, MapDirection.EAST.previous());
    }

    @Test
    public void toUnitVectorTest(){
        Assert.assertEquals(new Vector2D(0,1), MapDirection.NORTH.toUnitVector());
        Assert.assertEquals(new Vector2D(1,0), MapDirection.EAST.toUnitVector());
        Assert.assertEquals(new Vector2D(0,-1), MapDirection.SOUTH.toUnitVector());
        Assert.assertEquals(new Vector2D(-1,0), MapDirection.WEST.toUnitVector());
    }
}
