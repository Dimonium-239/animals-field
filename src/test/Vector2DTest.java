import com.gmail.dymitr.kuzmin.Vector2D;

import org.junit.Test;
import org.junit.Assert;

public class Vector2DTest {
    @Test
    public void toStringTest(){
        Assert.assertEquals("(0,0)", new Vector2D(0,0).toString());
        Assert.assertEquals("(1,1)", new Vector2D(1,1).toString());
        Assert.assertEquals("(5,-1)", new Vector2D(5,-1).toString());
    }

    @Test
    public void equalsTest(){
        Assert.assertEquals(new Vector2D(0, 0), new Vector2D(0, 0));
        Assert.assertEquals(new Vector2D(1, 1), new Vector2D(1, 1));
        Assert.assertNotEquals(new Vector2D(5, -1), new Vector2D(-1, 5));
    }

    @Test
    public void precedesTest(){
        Assert.assertTrue(new Vector2D(0, 0).precedes(new Vector2D(0, 1)));
        Assert.assertTrue(new Vector2D(0, 0).precedes(new Vector2D(0, 0)));
        Assert.assertTrue(new Vector2D(0, 0).precedes(new Vector2D(1, 0)));

        Assert.assertFalse(new Vector2D(1, 1).precedes(new Vector2D(0, 1)));
        Assert.assertFalse(new Vector2D(1, 1).precedes(new Vector2D(1, 0)));
        Assert.assertFalse(new Vector2D(1, 1).precedes(new Vector2D(-1, -1)));
    }

    @Test
    public void followsTest(){
        Assert.assertTrue(new Vector2D(1, 1).follows(new Vector2D(0, 1)));
        Assert.assertTrue(new Vector2D(1, 1).follows(new Vector2D(1, 0)));
        Assert.assertTrue(new Vector2D(1, 1).follows(new Vector2D(-1, -1)));

        Assert.assertFalse(new Vector2D(0, 0).follows(new Vector2D(1, 1)));
        Assert.assertFalse(new Vector2D(0, 0).follows(new Vector2D(1, 0)));
        Assert.assertFalse(new Vector2D(0, 0).follows(new Vector2D(0, 1)));
    }

    @Test
    public void upperRightTest(){
        Assert.assertEquals(new Vector2D(1,1), new Vector2D(0,1).upperRight(new Vector2D(1,0)));
        Assert.assertEquals(new Vector2D(1,1), new Vector2D(1,0).upperRight(new Vector2D(0,1)));
        Assert.assertEquals(new Vector2D(1,1), new Vector2D(1,1).upperRight(new Vector2D(1,1)));
        Assert.assertEquals(new Vector2D(1,1), new Vector2D(1,1).upperRight(new Vector2D(0,0)));
    }

    @Test
    public void lowerLeftTest(){
        Assert.assertEquals(new Vector2D(0,0), new Vector2D(0,1).lowerLeft(new Vector2D(1,0)));
        Assert.assertEquals(new Vector2D(0,0), new Vector2D(1,0).lowerLeft(new Vector2D(0,1)));
        Assert.assertEquals(new Vector2D(1,1), new Vector2D(1,1).lowerLeft(new Vector2D(1,1)));
        Assert.assertEquals(new Vector2D(0,0), new Vector2D(1,1).lowerLeft(new Vector2D(0,0)));
    }

    @Test
    public void addTest(){
        Assert.assertEquals(new Vector2D(2,2), new Vector2D(1,1).add(new Vector2D(1,1)));
        Assert.assertEquals(new Vector2D(0,0), new Vector2D(1,-1).add(new Vector2D(-1,1)));
        Assert.assertEquals(new Vector2D(1,1), new Vector2D(0,0).add(new Vector2D(1,1)));
    }

    @Test
    public void subtractTest(){
        Assert.assertEquals(new Vector2D(0,0), new Vector2D(1,1).subtract(new Vector2D(1,1)));
        Assert.assertEquals(new Vector2D(2,-2), new Vector2D(1,-1).subtract(new Vector2D(-1,1)));
        Assert.assertEquals(new Vector2D(-1,-1), new Vector2D(0,0).subtract(new Vector2D(1,1)));
    }

    @Test
    public void oppositeTest(){
        Assert.assertEquals(new Vector2D(-1,-1), new Vector2D(1,1).opposite());
        Assert.assertEquals(new Vector2D(0,0), new Vector2D(0,0).opposite());
        Assert.assertEquals(new Vector2D(1,1), new Vector2D(-1,-1).opposite());
    }
}
