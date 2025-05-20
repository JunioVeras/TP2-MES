from.node import Node
from.breadth_first_search import breadth_first_search


"""
Driver to test breadth first search
"""
def main():
    # Case 1: Strongly connected graph
    # Output: Path found!
    station1 = Node("Westminster")
    station2 = Node("Waterloo", None, [station1])
    station3 = Node("Trafalgar Square", None, [station1, station2])
    station4 = Node("Canary Wharf", None, [station2, station3])
    station5 = Node("London Bridge", None, [station4, station3])
    station6 = Node("Tottenham Court Road", None, [station5, station4])

    if breadth_first_search(station6, station1) and station1!= None:
        print("Path found!", end=" ")
    elif station1!= None:
        print("No path from source to destination!")
    else:
        print("Source node does not exist!")

    print()


    # Case 2: Branching graph
    # Output: Path found!
    nodef =  Node("F")
    nodee =  Node("E")
    noded =  Node("D")
    nodec =  Node("C", None, [nodef])
    nodeb =  Node("B", None, [nodee])
    nodea =  Node("A", None, [nodeb, nodec, noded])

    if breadth_first_search(nodea, nodee) and nodee!= None:
        print("Path found!", end=" ")
    elif nodee!= None:
        print("No path from source to destination!")
    else:
        print("Destination node does not exist!")


    print()


    # Case 3: Two unconnected nodes in graph
    # Output: Path not found
    if not breadth_first_search(nodef, nodee):
        print("Path not found!", end=" ")
    else:
        print("Unexpected result! The function should have returned False.")
    print()


    # Case 4: One node graph
    # Output: Path found!
    if breadh_first_search(nodef, nodef):
        print("Path found!", end=" ")
    else:
        print("Path not found!", end=" ")


    print()


    # Case 5: Graph with cycles
    # Output: Path found!
    node1 = Node("1")
    node2 = Node