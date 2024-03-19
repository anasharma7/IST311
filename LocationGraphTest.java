import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationGraphTest {

    @Test
    void addLocation() {
        LocationGraph graph = new LocationGraph();
        assertTrue(graph.addLocation("New York"));
        assertFalse(graph.addLocation("New York")); // Try adding the same location again
    }

    @Test
    void addDistance() {
        LocationGraph graph = new LocationGraph();
        graph.AddLocation("New York");
        graph.AddLocation("Los Angeles");
        assertTrue(graph.AddDistance("New York", "Los Angeles", 2790.0));
        assertFalse(graph.AddDistance("New York", "Los Angeles", 2000.0)); // Try adding the same distance again
        assertFalse(graph.AddDistance("New York", "Chicago", 800.0)); // Try adding distance between non-existent locations
    }


    @Test
    void findDistanceBF() {
        LocationGraph graph = new LocationGraph();
        graph.addLocation("New York");
        graph.addLocation("Los Angeles");
        graph.addLocation("Chicago");
        graph.addDistance("New York", "Los Angeles", 2790.0);
        graph.addDistance("New York", "Chicago", 800.0);
        assertEquals(2790.0, graph.findDistanceBF("New York", "Los Angeles"));
        assertEquals(800.0, graph.findDistanceBF("New York", "Chicago"));
        assertNull(graph.findDistanceBF("Los Angeles", "Chicago")); // Try finding distance between non-connected locations
        assertNull(graph.findDistanceBF("New York", "Miami")); // Try finding distance between non-existent locations
    }


    @Test
    void testFindDistanceBF() {
        LocationGraph graph = new LocationGraph();
        graph.addLocation("New York");
        graph.addLocation("Los Angeles");
        graph.addLocation("Chicago");
        graph.addDistance("New York", "Los Angeles", 2790.0);
        graph.addDistance("New York", "Chicago", 800.0);
        assertEquals(2790.0, graph.findDistanceBF("New York", "Los Angeles"));
        assertEquals(800.0, graph.findDistanceBF("New York", "Chicago"));
        assertNull(graph.findDistanceBF("Los Angeles", "Chicago")); // Try finding distance between non-connected locations
        assertNull(graph.findDistanceBF("New York", "Miami")); // Try finding distance between non-existent locations
    }

    @Test
    void detectCycle() {
        LocationGraph graph = new LocationGraph();
        graph.addLocation("New York");
        graph.addLocation("Los Angeles");
        graph.addLocation("Chicago");
        graph.addDistance("New York", "Los Angeles", 2790.0);
        assertFalse(graph.detectCycle()); // Try detecting cycle in a non-cyclic graph
        graph.addDistance("Los Angeles", "Chicago", 2011.0);
        graph.addDistance("Chicago", "New York", 787.0);
        assertTrue(graph.detectCycle()); // Try detecting cycle in a cyclic graph
    }
}




