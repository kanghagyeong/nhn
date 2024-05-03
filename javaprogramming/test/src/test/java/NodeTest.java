import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.nhnacademy.Node;

public class NodeTest {
   Node testNode = new Node("name");
    
    @Test
    void NodeTest_nameConfirm() {
        assertEquals(testNode, testNode.getName() );
    }

    private static class testNode extends Node {
        public testNode(String name) {
            super(name);
        }
    }
}


