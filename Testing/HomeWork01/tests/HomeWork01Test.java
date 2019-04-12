import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeWork01Test {

    @Test
    void main() {

    }
    HomeWork01 home = new HomeWork01();
    @Test
    public void sumworks() {

        assertEquals(home.sum(2,5), 7);
    }
    @Test
    public void ifElseWorkingSmaller() {
        home.setZ(9);
        home.setK(5);
        assertFalse(home.getZ() < home.getK());
    }
    @Test
    public void ifElseWorkingBigger() {
        home.setZ(9);
        home.setK(5);
        assertFalse(home.getK() < home.getZ());
    }
    @Test
    public void Equal() {
        home.setZ(5);
        home.setK(5);
        assertTrue(home.getK() == home.getZ());
    }
}