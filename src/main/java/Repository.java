import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created 2019-09-29 by patrikingverud
 */
public class Repository {

    private static final Scanner input = new Scanner(System.in);
    private static final Random random = new Random();

    private static final int NUMBER_OF_NODES = 1000;
    private static final float EPS = 0.1f;
    private static final int MAX_WEIGHT = 3;

    public GraphInformation getGraphInformation() {
        int numberOfNodes = Integer.parseInt(input.nextLine());
        float eps = Float.parseFloat(input.nextLine()) - 1.0f;
        int maxWeight = Integer.parseInt(input.nextLine());
        return new GraphInformation(numberOfNodes, eps, maxWeight);
    }

    public GraphInformation getMockedGraphInformation() {
        return new GraphInformation(NUMBER_OF_NODES, EPS, MAX_WEIGHT);
    }

    public List<Node> getNeighbours(int node) {

        System.out.println(node);
        System.out.flush();

        String[] neighbourStringArray = input.nextLine().split(" ");

        return convertToList(neighbourStringArray);

    }

    public List<Node> getMockedNeighbours(int node, GraphInformation graphInformation) {

        int leftNeighbour = (node - 1) % graphInformation.getNumberOfNodes();
        int rightNeighbour = (node + 1) % graphInformation.getNumberOfNodes();
        int weight = getRandom(graphInformation.getMaxWeight()) + 1;
        /*if (weight < 6) {
            weight++;
        }*/
        //System.out.println(weight);
        return Arrays.asList(new Node(leftNeighbour, weight), new Node(rightNeighbour, weight));
    }

    List<Node> convertToList(String[] neighbourStringArray) {
        if (neighbourStringArray.length > 1) {
            List<Node> neighbours = new ArrayList<Node>();
            for (int i = 1; i < neighbourStringArray.length; i = i + 2) {
                neighbours.add(new Node(Integer.parseInt(neighbourStringArray[i]), Integer.parseInt(neighbourStringArray[i + 1])));
            }
            return neighbours;
        } else {
            return Collections.emptyList();
        }
    }

    public int getRandom(int maxNumberOfNodes) {
        return random.nextInt(maxNumberOfNodes);
    }

    public double getRandomDouble() {
        return random.nextDouble();
    }
}
