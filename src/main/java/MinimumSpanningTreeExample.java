class MinimumSpanningTreeExample {

    private static final boolean runOnKattis = true;

    private static final int SAMPLE_SIZE = 100;


    public static void main(String args[]) {

        Service service = new Service(new Repository());

        GraphInformation graphInformation = service.getGraphInformation(runOnKattis);

        float result = service.getMinimumSpanningTree(runOnKattis, SAMPLE_SIZE, graphInformation);

        //print the answer
        System.out.println("end "+ result);
        System.out.flush();
    }

}