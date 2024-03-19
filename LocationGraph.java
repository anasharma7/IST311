import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;




public class LocationGraph {
    private Map<String, Location> vertices;

    public LocationGraph() {
        vertices = new HashMap<>();
    }

    public boolean AddLocation(String location) {
        Location vertex = new Location(location);
        if (vertices.containsValue(vertex)) {
            System.out.println("Location already exists! Unable to add location");
            return false;
        } else {
            vertices.put(location, vertex);
            return true;
        }
    }

    public boolean AddDistance(String locationA, String locationB, Double distance) {
        if (locationA.equals(locationB)) {
            System.out.println("Cannot add distance between the same location.");
            return false;
        }
        if (!vertices.containsKey(locationA)) {
            AddLocation(locationA);
        }
        if (!vertices.containsKey(locationB)) {
            AddLocation(locationB);
        }
        if (vertices.get(locationA).hasEdge(vertices.get(locationB)) || vertices.get(locationB).hasEdge(vertices.get(locationA))) {
            System.out.println("Connection between the locations already exists!");
            return false;
        } else {
            vertices.get(locationA).addEdge(new Distance(vertices.get(locationB), distance));
            vertices.get(locationB).addEdge(new Distance(vertices.get(locationA), distance));
            return true;
        }
    }

    public Double findDistanceBF(String locationA, String locationB) {
        Map<String, Boolean> visited = new HashMap<>();
        for (Location l : vertices.values()) {
            visited.put(l.getLabel(), false);
        }
        LinkedList<String> queue = new LinkedList<String>();
        double total = 0;

        visited.replace(locationA, true);
        queue.add(locationA);

        while (queue.size() != 0) {
            locationA = queue.poll();
            System.out.println(locationA + " ");

            Iterator<Distance> i = vertices.get(locationA).getEdges().listIterator();
            while (i.hasNext()) {
                Distance next = i.next();
                if (next.getvertex().getLabel().equals(locationB)) {
                    total = total + next.getWeight();
                    return total;
                } else if (!visited.get(next.getvertex().getLabel())) {
                    total = total + next.getWeight();
                    visited.replace(next.getvertex().getLabel(), true);
                    queue.add(next.getvertex().getLabel());
                }
            }
        }
        System.out.println("A path could not be established");
        return null;
    }

    public Double DFUtil(String locationA, String locationB, Map<String, Boolean> visited) {
        visited.replace(locationA, true);
        System.out.println(locationA + " ");

        return null;
    }

    public boolean addLocation(String location) {
        Location vertex = new Location(location);
        if (vertices.containsKey(location)) {
            System.out.println("Location already exists! Unable to add location");
            return false;
        } else {
            vertices.put(location, vertex);
            return true;
        }
    }
    public void addDistance(String location1, String location2, double distance) {
        Location loc1 = getLocation(location1);
        Location loc2 = getLocation(location2);
        if (loc1 != null && loc2 != null) {
            Distance dist = new Distance(loc1, loc2, distance);
            loc1.addEdge(dist);
            loc2.addEdge(dist);
        }
    }
    public boolean detectCycle() {
        // Perform a depth-first search on each location
        Set<Location> visited = new HashSet<>();
        Set<Location> inProcess = new HashSet<>();
        for (Location location : locations.values()) {
            if (dfs(location, visited, inProcess)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(Location location, Set<Location> visited, Set<Location> inProcess) {
        if (inProcess.contains(location)) {
            // We have found a cycle
            return true;
        }
        if (visited.contains(location)) {
            // We have already visited this location and found no cycles
            return false;
        }
        // Mark the location as being processed
        inProcess.add(location);
        // Recurse on all neighbors
        for (Distance distance : location.getEdges()) {
            if (dfs(distance.getTo(), visited, inProcess)) {
                return true;
            }
        }
        // We have finished processing this location without finding a cycle
        visited.add(location);
        inProcess.remove(location);
        return false;
    }

}
