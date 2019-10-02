public class Edge {

    public final int weight;
    public final int node1;
    public final int node2;

    public Edge(int weight, int node1, int node2) {
        this.weight = weight;
        this.node1 = node1;
        this.node2 = node2;
    }

    public int getWeight() {
        return weight;
    }
}
