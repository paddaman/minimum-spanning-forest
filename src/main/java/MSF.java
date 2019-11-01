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
        float forestComponents = 0f;
        for (int i = 1; i < graphInformation.getMaxWeight(); i++) {
            components = components + estimateComponentSize(runOnKattis, graphInformation, componentSize, numberOfRandomNodes, i);
            //forestComponents+= (estimateComponentSize(runOnKattis, graphInformation, componentSize, (int)4*numberOfRandomNodes, graphInformation.getMaxWeight()));
        }
        components = components - (graphInformation.getMaxWeight() * (estimateComponentSize(runOnKattis, graphInformation, componentSize, (int)4*numberOfRandomNodes, graphInformation.getMaxWeight()) - 1));
        //components = components - (graphInformation.getMaxWeight() * (forestComponents/(graphInformation.getMaxWeight()-1)));
        return graphInformation.getNumberOfNodes() - graphInformation.getMaxWeight() + components;

    }

    float estimateComponentSize(boolean runOnKattis, GraphInformation graphInformation, int componentSize, int numberOfRandomNodes, int edgeWeight) {
        int b = 0;
        for (int i = 0; i < numberOfRandomNodes; i++) {
            int startNode = service.getRandom(graphInformation.getNumberOfNodes());
            componentSize = (int) Math.floor(1f/service.getRandomDouble());
            int count = breadthFirstSearch(runOnKattis, graphInformation, componentSize, edgeWeight, startNode);
            if (count <= componentSize) {
                b++;
            }
        }
        //System.out.println(((float) graphInformation.getNumberOfNodes() / numberOfRandomNodes) * b);
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

    int breadthFirstSearch2(boolean runOnKattis, GraphInformation graphInformation, int componentSize, int edgeWeight, int startNode) {
        List<Node> nodes = service.getNeighbours(runOnKattis, graphInformation, startNode);
        int count = 1;
        for (Node node : nodes) {
            if (node.getWeight() <= edgeWeight) {
                count++;
            }
        }
        return count;
    }

    private float getP(int edgeWeight) {
        return (float) Math.pow(1f / edgeWeight, 1f / edgeWeight);
    }

    private int getX(float prob, int edges) {
        return Math.round(prob * edges) == 1 ? Math.round(prob * edges) + 1 : Math.round(prob * edges);
    }

}
