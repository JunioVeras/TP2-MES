def shortest_paths(source, weight_by_edge):
    num_nodes = len(weight_by_edge)
    weight_by_node = {v: float('inf') for _ in range(num_nodes)}
    weight_by_node[source] = 0

    for _ in range(num_nodes - 1):  
        for u, v in weight_by_edge.keys(): 
            if weight_by_node[u]!= float('inf'):
                weight_by_edge[(u, v)] = min(
                    weight_by_node[u] + weight_by_edge.get((u, v), 0),
                    weight_by_node[v]
                )
    
    # Relax all edges |V| times
    for _ in range(num_nodes - 1):
        for u, v in weight_by_edge.keys(): 
            if weight_by_node[u]!= float('inf'):
                weight_by_edge[(u, v)] = min(
                    weight_by_node[u] + weight_by_edge.get((u, v), 0),
                    weight_by_node[v]
                )

    return weight_by_node