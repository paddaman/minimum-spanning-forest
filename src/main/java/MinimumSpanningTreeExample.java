class MinimumSpanningTreeExample {

    private static final boolean runOnKattis = false;

    public static void main(String args[]) {

        Service service = new Service(new Repository());

        MSF msf = new MSF(service);

        GraphInformation graphInformation = service.getGraphInformation(runOnKattis);
        int componentSize = graphInformation.getMaxWeight()*10;
        int sampleSize = graphInformation.getMaxWeight()*4;
        for (int i = 0; i < 20; i++) {
            float result = msf.approximateWeight(runOnKattis, graphInformation, componentSize, sampleSize);

            //print the answer
            System.out.println("end " + result);
            System.out.flush();
        }
    }

}