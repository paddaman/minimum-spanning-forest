import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created 2019-10-06 by patrikingverud
 */
public class RepositoryTest {

    private Repository repository = new Repository();

    @Test
    public void convertToListTest() {
        String[] array = "3 1 3 6 2 3 1".split(" ");
        List<Node> nodes = repository.convertToList(array);
        assertEquals(3, nodes.size());

        assertEquals(1, nodes.get(0).getNumber());
        assertEquals(6, nodes.get(1).getNumber());
        assertEquals(3, nodes.get(2).getNumber());

        assertEquals(3, nodes.get(0).getWeight());
        assertEquals(2, nodes.get(1).getWeight());
        assertEquals(1, nodes.get(2).getWeight());
    }

    @Test
    public void convertToListTest_empty() {
        String[] array = "0".split(" ");
        List<Node> nodes = repository.convertToList(array);
        assertTrue(nodes.isEmpty());
    }
}