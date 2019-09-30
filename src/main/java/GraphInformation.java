/**
 * Created 2019-09-30 by patrikingverud
 */
public class GraphInformation {

    private final int numberOfNodes;
    private final float eps;
    private final int maxWeight;

    public GraphInformation(int numberOfNodes, float eps, int maxWeight) {
        this.numberOfNodes = numberOfNodes;
        this.eps = eps;
        this.maxWeight = maxWeight;
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public float getEps() {
        return eps;
    }

    public int getMaxWeight() {
        return maxWeight;
    }
}
