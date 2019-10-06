import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by patrik.ingverud on 2019-10-02.
 */
public class MSF {

    private Service service;

    public MSF(Service service) {
        this.service = service;
    }

    public float approximateWeight(boolean runOnKattis, GraphInformation graphInformation, int componentSize, int numberOfRandomNodes) {
        float components = 0f;
        for (int i = 1; i < graphInformation.getMaxWeight(); i++) {
            components = components + estimateComponentSize(runOnKattis, graphInformation, componentSize, numberOfRandomNodes, i);
        }
        components = components - graphInformation.getMaxWeight() * (estimateComponentSize(runOnKattis, graphInformation, componentSize, numberOfRandomNodes, graphInformation.getMaxWeight()) - 1);
        return graphInformation.getNumberOfNodes() - graphInformation.getMaxWeight() + components;

    }

    float estimateComponentSize(boolean runOnKattis, GraphInformation graphInformation, int componentSize, int numberOfRandomNodes, int edgeWeight) {
        int b = 0;
        for (int i = 0; i < numberOfRandomNodes; i++) {
            int startNode = service.getRandom(graphInformation.getNumberOfNodes());
            int count = breadthFirstSearch(runOnKattis, graphInformation, componentSize, edgeWeight, startNode);
            if (count <= componentSize) {
                b++;
            }
        }
        return ((float) graphInformation.getNumberOfNodes() / numberOfRandomNodes) * b;
    }

    int breadthFirstSearch(boolean runOnKattis, GraphInformation graphInformation, int componentSize, int edgeWeight, int startNode) {
        Queue<List<Node>> subGraph = new LinkedList<>();
        List<Node> nodes = service.getNeighbours(runOnKattis, graphInformation, startNode);
        Set<Integer> visited = new HashSet<>();
        subGraph.add(nodes);
        visited.add(startNode);
        int count = 1;
        while (!subGraph.isEmpty() && count <= componentSize) {
            nodes = subGraph.poll();

            for (Node node : nodes) {
                startNode = node.getNumber();
                if (!visited.contains(startNode) && node.getWeight() <= edgeWeight && count <= componentSize) {
                    visited.add(startNode);
                    subGraph.add(service.getNeighbours(runOnKattis, graphInformation, startNode));
                    count++;
                }
            }
        }
        return count;
    }

}
