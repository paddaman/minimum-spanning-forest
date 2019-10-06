import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by patrik.ingverud on 2019-10-03.
 */
public class MSFTest {

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int COMPONENT_SIZE_4 = 4;

    private GraphInformation GRAPH_INFORMATION = new GraphInformation(7, 0.2f, 1);

    private Service service = mock(Service.class);
    private MSF minimumSpanningTree = new MSF(service);

    @Before
    public void setupUndirectedGraph() {
        List<List<Node>> listOfNodeLists = createSevenNodes(1);
        setupMockGraph(listOfNodeLists, 1);
    }

    private void setupMockGraph(List<List<Node>> listOfNodeLists, int startNode) {
        for (int i = startNode; i < listOfNodeLists.size() + startNode; i++) {
            given(service.getNeighbours(false, GRAPH_INFORMATION, i)).willReturn(listOfNodeLists.get(i - startNode));
        }
    }

    private List<List<Node>> createSevenNodes(int startNode) {
        List<Node> nodeListUndirected1 = Arrays.asList(new Node(startNode + 1, 1), new Node(startNode + 2, 1));
        List<Node> nodeListUndirected2 = Arrays.asList(new Node(startNode, 1), new Node(startNode + 3, 1), new Node(startNode + 4, 1));
        List<Node> nodeListUndirected3 = Arrays.asList(new Node(startNode, 1), new Node(startNode + 5, 1), new Node(startNode + 6, 1));
        List<Node> nodeListUndirected4 = Arrays.asList(new Node(startNode + 1, 1));
        List<Node> nodeListUndirected5 = Arrays.asList(new Node(startNode + 1, 1));
        List<Node> nodeListUndirected6 = Arrays.asList(new Node(startNode + 2, 1));
        List<Node> nodeListUndirected7 = Arrays.asList(new Node(startNode + 2, 1));

        return Arrays.asList(nodeListUndirected1, nodeListUndirected2, nodeListUndirected3, nodeListUndirected4,
                nodeListUndirected5, nodeListUndirected6, nodeListUndirected7);
    }

    private List<List<Node>> createThreeNodes(int startNode) {
        List<Node> nodeListUndirected1 = Arrays.asList(new Node(startNode + 1, 1), new Node(startNode + 2, 1));
        List<Node> nodeListUndirected2 = Arrays.asList(new Node(startNode, 1));
        List<Node> nodeListUndirected3 = Arrays.asList(new Node(startNode, 1));

        return Arrays.asList(nodeListUndirected1, nodeListUndirected2, nodeListUndirected3);
    }

    /*
     * Tree
     * Breadth first search tests
     */
    @Test
    public void breadthFirstSearch_undirected_null() {
        setupNullGraph();
        int result = minimumSpanningTree.breadthFirstSearch(false, GRAPH_INFORMATION, COMPONENT_SIZE_4, 1, 1);
        assertEquals(1, result);
    }

    @Test
    public void breadthFirstSearch_undirected_1() {
        int result = minimumSpanningTree.breadthFirstSearch(false, GRAPH_INFORMATION, 1, 1, 1);
        assertEquals(2, result);
    }

    @Test
    public void breadthFirstSearch_undirected_2() {
        int result = minimumSpanningTree.breadthFirstSearch(false, GRAPH_INFORMATION, 2, 1, 1);
        assertEquals(3, result);
    }

    @Test
    public void breadthFirstSearch_undirected_3() {
        int result = minimumSpanningTree.breadthFirstSearch(false, GRAPH_INFORMATION, 3, 1, 1);
        assertEquals(4, result);
    }

    @Test
    public void breadthFirstSearch_undirected_4() {
        int result = minimumSpanningTree.breadthFirstSearch(false, GRAPH_INFORMATION, 4, 1, 1);
        assertEquals(5, result);
    }

    @Test
    public void breadthFirstSearch_undirected_5() {
        int result = minimumSpanningTree.breadthFirstSearch(false, GRAPH_INFORMATION, 5, 1, 1);
        assertEquals(6, result);
    }

    @Test
    public void breadthFirstSearch_undirected_6() {
        int result = minimumSpanningTree.breadthFirstSearch(false, GRAPH_INFORMATION, 6, 1, 1);
        assertEquals(7, result);
    }

    @Test
    public void breadthFirstSearch_undirected_7() {
        int result = minimumSpanningTree.breadthFirstSearch(false, GRAPH_INFORMATION, 7, 1, 1);
        assertEquals(7, result);
    }

    @Test
    public void breadthFirstSearch_undirected_moreThan7() {
        int result = minimumSpanningTree.breadthFirstSearch(false, GRAPH_INFORMATION, 8, 1, 1);
        assertEquals(7, result);
    }

    /*
     * One iteration of random nodes
     */
    @Test
    public void estimateComponentSize_numberOfRandomNodes_b_shouldBe0() {
        given(service.getRandom(GRAPH_INFORMATION.getNumberOfNodes())).willReturn(1);
        float result = minimumSpanningTree.estimateComponentSize(false, GRAPH_INFORMATION, COMPONENT_SIZE_4, ONE, 1);
        assertEquals(0f, result, 0.1f);
    }

    @Test
    public void estimateComponentSize_numberOfRandomNodes_b_shouldBe1() {
        given(service.getRandom(GRAPH_INFORMATION.getNumberOfNodes())).willReturn(1);
        float result = minimumSpanningTree.estimateComponentSize(false, GRAPH_INFORMATION, 8, ONE, 1);
        assertEquals(7f, result, 0.1f);
    }

    /*
     * Two iterations of random nodes in forest
     */
    @Test
    public void estimateComponentSize_numberOfRandomNodes2_b_shouldBe0() {
        setupUndirectedGraph_forest();
        when(service.getRandom(GRAPH_INFORMATION.getNumberOfNodes())).thenReturn(1).thenReturn(8);
        float result = minimumSpanningTree.estimateComponentSize(false, GRAPH_INFORMATION, 2, TWO, 1);
        assertEquals(0f, result, 0.1f);
    }

    @Test
    public void estimateComponentSize_numberOfRandomNodes2_b_shouldBe1() {
        setupUndirectedGraph_forest();
        when(service.getRandom(GRAPH_INFORMATION.getNumberOfNodes())).thenReturn(1).thenReturn(8);
        float result = minimumSpanningTree.estimateComponentSize(false, GRAPH_INFORMATION, 4, TWO, 1);
        assertEquals(5f, result, 0.1f);
    }

    @Test
    public void estimateComponentSize_numberOfRandomNodes2_b_shouldBe2() {
        setupUndirectedGraph_forest();
        when(service.getRandom(GRAPH_INFORMATION.getNumberOfNodes())).thenReturn(1).thenReturn(8);
        float result = minimumSpanningTree.estimateComponentSize(false, GRAPH_INFORMATION, 8, TWO, 1);
        assertEquals(10f, result, 0.1f);
    }

    /*
     * approximate with one tree.
     */

    /*
     * b == 0 means 1 connected component, therefore the weight will be the number of nodes - max weight.
     */
    @Test
    public void approximateWeight_shouldBe7_because_b_shouldBe0() {
        given(service.getRandom(GRAPH_INFORMATION.getNumberOfNodes())).willReturn(1);
        float result = minimumSpanningTree.approximateWeight(false, GRAPH_INFORMATION, COMPONENT_SIZE_4, ONE);
        assertEquals(7f, result, 0.1f);
    }

    /*
     * b == 1 means 0 connected component, therefore the weight will be 0 because there are no edges at all.
     */
    @Test
    public void approximateWeight_shouldBe0_because_b_shouldBe1() {
        given(service.getRandom(GRAPH_INFORMATION.getNumberOfNodes())).willReturn(1);
        float result = minimumSpanningTree.approximateWeight(false, GRAPH_INFORMATION, 8, ONE);
        assertEquals(0f, result, 0.1f);
    }

    /*
     * approximate with forest.
     */

    /*
     * b == 0 means 2 connected component, therefore the weight will be 0 because there are no edges at all.
     */
    @Test
    public void approximateWeight2_shouldBe7_because_b_shouldBe0() {
        setupUndirectedGraph_forest();
        when(service.getRandom(GRAPH_INFORMATION.getNumberOfNodes())).thenReturn(1).thenReturn(8);
        float result = minimumSpanningTree.approximateWeight(false, GRAPH_INFORMATION, 2, TWO);
        assertEquals(10f, result, 0.1f);
    }

    /*
     * b == 1 means 1 connected component, therefore the weight will be the number of nodes - max weight.
     */
    @Test
    public void approximateWeight2_shouldBe3point5_because_b_shouldBe1() {
        setupUndirectedGraph_forest();
        when(service.getRandom(GRAPH_INFORMATION.getNumberOfNodes())).thenReturn(1).thenReturn(8);
        float result = minimumSpanningTree.approximateWeight(false, GRAPH_INFORMATION, COMPONENT_SIZE_4, TWO);
        assertEquals(5f, result, 0.1f);
    }

    /*
     * b == 2 means 0 connected component, therefore the weight will be 0 because there are no edges at all.
     */
    @Test
    public void approximateWeight2_shouldBe0_because_b_shouldBe2() {
        setupUndirectedGraph_forest();
        when(service.getRandom(GRAPH_INFORMATION.getNumberOfNodes())).thenReturn(1).thenReturn(8);
        float result = minimumSpanningTree.approximateWeight(false, GRAPH_INFORMATION, 8, TWO);
        assertEquals(0f, result, 0.1f);
    }

    /*
     * approximate with forest.
     */

    /*
     * b == 0 means 3 connected component, therefore the weight will be  because we assume all nodes are connected.
     */
    @Test
    public void approximateWeight3_shouldBe7_because_b_shouldBe0() {
        setupUndirectedGraph_forest();
        when(service.getRandom(GRAPH_INFORMATION.getNumberOfNodes())).thenReturn(1).thenReturn(1).thenReturn(8);
        float result = minimumSpanningTree.approximateWeight(false, GRAPH_INFORMATION, 2, THREE);
        assertEquals(10f, result, 0.1f);
    }

    /*
     * b == 1 means 2 connected component, and the rest are non connected.
     */
    @Test
    public void approximateWeight3_shouldBe6point66_because_b_shouldBe1() {
        setupUndirectedGraph_forest();
        when(service.getRandom(GRAPH_INFORMATION.getNumberOfNodes())).thenReturn(1).thenReturn(1).thenReturn(8);
        float result = minimumSpanningTree.approximateWeight(false, GRAPH_INFORMATION, COMPONENT_SIZE_4, THREE);
        assertEquals(6.66f, result, 0.1f);
    }

    /*
     * b == 2 means 1 connected component, and the rest are non connected.
     */
    @Test
    public void approximateWeight3_shouldBe3point33_because_b_shouldBe2() {
        setupUndirectedGraph_forest();
        when(service.getRandom(GRAPH_INFORMATION.getNumberOfNodes())).thenReturn(1).thenReturn(8).thenReturn(8);
        float result = minimumSpanningTree.approximateWeight(false, GRAPH_INFORMATION, COMPONENT_SIZE_4, THREE);
        assertEquals(3.33f, result, 0.1f);
    }

    /*
     * b == 3 means 0 connected components, therefore the weight will be 0 because we assume there are no edges at all.
     */
    @Test
    public void approximateWeight3_shouldBe0_because_b_shouldBe3() {
        setupUndirectedGraph_forest();
        when(service.getRandom(GRAPH_INFORMATION.getNumberOfNodes())).thenReturn(1).thenReturn(1).thenReturn(8);
        float result = minimumSpanningTree.approximateWeight(false, GRAPH_INFORMATION, 8, THREE);
        assertEquals(0f, result, 0.1f);
    }

    private void setupNullGraph() {
        given(service.getNeighbours(false, GRAPH_INFORMATION, 1)).willReturn(Collections.emptyList());
    }

    public void setupUndirectedGraph_forest() {
        GRAPH_INFORMATION = new GraphInformation(10, GRAPH_INFORMATION.getEps(), GRAPH_INFORMATION.getMaxWeight());
        List<List<Node>> listOfNodeLists = createSevenNodes(1);
        setupMockGraph(listOfNodeLists, 1);
        List<List<Node>> listOfNodeLists2 = createThreeNodes(8);
        setupMockGraph(listOfNodeLists2, 8);
    }
}
