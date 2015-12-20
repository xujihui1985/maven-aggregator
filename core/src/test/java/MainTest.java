import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by sean on 12/20/15.
 */


public class MainTest {

    @Before
    public void prepare() {
        System.out.println("ccccccccc");
    }

    @Test
    public void testHello() {
        assertThat(true, equalTo(true));
    }
}
