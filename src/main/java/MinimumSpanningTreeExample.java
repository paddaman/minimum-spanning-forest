class MinimumSpanningTreeExample {

    private static final boolean runOnKattis = true;

    public static void main(String args[]) {

        Service service = new Service(new Repository());

        MSF msf = new MSF(new Repository());

        GraphInformation graphInformation = service.getGraphInformation(runOnKattis);
        int componentSize = 4 * graphInformation.getMaxWeight();
        int sampleSize = (int) ((16 * Math.pow(graphInformation.getMaxWeight(), 2)) / Math.pow(graphInformation.getEps(), 2));
        float result = msf.approximateWeight(graphInformation, componentSize, sampleSize);

        //print the answer
        System.out.println("end "+ result);
        System.out.flush();
    }

}