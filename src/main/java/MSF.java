import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by patrik.ingverud on 2019-10-02.
 */
public class MSF {

    private Repository repository;

    public MSF(Repository repository) {
        this.repository = repository;
    }

    public float approximateWeight(GraphInformation graphInformation, int componentSize, int numberOfRandomNodes) {
        float components = 0f;
        for (int i = 0; i < graphInformation.getMaxWeight(); i++) {
            components =+ estimateComponents(graphInformation, componentSize, numberOfRandomNodes, i);
        }
        components -= graphInformation.getMaxWeight()*(estimateComponents(graphInformation, componentSize, numberOfRandomNodes, graphInformation.getMaxWeight())-1);
        return graphInformation.getNumberOfNodes() - graphInformation.getMaxWeight() + components;
    }

    private float estimateComponents(GraphInformation graphInformation, int componentSize, int numberOfRandomNodes, int edgeWeight) {
        int b = 0;
        for (int i = 0; i < numberOfRandomNodes; i++) {
            int startNode = repository.getRandom(graphInformation.getMaxWeight());
            int count = breadthFirstSearch(componentSize, edgeWeight, startNode);
            if (count == componentSize) {
                b++;
            }
        }
        return ((float) graphInformation.getNumberOfNodes()/numberOfRandomNodes)*b;
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
