package test.org.talentboost.ads.lists;

import main.org.talentboost.ads.lists.Node;
import main.org.talentboost.ads.lists.NodeUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NodeTest {
    public static void main(String[] args) {
        testNodeDelete();

        testNodeInsert();

        testNodePush();
        testNodePushIntoNull();

        testSize();

        System.out.println("SUCCESS");
    }

    private static void testSize() {
        Node<Integer> nodes = buildNodes();

        int size = NodeUtils.size(nodes);
        assertValue(4, size);
    }

    private static void testNodePush() {
        Node<Integer> start = buildNodes();

        assertValue(4, NodeUtils.size(start));
        Node<Integer> modified = NodeUtils.push(start, 3);
        assertValue(5, NodeUtils.size(start));
        assertNode(modified, Arrays.asList(5, 3, 2, 7, 3));
    }

    private static void testNodePushIntoNull() {
        Node<Integer> node = NodeUtils.push(null, 5);

        assertValue(1, NodeUtils.size(node));
        assertNode(node, Collections.singletonList(5));
    }

    public static void testNodeDelete() {
        testNodeDeleteInTheMiddle();
        testNodeDeleteFirstElement();
        testNodeDeleteLastElement();
    }

    public static void testNodeDeleteInTheMiddle() {
        Node<Integer> start = buildNodes();

        assertValue(4, NodeUtils.size(start));
        Node<Integer> modified = NodeUtils.delete(start, 3);
        assertValue(3, NodeUtils.size(modified));
        assertNode(modified, Arrays.asList(5, 2, 7));
    }

    public static void testNodeDeleteFirstElement() {
        Node<Integer> start = buildNodes();

        assertValue(4, NodeUtils.size(start));
        Node<Integer> modified = NodeUtils.delete(start, 5);
        assertValue(3, NodeUtils.size(modified));
        assertNode(modified, Arrays.asList(3, 2, 7));
    }

    public static void testNodeDeleteLastElement() {
        Node<Integer> start = buildNodes();

        assertValue(4, NodeUtils.size(start));
        Node<Integer> modified = NodeUtils.delete(start, 7);
        assertValue(3, NodeUtils.size(modified));
        assertNode(modified, Arrays.asList(5, 3, 2));
    }

    public static void testNodeInsert() {
        Node<Integer> start = buildNodes();

        assertValue(4, NodeUtils.size(start));
        Node<Integer> modified = NodeUtils.insert(start, 10, 2);
        assertValue(5, NodeUtils.size(modified));
        assertNode(modified, Arrays.asList(5, 10, 3, 2, 7));
    }

    public static Node<Integer> buildNodes() {
        Node<Integer> start = new Node<>();
        start.value = 5;

        Node<Integer> next = new Node<>();
        next.value = 3;
        start.next = next;

        Node<Integer> next2 = new Node<>();
        next2.value = 2;
        next.next = next2;

        Node<Integer> next3 = new Node<>();
        next3.value = 7;
        next2.next = next3;

        return start;
    }

    public static void assertNode(Node<Integer> n, List<Integer> values) {
        int count = 0;
        while (n != null) {
            if (!n.value.equals(values.get(count))) {
                throw new IllegalStateException("Expected: " + values.get(count) + ", got: " + n.value);
            }
            n = n.next;
            count++;
        }
        if (count != values.size()) {
            throw new IllegalStateException("Not all elements are present in the node.");
        }
    }

    public static void assertValue(int expected, int actual) {
        if (expected != actual) {
            throw new IllegalStateException("Got ["+actual+"], expected ["+expected+"]");
        }
    }
}
