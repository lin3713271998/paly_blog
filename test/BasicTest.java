import org.junit.*;
import java.util.*;
import play.test.*;

public class  BasicTest extends UnitTest {
    @Before
        public void setup(){
        Fixtures.deleteAllModels();
    }
    @Test
    public void aVeryImportantThingToTest() {
        assertEquals(2, 1 + 1);
    }

}
