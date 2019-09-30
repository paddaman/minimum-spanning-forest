import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created 2019-09-29 by patrikingverud
 */
public class Repository {

    private static final Scanner input = new Scanner(System.in);


    private static int numberOfNodes = 21000000;
    private static float eps = 0.1f;
    private static int maxWeight = 3;

    public static GraphInformation getGraphInformation() {
        numberOfNodes = Integer.parseInt(input.nextLine());
        eps = Float.parseFloat(input.nextLine()) - 1.0f;
        maxWeight = Integer.parseInt(input.nextLine());
        return new GraphInformation(numberOfNodes, eps, maxWeight);
    }

    public static GraphInformation getMockedGraphInformation() {
        return new GraphInformation(numberOfNodes, eps, maxWeight);
    }

    public static List<Node> getNeighbours(int node) {

        System.out.println(node);
        System.out.flush();

        String[] neighbourStringArray = input.nextLine().split(" ");

        return convertToList(neighbourStringArray);

    }

    public static List<Node> getMockedNeighbours(int node, int numberOfNodes) {

        int leftNeighbour = (node - 1) % numberOfNodes;
        int rightNeighbour = (node + 1) % numberOfNodes;
        int weight = 1;
        return Arrays.asList(new Node(leftNeighbour, weight), new Node(rightNeighbour, weight));
    }

    private static List<Node> convertToList(String[] neighbourStringArray) {
        List<Node> neighbours = new ArrayList<Node>();
        for (int i = 1; i < neighbourStringArray.length; i = i + 2) {
            neighbours.add(new Node(Integer.parseInt(neighbourStringArray[i]), Integer.parseInt(neighbourStringArray[i + 1])));
        }
        return neighbours;
    }
}
