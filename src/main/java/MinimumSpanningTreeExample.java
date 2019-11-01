class MinimumSpanningTreeExample {

    private static final boolean runOnKattis = true;

    public static void main(String args[]) {

        Service service = new Service(new Repository());

        MSF msf = new MSF(service);

        GraphInformation graphInformation = service.getGraphInformation(runOnKattis);
        int componentSize = 1;
        int sampleSize = (int) (1.2*graphInformation.getMaxWeight()/ Math.pow(graphInformation.getEps(), 2));
        float result = msf.approximateWeight(runOnKattis, graphInformation, componentSize, sampleSize);
        //int A = 24;
        //int betterSampleSize = (int)Math.round(A/graphInformation.getEps()+Math.round(result)*A/(Math.pow(graphInformation.getEps(), 2)*graphInformation.getNumberOfNodes()));
        //float betterResult = msf.approximateWeight(runOnKattis, graphInformation, componentSize, betterSampleSize);
        //print the answer
        System.out.println("end " + result);
        System.out.flush();

    }

}