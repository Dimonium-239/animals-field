import com.gmail.dymitr.kuzmin.Animal;

import com.gmail.dymitr.kuzmin.MoveDirection;
import org.junit.Test;
import org.junit.Assert;

public class AnimalTest {

    @Test
    public void toStringTest(){
        Assert.assertEquals("[(2,2), North]", new Animal().toString());
    }

    @Test
    public void moveTest() {
        Animal anTest = new Animal();

        anTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("[(2,3), North]", anTest.toString());

        anTest.move(MoveDirection.RIGHT);
        Assert.assertEquals("[(2,3), East]", anTest.toString());

        anTest.move(MoveDirection.FORWARD);
        anTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("[(4,3), East]", anTest.toString());

        anTest.move(MoveDirection.FORWARD);
        Assert.assertEquals("[(4,3), East]", anTest.toString());

        anTest.move(MoveDirection.BACKWARD);
        Assert.assertEquals("[(3,3), East]", anTest.toString());
    }
}
