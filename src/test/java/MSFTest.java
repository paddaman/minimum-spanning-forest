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
    private static final int COMPONENT_SIZE_4 = 4;

    private static final GraphInformation GRAPH_INFORMATION = new GraphInformation(7, 0.2f, 1);

    private Repository repository = mock(Repository.class);
    private MSF minimumSpanningTree = new MSF(repository);

    @Before
    public void setupUndirectedGraph() {
        List<List<Node>> listOfNodeLists = createSevenNodes(1);
        setupMockGraph(listOfNodeLists, 1);
    }

    private void setupMockGraph(List<List<Node>> listOfNodeLists, int startNode) {
        for (int i = startNode; i < listOfNodeLists.size() + startNode; i++) {
            given(repository.getNeighbours(i)).willReturn(listOfNodeLists.get(i - startNode));
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
        int result = minimumSpanningTree.breadthFirstSearch(COMPONENT_SIZE_4, 1, 1);
        assertEquals(1, result);
    }

    @Test
    public void breadthFirstSearch_undirected_1() {
        int result = minimumSpanningTree.breadthFirstSearch(1, 1, 1);
        assertEquals(2, result);
    }

    @Test
    public void breadthFirstSearch_undirected_2() {
        int result = minimumSpanningTree.breadthFirstSearch(2, 1, 1);
        assertEquals(3, result);
    }

    @Test
    public void breadthFirstSearch_undirected_3() {
        int result = minimumSpanningTree.breadthFirstSearch(3, 1, 1);
        assertEquals(4, result);
    }

    @Test
    public void breadthFirstSearch_undirected_4() {
        int result = minimumSpanningTree.breadthFirstSearch(4, 1, 1);
        assertEquals(5, result);
    }

    @Test
    public void breadthFirstSearch_undirected_5() {
        int result = minimumSpanningTree.breadthFirstSearch(5, 1, 1);
        assertEquals(6, result);
    }

    @Test
    public void breadthFirstSearch_undirected_6() {
        int result = minimumSpanningTree.breadthFirstSearch(6, 1, 1);
        assertEquals(7, result);
    }

    @Test
    public void breadthFirstSearch_undirected_7() {
        int result = minimumSpanningTree.breadthFirstSearch(7, 1, 1);
        assertEquals(7, result);
    }

    @Test
    public void breadthFirstSearch_undirected_moreThan7() {
        int result = minimumSpanningTree.breadthFirstSearch(8, 1, 1);
        assertEquals(7, result);
    }

    /*
     * One iteration of random nodes
     */
    @Test
    public void estimateComponentSize_numberOfRandomNodes_b_shouldBe0() {
        given(repository.getRandom(GRAPH_INFORMATION.getMaxWeight())).willReturn(1);
        float result = minimumSpanningTree.estimateComponentSize(GRAPH_INFORMATION, COMPONENT_SIZE_4, ONE, 1);
        assertEquals(0f, result, 0.1f);
    }

    @Test
    public void estimateComponentSize_numberOfRandomNodes_b_shouldBe1() {
        given(repository.getRandom(GRAPH_INFORMATION.getMaxWeight())).willReturn(1);
        float result = minimumSpanningTree.estimateComponentSize(GRAPH_INFORMATION, 8, ONE, 1);
        assertEquals(7f, result, 0.1f);
    }

    @Test
    public void approximateWeight_shouldBe7_because_b_shouldBe0() {
        given(repository.getRandom(GRAPH_INFORMATION.getMaxWeight())).willReturn(1);
        float result = minimumSpanningTree.approximateWeight(GRAPH_INFORMATION, COMPONENT_SIZE_4, ONE);
        assertEquals(7f, result, 0.1f);
    }

    @Test
    public void approximateWeight_shouldBe0_because_b_shouldBe1() {
        given(repository.getRandom(GRAPH_INFORMATION.getMaxWeight())).willReturn(1);
        float result = minimumSpanningTree.approximateWeight(GRAPH_INFORMATION, 8, ONE);
        assertEquals(0f, result, 0.1f);
    }

    /*
     * Two iterations of random nodes in forest
     */
    @Test
    public void estimateComponentSize_numberOfRandomNodes2_b_shouldBe0() {
        setupUndirectedGraph_forest();
        when(repository.getRandom(GRAPH_INFORMATION.getMaxWeight())).thenReturn(1).thenReturn(8);
        float result = minimumSpanningTree.estimateComponentSize(GRAPH_INFORMATION, 2, TWO, 1);
        assertEquals(0f, result, 0.1f);
    }

    @Test
    public void estimateComponentSize_numberOfRandomNodes2_b_shouldBe1() {
        setupUndirectedGraph_forest();
        when(repository.getRandom(GRAPH_INFORMATION.getMaxWeight())).thenReturn(1).thenReturn(8);
        float result = minimumSpanningTree.estimateComponentSize(GRAPH_INFORMATION, 4, TWO, 1);
        assertEquals(3.5f, result, 0.1f);
    }

    @Test
    public void estimateComponentSize_numberOfRandomNodes2_b_shouldBe2() {
        setupUndirectedGraph_forest();
        when(repository.getRandom(GRAPH_INFORMATION.getMaxWeight())).thenReturn(1).thenReturn(8);
        float result = minimumSpanningTree.estimateComponentSize(GRAPH_INFORMATION, 8, TWO, 1);
        assertEquals(7f, result, 0.1f);
    }

    private void setupNullGraph() {
        given(repository.getNeighbours(1)).willReturn(Collections.emptyList());
    }

    public void setupUndirectedGraph_forest() {
        List<List<Node>> listOfNodeLists = createSevenNodes(1);
        setupMockGraph(listOfNodeLists, 1);
        List<List<Node>> listOfNodeLists2 = createThreeNodes(8);
        setupMockGraph(listOfNodeLists2, 8);
    }
}
