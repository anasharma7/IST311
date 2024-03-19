public class Distance {
    private Location vertex;
    private double weight;

    public Distance(Location vertex, double weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public Location getvertex() {
        return vertex;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isConnectedTo(Location v) {
        return vertex.equals(v);
    }

    public Location getConnectedVertex(Location v) {
        if (vertex.equals(v)) {
            return v;
        } else {
            throw new IllegalArgumentException("Edge is not connected to vertex");
        }
    }


    public Location getTo() {
        return vertex;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}