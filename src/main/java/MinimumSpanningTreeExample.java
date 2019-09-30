import java.util.Scanner;

class MinimumSpanningTreeExample {

    private static final boolean runOnKattis = true;

    private static final int SAMPLE_SIZE = 100;


    public static void main(String args[]) {

        GraphInformation graphInformation = Service.getGraphInformation(runOnKattis);

        float result = Service.getMinimumSpanningTree(runOnKattis, SAMPLE_SIZE, graphInformation);

        //print the answer
        System.out.println("end "+ result);
        System.out.flush();
    }

}