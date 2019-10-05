class MinimumSpanningTreeExample {

    private static final boolean runOnKattis = true;

    private static final int SAMPLE_SIZE = 100;
    private static final int COMPONENT_SIZE = 50;


    public static void main(String args[]) {

        Service service = new Service(new Repository());

        MSF msf = new MSF(new Repository());

        GraphInformation graphInformation = service.getGraphInformation(runOnKattis);

        float result = msf.approximateWeight(graphInformation, COMPONENT_SIZE, SAMPLE_SIZE);

        //print the answer
        System.out.println("end "+ result);
        System.out.flush();
    }

}