/*import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VertexTest {

    @Test
    public void testAddEdge() {
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");

        Edge edgeAB = new Edge(vertexA, vertexB, 10.0);
        Edge edgeAC = new Edge(vertexA, vertexC, 15.0);

        vertexA.addEdge(edgeAB);
        vertexA.addEdge(edgeAC);

        assertTrue(vertexA.getEdges().contains(edgeAB));
        assertTrue(vertexA.getEdges().contains(edgeAC));
    }

    @Test
    public void testRemoveEdge() {
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Edge edgeAB = new Edge(vertexA, vertexB, 10.0);

        vertexA.addEdge(edgeAB);
        vertexA.removeEdge(edgeAB);

        assertFalse(vertexA.getEdges().contains(edgeAB));
    }

    @Test
    public void testToString() {
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");

        Edge edgeAB = new Edge(vertexA, vertexB, 10.0);
        Edge edgeAC = new Edge(vertexA, vertexC, 15.0);

        vertexA.addEdge(edgeAB);
        vertexA.addEdge(edgeAC);

        String expectedString = "[A, B, 10.0], [A, C, 15.0]";
        assertEquals(expectedString, vertexA.toString());
    }
}*/
