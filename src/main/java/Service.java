import java.util.List;
import java.util.Random;

/**
 * Created 2019-09-29 by patrikingverud
 */
public class Service {

    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public GraphInformation getGraphInformation(boolean runOnKattis) {
        if (runOnKattis) {
            return repository.getGraphInformation();
        } else {
            return repository.getMockedGraphInformation();
        }
    }

    public float getMinimumSpanningTree(boolean runOnKattis, int sampleSize, GraphInformation graphInformation) {
        int sumOfWeights = 0;
        int numEdges = 0;
        Random random = new Random();
        for (int i = 0; i < sampleSize; i++) {
            int node = random.nextInt(sampleSize); //sample a random node

            List<Node> neighbours = getNeighbours(runOnKattis, graphInformation, node);

            for (Node neighbour : neighbours) {
                sumOfWeights += neighbour.getWeight();
                numEdges += 1;
            }
        }
        float averageEdgeWeight = 1.0f * sumOfWeights / numEdges;

        //A spanning tree always consists of N-1 edges,
        //so one could think a minimum spanning tree would have roughly the following weight.
        // (Note: This idea is wrong because a MINIMUM spanning tree will try to use only small edges)
        return averageEdgeWeight * (graphInformation.getNumberOfNodes() - 1);
    }

    public List<Node> getNeighbours(boolean runOnKattis, GraphInformation graphInformation, int node) {
        if (runOnKattis) {
            return repository.getNeighbours(node); //get the list of neighbors and the corresponding weights
        } else {
            return repository.getMockedNeighbours(node, graphInformation.getNumberOfNodes());
        }
    }

    public int getRandom(int maxNumberOfNodes) {

        return repository.getRandom(maxNumberOfNodes); //get the list of neighbors and the corresponding weights

    }
}
