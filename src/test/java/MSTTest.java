import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * Created by patrik.ingverud on 2019-10-03.
 */
public class MSTTest {

    private static final List<Node> NODE_LIST_1 = Arrays.asList(new Node(2, 1), new Node(3, 1));
    private static final List<Node> NODE_LIST_2 = Arrays.asList(new Node(4, 1), new Node(5, 1));
    private static final List<Node> NODE_LIST_3 = Arrays.asList(new Node(6, 1), new Node(7, 1));

    private static final List<Node> NODE_LIST_UNDIRECTED_1 = Arrays.asList(new Node(2, 1), new Node(3, 1));
    private static final List<Node> NODE_LIST_UNDIRECTED_2 = Arrays.asList(new Node(1, 1), new Node(4, 1), new Node(5, 1));
    private static final List<Node> NODE_LIST_UNDIRECTED_3 = Arrays.asList(new Node(1, 1), new Node(6, 1), new Node(7, 1));

    private static final int COMPONENT_SIZE_5 = 5;
    private static final int COMPONENT_SIZE_4 = 4;

    private Repository repository = mock(Repository.class);
    private MST minimumSpanningTree = new MST(repository);

    @Before
    public void setupDirectedGraph() {
        given(repository.getNeighbours(1)).willReturn(NODE_LIST_1);
        given(repository.getNeighbours(2)).willReturn(NODE_LIST_2);
        given(repository.getNeighbours(3)).willReturn(NODE_LIST_3);
    }

    @Test
    public void breadthFirstSearch() {
        int result = minimumSpanningTree.breadthFirstSearch(COMPONENT_SIZE_5, 1, 1);
        assertEquals(COMPONENT_SIZE_5, result);
    }

    @Test
    public void breadthFirstSearch_undirected() {
        setupUndirectedGraph();
        int result = minimumSpanningTree.breadthFirstSearch(COMPONENT_SIZE_4, 1, 1);
        assertEquals(COMPONENT_SIZE_4, result);
    }

    @Test
    public void breadthFirstSearch_undirected_null() {
        setupNullGraph();
        int result = minimumSpanningTree.breadthFirstSearch(COMPONENT_SIZE_4, 1, 1);
        assertEquals(1, result);
    }

    private void setupNullGraph() {
        given(repository.getNeighbours(1)).willReturn(Collections.emptyList());
    }

    private void setupUndirectedGraph() {
        given(repository.getNeighbours(1)).willReturn(NODE_LIST_UNDIRECTED_1);
        given(repository.getNeighbours(2)).willReturn(NODE_LIST_UNDIRECTED_2);
        given(repository.getNeighbours(3)).willReturn(NODE_LIST_UNDIRECTED_3);
    }
}
