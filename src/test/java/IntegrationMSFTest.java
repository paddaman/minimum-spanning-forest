import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created 2019-10-06 by patrikingverud
 */
public class IntegrationMSFTest {

    private Repository repository = new Repository();
    private Service service = new Service(repository);
    private MSF minimumSpanningForest = new MSF(service);

    @Test
    public void expectedWeightIs_1000() {
        GraphInformation graphInformation = new GraphInformation(1000, 0.1f, 1);
        int componentSize = 1;
        int sampleSize = graphInformation.getNumberOfNodes();
        float result = minimumSpanningForest.approximateWeight(false, graphInformation, componentSize, sampleSize);
        float expectedValue = getExpectedWeight(graphInformation.getNumberOfNodes(), graphInformation.getMaxWeight());
        System.out.println("Component size: " + componentSize);
        System.out.println("Expected: " + expectedValue);
        System.out.println("Result: " + result);
        assertEquals(expectedValue, result, expectedValue * graphInformation.getEps());
    }

    @Test
    public void expectedWeightIs_1500() {
        GraphInformation graphInformation = new GraphInformation(1000, 0.1f, 2);
        int componentSize = 1;
        int sampleSize = graphInformation.getNumberOfNodes();
        float result = minimumSpanningForest.approximateWeight(false, graphInformation, componentSize, sampleSize);
        float expectedValue = getExpectedWeight(graphInformation.getNumberOfNodes(), graphInformation.getMaxWeight());
        System.out.println("Component size: " + componentSize);
        System.out.println("Expected: " + expectedValue);
        System.out.println("Result: " + result);
        assertEquals(expectedValue, result, expectedValue * graphInformation.getEps());
    }

    @Test
    public void expectedWeightIs_2000() {
        GraphInformation graphInformation = new GraphInformation(1000, 0.1f, 3);
        int componentSize = 1;
        int sampleSize = graphInformation.getNumberOfNodes();
        float result = minimumSpanningForest.approximateWeight(false, graphInformation, componentSize, sampleSize);
        float expectedValue = getExpectedWeight(graphInformation.getNumberOfNodes(), graphInformation.getMaxWeight());
        System.out.println("Component size: " + componentSize);
        System.out.println("Expected: " + expectedValue);
        System.out.println("Result: " + result);
        assertEquals(expectedValue, result, expectedValue * graphInformation.getEps());
    }

    @Test
    public void expectedWeightIs_2500() {
        GraphInformation graphInformation = new GraphInformation(1000, 0.1f, 4);
        int componentSize = 1;
        int sampleSize = graphInformation.getNumberOfNodes();
        float result = minimumSpanningForest.approximateWeight(false, graphInformation, componentSize, sampleSize);
        float expectedValue = getExpectedWeight(graphInformation.getNumberOfNodes(), graphInformation.getMaxWeight());
        System.out.println("Component size: " + componentSize);
        System.out.println("Expected: " + expectedValue);
        System.out.println("Result: " + result);
        assertEquals(expectedValue, result, expectedValue * graphInformation.getEps());
    }

    @Test
    public void expectedWeightIs_3000() {
        GraphInformation graphInformation = new GraphInformation(1000, 0.1f, 5);
        int componentSize = 1;
        int sampleSize = graphInformation.getNumberOfNodes();
        float result = minimumSpanningForest.approximateWeight(false, graphInformation, componentSize, sampleSize);
        float expectedValue = getExpectedWeight(graphInformation.getNumberOfNodes(), graphInformation.getMaxWeight());
        System.out.println("Component size: " + componentSize);
        System.out.println("Expected: " + expectedValue);
        System.out.println("Result: " + result);
        assertEquals(expectedValue, result, expectedValue * graphInformation.getEps());
    }

    @Test
    public void expectedWeightIs_3500() {
        GraphInformation graphInformation = new GraphInformation(1000, 0.1f, 6);
        int componentSize = 1;
        int sampleSize = graphInformation.getNumberOfNodes();
        float result = minimumSpanningForest.approximateWeight(false, graphInformation, componentSize, sampleSize);
        float expectedValue = getExpectedWeight(graphInformation.getNumberOfNodes(), graphInformation.getMaxWeight());
        System.out.println("Component size: " + componentSize);
        System.out.println("Expected: " + expectedValue);
        System.out.println("Result: " + result);
        assertEquals(expectedValue, result, expectedValue * graphInformation.getEps());
    }

    @Test
    public void expectedWeightIs_4000() {
        GraphInformation graphInformation = new GraphInformation(1000, 0.1f, 7);
        int componentSize = 1;
        int sampleSize = graphInformation.getNumberOfNodes();
        float result = minimumSpanningForest.approximateWeight(false, graphInformation, componentSize, sampleSize);
        float expectedValue = getExpectedWeight(graphInformation.getNumberOfNodes(), graphInformation.getMaxWeight());
        System.out.println("Component size: " + componentSize);
        System.out.println("Expected: " + expectedValue);
        System.out.println("Result: " + result);
        assertEquals(expectedValue, result, expectedValue * graphInformation.getEps());
    }

    @Test
    public void expectedWeightIs_4500() {
        GraphInformation graphInformation = new GraphInformation(1000, 0.1f, 8);
        int componentSize = 1;
        int sampleSize = graphInformation.getNumberOfNodes();
        float result = minimumSpanningForest.approximateWeight(false, graphInformation, componentSize, sampleSize);
        float expectedValue = getExpectedWeight(graphInformation.getNumberOfNodes(), graphInformation.getMaxWeight());
        System.out.println("Component size: " + componentSize);
        System.out.println("Expected: " + expectedValue);
        System.out.println("Result: " + result);
        assertEquals(expectedValue, result, expectedValue * graphInformation.getEps());
    }

    @Test
    public void expectedWeightIs_5000() {
        GraphInformation graphInformation = new GraphInformation(1000, 0.1f, 9);
        int componentSize = 1;
        int sampleSize = graphInformation.getNumberOfNodes();
        float result = minimumSpanningForest.approximateWeight(false, graphInformation, componentSize, sampleSize);
        float expectedValue = getExpectedWeight(graphInformation.getNumberOfNodes(), graphInformation.getMaxWeight());
        System.out.println("Component size: " + componentSize);
        System.out.println("Expected: " + expectedValue);
        System.out.println("Result: " + result);
        assertEquals(expectedValue, result, expectedValue * graphInformation.getEps());
    }

    @Test
    public void expectedWeightIs_5500() {
        GraphInformation graphInformation = new GraphInformation(1000, 0.1f, 10);
        //int componentSize = (int) getP(10);
        int componentSize = 1;
        int sampleSize = 40;//graphInformation.getNumberOfNodes()/800;
        //int sampleSize = (int) (16*graphInformation.getMaxWeight()*graphInformation.getMaxWeight()/(graphInformation.getEps()*graphInformation.getEps()));
        float result = minimumSpanningForest.approximateWeight(false, graphInformation, componentSize, sampleSize);
        float expectedValue = getExpectedWeight(graphInformation.getNumberOfNodes(), graphInformation.getMaxWeight());
        System.out.println("Component size: " + componentSize);
        System.out.println("Expected: " + expectedValue);
        System.out.println("Result: " + result);
        assertEquals(expectedValue, result, expectedValue * graphInformation.getEps());
    }

    /*@Test
    public void expectedPows() {
        for (int i = 1; i <= 20; i++) {
            float prob = getP2(i);
            System.out.println(prob);
        }
        for (int i = 2; i <= 20; i++) {
            int components = getComponents(i);
            System.out.println("Prob of weight: " + (float) (i - 1) / i);
            System.out.println("Prob of X: " + Math.pow(1f / components, 1f / components));
            System.out.println("Components: " + components);
        }
    }

    @Test
    public void expectedX() {
        for (int i = 1; i <= 20; i++) {
            float prob = getP2(i);
            int X = getX2(prob, i);
            System.out.println(i + "\t " + prob + "\t " + X);
        }
    }

    private int getX2(float prob, int i) {
        return Math.round(prob * i) == 1 ? Math.round(prob * i) + 1 : Math.round(prob * i);
    }

    private int getComponents(int maxWeight) {
        int components = 2;

        while (((float) Math.pow(1f / components, 1f / components)) < (float) (maxWeight - 1) / maxWeight) {
            System.out.println("Calculating: " + (float) Math.pow(1f / components, 1f / components));
            if (Math.abs((float) Math.pow(1f / components, 1f / components) - (float) (maxWeight - 1) / maxWeight) >
                    Math.abs((float) Math.pow(1f / components + 1, 1f / components + 1) - (float) (maxWeight - 1) / maxWeight)) {
                break;
            }
            components++;
        }
        return components;
    }

    private float getX(int edgeWeight, int maxWeight) {
        return (float) (Math.pow(1f / edgeWeight, 1f / edgeWeight) * maxWeight);
    }

    private float getP2(int connectedComponents) {
        return (float) Math.pow(1f / connectedComponents, 1f / connectedComponents);
    }

    private float getP(int maxWeight) {
        return (float) Math.pow(maxWeight, 3f / 4f);
    }*/

    private float getExpectedWeight(int numberOfNodes, int maximumWeight) {
        int sum = 0;
        for (int i = 1; i <= maximumWeight; i++) {
            sum = sum + i;
        }
        return (float) (numberOfNodes * sum / maximumWeight);
    }

    private float getExpectedWeightSkewed(int numberOfNodes, int maximumWeight, int skew) {
        int sum = 0;
        for (int i = 1; i <= maximumWeight; i++) {
            sum = sum + i;
        }
        return (float) (numberOfNodes * sum / maximumWeight) + (numberOfNodes * ((float) skew / maximumWeight));
    }
}
