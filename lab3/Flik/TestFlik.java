import static org.junit.Assert.*;

import org.junit.Test;

public class TestFlik {

    @Test
    public void testIsSameNumber() {
        int i = 128;
        int j = 128;
        assertEquals(true, Flik.isSameNumber(i, j));
    }
}