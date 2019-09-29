import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created 2019-09-29 by patrikingverud
 */
public class Repository {

    private static final Scanner input = new Scanner(System.in);

    public static List<Node> getNeighbours(int node, int numberOfNodes, boolean runOnKattis) {
        if (runOnKattis) {
            System.out.println(node);
            System.out.flush();

            String[] neighbourStringArray = input.nextLine().split(" ");

            return convertToList(neighbourStringArray);

        } else {
            int leftNeighbour = (node-1) % numberOfNodes;
            int rightNeighbour = (node+1) % numberOfNodes;
            int weight = 1;
            return Arrays.asList(new Node(leftNeighbour, weight), new Node(rightNeighbour, weight));
        }
    }

    private static List<Node> convertToList(String[] neighbourString) {
        List<Node> neighbours = new ArrayList<Node>();
        for (int i = 1; i < neighbourString.length; i = i + 2) {
            neighbours.add(new Node(Integer.parseInt(neighbourString[i]), Integer.parseInt(neighbourString[i+1])));
        }
        return neighbours;
    }
}
