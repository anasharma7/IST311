import java.util.*;

public class Location {
    private String label;
    private List<Distance> edges;

    public Location(String label) {
        this.label = label;
        edges = new ArrayList<>();
    }

    public String getLabel() {
        return label;
    }

    public void addEdge(Distance edge) {
        edges.add(edge);
    }

    public void removeEdge(Distance edge) {
        edges.remove(edge);
    }

    public List<Distance> getEdges() {
        return edges;
    }

    public boolean hasEdge(Location vertex) {
        for (Distance edge : edges) {
            if (edge.isConnectedTo(vertex)) {
                return true;
            }
        }
        return false;
    }

    /*@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Edge edge : edges) {
            sb.append(edge).append(", ");
        }
        return sb.length() > 0 ? sb.toString().substring(0, sb.length() - 2) : "";
    }*/
}
