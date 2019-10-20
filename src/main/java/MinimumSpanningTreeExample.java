class MinimumSpanningTreeExample {

    private static final boolean runOnKattis = true;

    public static void main(String args[]) {

        Service service = new Service(new Repository());

        MSF msf = new MSF(service);

        GraphInformation graphInformation = service.getGraphInformation(runOnKattis);
        int componentSize = 1;
        int sampleSize = (int) (16 * Math.pow(graphInformation.getMaxWeight(), 3) / Math.pow(graphInformation.getEps()+1f, 2));
        float result = msf.approximateWeight(runOnKattis, graphInformation, componentSize, sampleSize);

        //print the answer
        System.out.println("end " + result);
        System.out.flush();

    }

}