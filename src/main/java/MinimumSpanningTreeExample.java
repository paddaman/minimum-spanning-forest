import java.util.Scanner;

class MinimumSpanningTreeExample {

    private static final boolean runOnKattis = true;

    private static final Scanner input = new Scanner(System.in);
    private static final int SAMPLE_SIZE = 100;

    private static int numberOfNodes = 21000000;
    private static float eps = 0.1f;
    private static int maxWeight = 3;

    public static void main(String args[]) {
        if (runOnKattis) {
            setup();
        }

        float result = Service.getMinimumSpanningTree(SAMPLE_SIZE, numberOfNodes, runOnKattis);

        //print the answer
        System.out.println("end "+ result);
        System.out.flush();
    }

    private static void setup() {
        numberOfNodes = input.nextInt();
        eps = input.nextFloat() - 1.0f;
        maxWeight = input.nextInt();
    }
}