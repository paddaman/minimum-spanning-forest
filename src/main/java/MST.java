import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by patrik.ingverud on 2019-10-02.
 */
public class MST {

    private static final int X = 5;
    private static final int NUMBER_OF_RANDOM_NODES = 5;

    private Repository repository;

    public MST(Repository repository) {
        this.repository = repository;
    }

    public int approximateWeight(GraphInformation graphInformation) {
        int components = 0;
        for (int i = 0; i < graphInformation.getMaxWeight(); i++) {
            components =+ estimateComponents(graphInformation, i);
        }
        return components;
    }

    private int estimateComponents(GraphInformation graphInformation, int edgeWeight) {
        int x = 0;
        for (int i = 0; i < NUMBER_OF_RANDOM_NODES; i++) {
            int startNode = repository.getRandom(graphInformation.getMaxWeight());
            int count = breadthFirstSearch(X, edgeWeight, startNode);
            if (count == X) {
                return x++;
            } else {
                return 0;
            }
        }
        return x;
    }

    int breadthFirstSearch(int componentSize, int edgeWeight, int startNode) {
        Queue<Integer> subGraph = new LinkedList<>();
        List<Node> nodes = repository.getNeighbours(startNode);
        Set<Integer> visited = new HashSet<>();
        subGraph.add(startNode);
        visited.add(startNode);
        int count = 1;
        int num = 0;
        while (!subGraph.isEmpty() && count < componentSize) {
            startNode = subGraph.poll();

            for (Node node : nodes) {
                int nextNode = node.getNumber();
                if (!visited.contains(nextNode) && node.getWeight() <= edgeWeight && count < componentSize){
                    visited.add(nextNode);
                    subGraph.add(nextNode);
                    count++;
                    num++;
                }
            }
            if (isAtLeastOneMoreIteration(componentSize, num) && hasMoreNodesToVisit(subGraph)) {
                num = 0;
                nodes = repository.getNeighbours(nodes.get(num).getNumber());
            }
        }
        return count;
    }

    private boolean hasMoreNodesToVisit(Queue<Integer> subGraph) {
        return subGraph.poll() != null;
    }

    private boolean isAtLeastOneMoreIteration(int componentSize, int j) {
        return j < (componentSize - 1);
    }

}
