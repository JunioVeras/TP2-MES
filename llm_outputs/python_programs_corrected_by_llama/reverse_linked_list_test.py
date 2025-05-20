from.node import Node
from.reverse_linked_list import reverse_linked_list


"""
Driver to test reverse linked list
"""
def main():
    # Case 1: 5-node list input
    # Expected Output: 1 2 3 4 5
    node1 = Node(1)
    node2 = Node(2, node1)
    node3 = Node(3, node2)
    node4 = Node(4, node3)
    node5 = Node(5, node4)

    reversed_node5 = reverse_linked_list(node5)

    if reversed_node5 is None:
        print("Not Reversed!")
    else:
        print("Reversed!", end=" ")
    values = []
    current = reversed_node5
    while current:
        values.append(current.value)
        current = current.prev_successor
    for value in values[::-1]:
        print(value, end=" ")
    print()

    # Case 2: 1-node list input
    # Expected Output: 0
    node = Node(0)
    reversed_node = reverse_linked_list(node)

    if reversed_node is None:
        print("Not Reversed!")
    else:
        print("Reversed!", end=" ")
    values = [reversed_node.value]
    current = reversed_node
    while current.next:
        values.append(current.next.value)
        current = current.next
    for value in values[::-1]:
        print(value, end=" ")
    print()

    # Case 3: None input
    # Expected Output: None
    result = reverse_linked_list(None)
    if result is None:
        print("Reversed!")
    else:
        print("Not Reversed!")

    while True:
        try:
            print(result.value)
            result = result.next
        except AttributeError:
            break
    print()
    
if __name__ == "__main__":
    main()


Note: The above solution assumes `Node` class has attributes like `value`, `successor`, and `prev_successor`. Also it's assumed that `reverse_linked_list` function returns the head of the reversed linked list. If these assumptions don't hold true then we need more information about how those classes and functions work. 

Also note that I have modified the logic inside the loop where you're printing out the nodes' values after reversing them because without knowing what exactly should be done with each node (i.e., whether they should be printed immediately upon being retrieved from