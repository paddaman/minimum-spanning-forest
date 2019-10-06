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
        int componentSize = graphInformation.getMaxWeight();
        int sampleSize = graphInformation.getNumberOfNodes();
        float result = minimumSpanningForest.approximateWeight(false, graphInformation, componentSize, sampleSize);
        float expectedValue = getExpectedWeight(graphInformation.getNumberOfNodes(), graphInformation.getMaxWeight());
        assertEquals(expectedValue, result, expectedValue * graphInformation.getEps());
    }

    @Test
    public void expectedWeightIs_1500() {
        GraphInformation graphInformation = new GraphInformation(1000, 0.1f, 2);
        int componentSize = graphInformation.getMaxWeight();
        int sampleSize = graphInformation.getNumberOfNodes();
        float result = minimumSpanningForest.approximateWeight(false, graphInformation, componentSize, sampleSize);
        float expectedValue = getExpectedWeight(graphInformation.getNumberOfNodes(), graphInformation.getMaxWeight());
        assertEquals(expectedValue, result, expectedValue * graphInformation.getEps());
    }

    @Test
    public void expectedWeightIs_2000() {
        GraphInformation graphInformation = new GraphInformation(1000, 0.1f, 3);
        int componentSize = graphInformation.getMaxWeight();
        int sampleSize = graphInformation.getNumberOfNodes();
        float result = minimumSpanningForest.approximateWeight(false, graphInformation, componentSize, sampleSize);
        float expectedValue = getExpectedWeight(graphInformation.getNumberOfNodes(), graphInformation.getMaxWeight());
        assertEquals(expectedValue, result, expectedValue * graphInformation.getEps());
    }

    private float getExpectedWeight(int numberOfNodes, int maximumWeight) {
        int sum = 0;
        for (int i = 1; i<=maximumWeight; i++) {
            sum = sum + i;
        }
        return (float)(numberOfNodes*sum/maximumWeight);
    }
}
