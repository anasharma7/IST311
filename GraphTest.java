/*import static org.junit.Assert.*;

import org.junit.Test;

public class GraphTest {

    @Test
    public void testAddVertex() {
        Graph graph = new Graph();
        Vertex vertex = new Vertex("A");
        graph.addVertex("A");
        assertEquals(vertex, graph.getVertex("A"));
    }
    @Test
    public void testAddEdge() {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        Edge edge = new Edge(graph.getVertex("A"), graph.getVertex("B"), 5.0);
        graph.addEdge(edge);
        assertTrue(graph.getVertex("A").getEdges().contains(edge));
        assertTrue(graph.getVertex("B").getEdges().contains(edge));
    }


    @Test
    public void testRemoveVertex() {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        Edge edge = new Edge(graph.getVertex("A"), graph.getVertex("B"), 0);
        graph.addEdge(edge);
        graph.removeVertex("A");
        assertNull(graph.getVertex("A"));
        assertFalse(graph.getVertex("B").getEdges().contains(edge));
    }


    @Test
    public void testRemoveEdge() {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        Edge edge = new Edge(graph.getVertex("A"), graph.getVertex("B"), 15.0);
        graph.addEdge(edge);
        graph.removeEdge("A", "B");
        assertFalse(graph.getVertex("A").getEdges().contains(edge));
        assertFalse(graph.getVertex("B").getEdges().contains(edge));
    }

    @Test
    public void testGetIndex() {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        Vertex vertexA = graph.getVertex("A");
        Vertex vertexB = graph.getVertex("B");
        Vertex vertexC = graph.getVertex("C");
        assertEquals(0, graph.getIndex(vertexA));
        assertEquals(1, graph.getIndex(vertexB));
        assertEquals(2, graph.getIndex(vertexC));
    }
}*/
