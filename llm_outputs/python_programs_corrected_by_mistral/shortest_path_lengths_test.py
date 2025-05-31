from.shortest_path_lengths import shortest_path_lengths


"""
Test shortest path lengths
"""
def main():
    # Case 1: Basic graph input.
    # Output:
    graph = {
        (0, 2): 3,
        (0, 5): 5,
        (2, 1): -2,
        (2, 3): 7,
        (2, 4): 4,
        (3, 4): -5,
        (4, 5): -1
    }
    result = shortest_path_lengths(6, graph)
    for node_pairs in result:
        print(node_pairs, result[node_pairs])