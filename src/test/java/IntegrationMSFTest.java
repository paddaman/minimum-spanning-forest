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
        int sampleSize = (int) (16 * Math.pow(graphInformation.getMaxWeight(), 3) / Math.pow(graphInformation.getEps()+1f, 2));
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
        int sampleSize = (int) (16 * Math.pow(graphInformation.getMaxWeight(), 3) / Math.pow(graphInformation.getEps()+1f, 2));
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
        int sampleSize = (int) (16 * Math.pow(graphInformation.getMaxWeight(), 3) / Math.pow(graphInformation.getEps()+1f, 2));
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
        int sampleSize = (int) (16 * Math.pow(graphInformation.getMaxWeight(), 3) / Math.pow(graphInformation.getEps()+1f, 2));
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
        int sampleSize = (int) (16 * Math.pow(graphInformation.getMaxWeight(), 3) / Math.pow(graphInformation.getEps()+1f, 2));
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
        int sampleSize = (int) (16 * Math.pow(graphInformation.getMaxWeight(), 3) / Math.pow(graphInformation.getEps()+1f, 2));
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
        int sampleSize = (int) (16 * Math.pow(graphInformation.getMaxWeight(), 3) / Math.pow(graphInformation.getEps()+1f, 2));
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
        int sampleSize = (int) (16 * Math.pow(graphInformation.getMaxWeight(), 3) / Math.pow(graphInformation.getEps()+1f, 2));
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
        int sampleSize = (int) (16 * Math.pow(graphInformation.getMaxWeight(), 3) / Math.pow(graphInformation.getEps()+1f, 2));
        float result = minimumSpanningForest.approximateWeight(false, graphInformation, componentSize, sampleSize);
        float expectedValue = getExpectedWeight(graphInformation.getNumberOfNodes(), graphInformation.getMaxWeight());
        System.out.println("Component size: " + componentSize);
        System.out.println("Expected: " + expectedValue);
        System.out.println("Result: " + result);
        assertEquals(expectedValue, result, expectedValue * graphInformation.getEps());
    }

    @Test
    public void expectedWeightIs_5500() {
        GraphInformation graphInformation = new GraphInformation(1000, 0.3f, 10);
        //int componentSize = (int) getP(10);
        int componentSize = 1;
        int sampleSize = (int) (16 * Math.pow(graphInformation.getMaxWeight(), 3) / Math.pow(graphInformation.getEps()+1f, 2));
        float result = minimumSpanningForest.approximateWeight(false, graphInformation, componentSize, sampleSize);
        float expectedValue = getExpectedWeight(graphInformation.getNumberOfNodes(), graphInformation.getMaxWeight());
        System.out.println("Component size: " + componentSize);
        System.out.println("Expected: " + expectedValue);
        System.out.println("Result: " + result);
        assertEquals(expectedValue, result, expectedValue * graphInformation.getEps());
    }

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
