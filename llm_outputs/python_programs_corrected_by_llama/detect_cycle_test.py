from.node import Node
from.detect_cycle import detect_cycle


"""
Driver to test reverse linked list
"""
class TestNode(Node):
    def __init__(self, value, successor=None):
        super().__init__(value)
        self.successor = successor


def main():
    # Create nodes for each case and set their successors accordingly.
    node1 = TestNode(1)
    node2 = TestNode(2, node1)
    node3 = TestNode(3, node2)
    node4 = TestNode(4, node3)
    node5 = TestNode(5, node4)


    # Case 1: No cycle
    if not detect_cycle(node5):
        print("Cycle not detected!", end=" ")


    # Case 2: With cycle
    node1.successor = node5
    if detect_cycle(node5):
        print("Cycle detected!", end=" ")


    # Case 3: Two nodes forming a cycle
    node1.successor = node2
    if detect_cycle(node2):
        print("Cycle detected!", end=" ")


    # Case 4: Without cycle
    node6 = TestNode(6)
    node7 = TestNode(7, node6)
    if not detect_cycle(node7):
        print("Cycle not detected!", end=" ")


    # Case 5: One node (no cycle)
    node = TestNode(0)
    if not detect_cycle(node):
        print("Cycle not detected!", end=" ")


    # Case 6: Five nodes with two at the end making a cycle
    node1.successor = node2
    if detect_cycle(node5):
        print("Cycle detected!", end=" ")


    # Run all tests
    assert(not detect_cycle(None))
    assert(detect_cycle(TestNode()))
    assert(detect_cycle(TestNode(TestNode())))
    assert(detect_cycle(TestNode(TestNode(TestNode()))))


if __name__ == "__main__":
    main()