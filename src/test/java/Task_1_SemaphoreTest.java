import com.epam.func.task1.Semaphore;
import com.epam.func.task1.SemaphoreColor;
import org.junit.Assert;
import org.junit.Test;

public class Task_1_SemaphoreTest {
    @Test
    public void testOk1() {
        Assert.assertEquals(SemaphoreColor.RED, new Semaphore().getSemLightColor("7"));
    }

    @Test
    public void testOk2() {
        Assert.assertEquals(SemaphoreColor.YELLOW, new Semaphore().getSemLightColor("327"));
    }

    @Test
    public void testOk3() {
        Assert.assertEquals(SemaphoreColor.GREEN, new Semaphore().getSemLightColor("173"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeParameter() {
        new Semaphore().getSemLightColor("-6");
    }

    @Test(expected = IllegalArgumentException.class)
    public void textParameter() {
        new Semaphore().getSemLightColor("wrong_arg");
    }
}
