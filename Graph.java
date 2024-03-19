import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<String, Location> vertices;

    public Graph() {
        vertices = new HashMap<>();
    }

    public void addVertex(String label) {
        Location vertex = new Location(label);
        vertices.putIfAbsent(label, vertex);
    }

    public void addEdge(Distance edge) {
        Location vertex = edge.getTo();

        if (!vertices.containsValue(vertex)) {
            throw new IllegalArgumentException("Vertex does not exist.");
        }
        vertex.addEdge(edge);
    }


    public void removeVertex(String label) {
        Location removedVertex = vertices.remove(label);
        if (removedVertex != null) {
            removedVertex.getEdges().forEach(edge -> {
                Location connectedVertex = edge.getConnectedVertex(removedVertex);
                connectedVertex.removeEdge(edge);
            });
        }
    }

    public void removeEdge(String label1, String label2) {
        Location vertex1 = vertices.get(label1);
        Location vertex2 = vertices.get(label2);
        if (vertex1 == null || vertex2 == null) {
            throw new IllegalArgumentException("One or both vertices do not exist.");
        }
        Distance edgeToRemove = vertex1.getEdges().stream()
                .filter(edge -> edge.isConnectedTo(vertex2))
                .findFirst()
                .orElse(null);
        if (edgeToRemove != null) {
            vertex1.removeEdge(edgeToRemove);
            vertex2.removeEdge(edgeToRemove);
        }
    }

    public List<Location> getVertices() {
        return new ArrayList<>(vertices.values());
    }

    public Location getVertex(String label) {
        return vertices.get(label);
    }

    public int getIndex(Location vertex) {
        int index = -1;
        int i = 0;
        for (Location v : vertices.values()) {
            if (v.equals(vertex)) {
                index = i;
                break;
            }
            i++;
        }
        return index;
    }
}