from heapq import heappop, heappush
from typing import Dict, Tuple, Optional, List

class Node:
    def __init__(self, value: str, previous: 'Node' = None, next_nodes: List['Node'] = []):
        self.value = value
        self.previous = previous
        self.next_nodes = next_nodes

def shortest_path_length(graph: Dict[Tuple[Node, Node], int], start_node: Node, end_node: Node) -> int:
    queue = [(0, start_node)]
    visited = set()
    
    while queue:
        current_distance, current_node = heappop(queue)
        
        if current_node == end_node:
            return current_distance
        
        for neighbor, distance in graph.get((current_node, current_node), {}).items():
            new_distance = current_distance + distance
            
            if neighbor not in visited and neighbor!= current_node:
                visited.add(neighbor)
                
                heappush(queue, (new_distance, neighbor))
                
                if neighbor == end_node:
                    return new_distance
                
    return float('inf')

# Test nodes
node1 = Node("1")
node5 = Node("5")
node4 = Node("4", None, [node5])
node3 = Node("3", None, [node4])
node2 = Node("2", None, [node1, node3, node4])
node0 = Node("0", None, [node2, node5])

length_by_edge = {
    (node0, node2): 3,
    (node0, node5): 10,
    (node2, node1): 1,
    (node2, node3): 2,
    (node2, node4): 4,
    (node3, node4): 1,
    (node4, node5): 1
}

# Run tests
result = shortest_path_length(length_by_edge, node0, node1)
print(result)

result = shortest_path_length(length_by_edge, node0, node5)
print(result)

result = shortest_path_length(length_by_edge, node2, node2)
print(result)

result = shortest_path_length(length_by_edge, node1, node5)
print(result)