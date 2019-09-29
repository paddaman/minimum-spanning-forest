import java.util.List;
import java.util.Random;

/**
 * Created 2019-09-29 by patrikingverud
 */
public class Service {

    public static float getMinimumSpanningTree(int sampleSize, int numberOfNodes, boolean runOnKattis) {
        int sumOfWeights = 0;
        int numEdges = 0;
        Random random = new Random();
        for (int i = 0; i < sampleSize; i++) {
            int node = random.nextInt(sampleSize); //sample a random node

            List<Node> neighbours = Repository.getNeighbours(node, numberOfNodes, runOnKattis); //get the list of neighbors and the corresponding weights

            for (Node neighbour : neighbours) {
                sumOfWeights += neighbour.getWeight();
                numEdges += 1;
            }
        }
        float averageEdgeWeight = 1.0f * sumOfWeights / numEdges;

        //A spanning tree always consists of N-1 edges,
        //so one could think a minimum spanning tree would have roughly the following weight.
        // (Note: This idea is wrong because a MINIMUM spanning tree will try to use only small edges)
        return  averageEdgeWeight * (numberOfNodes-1);
    }
}
