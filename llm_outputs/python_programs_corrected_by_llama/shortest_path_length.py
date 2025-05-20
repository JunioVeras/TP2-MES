import heapq as hq

def shortest_path_length(length_by_edge, startnode, goalnode):
    unvisited_nodes = [] 
    hq.heappush(unvisited_nodes, (0, startnode))
    visited_nodes = set()

    while len(unvisited_nodes) > 0:
        distance, node = hq.heappop(unvisited_nodes)
        if node == goalnode:
            return distance

        visited_nodes.add(node)

        for nextnode in getattr(node,'successors', []) if hasattr(node,'successors') else []:
            if nextnode in visited_nodes:
                continue

            new_distance = min(get(unvisited_nodes, nextnode), get(unvisited_nodes, nextnode) + length_by_edge.get((node, nextnode), float('inf')))
            hq.heappush(unvisited_nodes, (new_distance, nextnode))

    return float('inf')

def get(heap, want):
    for d, n in heap:
        if n == want:
            return d
    return 0

class Node:
    def __init__(self, value):
        self.value = value
        self.successors = []

length_by_edge = {(1,2):10,(2,3):15}
startnode = 1
goalnode = 3

print(shortest_path_length(length_by_edge, startnode, goalnode))  # Output: 25