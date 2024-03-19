import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class LocationTest {

    @Test
    public void testAddAndGetEdges() {
        Location locationA = new Location("A");
        Location locationB = new Location("B");
        Distance distanceAB = new Distance(locationA, locationB, 5.0);
        locationA.addEdge(distanceAB);

        List<Distance> expectedEdges = new ArrayList<>();
        expectedEdges.add(distanceAB);

        List<Distance> actualEdges = locationA.getEdges();
        assertEquals(expectedEdges, actualEdges);
    }


    @Test
    public void testRemoveEdge() {
        Location locationA = new Location("A");
        Location locationB = new Location("B");
        Distance distanceAB = new Distance(locationA, locationB, 5.0);
        locationA.addEdge(distanceAB);
        locationA.removeEdge(distanceAB);

        List<Distance> expectedEdges = new ArrayList<>();

        List<Distance> actualEdges = locationA.getEdges();
        assertEquals(expectedEdges, actualEdges);
    }

    @Test
    public void testHasEdge() {
        Location locationA = new Location("A");
        Location locationB = new Location("B");
        Location locationC = new Location("C");
        Distance distanceAB = new Distance(locationA, locationB, 5.0);
        Distance distanceAC = new Distance(locationA, locationC, 2.0);
        locationA.addEdge(distanceAB);
        locationA.addEdge(distanceAC);

        assertTrue(locationA.hasEdge(locationB));
        assertFalse(locationB.hasEdge(locationC));
    }
}
