import heapq as hq

def shortest_path_lengths(n_nodes, edges):
    distances = {node: float('inf') for pair in edges for node in pair}
    previous = {pair: None for pair in edges}

    start_node = min(distances.keys())
    distances[start_node] = 0

    queue = [(distances[start_node], [start_node])]
    
    while len(queue) > 0:
        current_distance, current_path = hq.heappop(queue)

        if current_distance!= distances[current_path[-1]]:
            continue
        
        neighbor = set()
        
        for edge in edges:
            if edge[0] == current_path[-1]:
                neighbor.add(edge[1])
            
            elif edge[1] == current_path[-1]:
                neighbor.add(edge[0])

        for next_node in neighbor:
            distance_to_next_node = current_distance + abs(edges[(current_path[-1], next_node)][0] - edges[(next_node, current_path[-1])][0])

            if distance_to_next_node < distances[next_node]:
                distances[next_node] = distance_to_next_node
                previous[(next_node, current_path[-1])] = (current_path[-1], next_node)
                
                new_path = list(current_path)
                new_path.append(next_node)
                hq.heappush(queue, (distance_to_next_node, new_path))

    all_distances = {}
    for i in range(len(distances)):
        all_distances[i] = []
        for j in range(i+1, len(distances)):
            key = tuple(sorted([i,j]))
            value = distances[j]
            all_distances[i].append((key,value))
    
    sorted_all_distances = dict(all_distances)
    final_result = {}

    for item in sorted_all_distances.items():
        first_pair = item[0]
        second_pair = tuple(reversed(first_pair))
        if second_pair in final_result and first_pair in final_result:
            raise ValueError("Graph has cycles")
        else:
            final_result[first_pair] = item[1]

    return final_result

# Test cases
graph = {
    (0, 2): 3,
    (0, 5): 5,
    (2, 1): -2,
    (2, 3): 7,
    (2, 4): 4,
    (3, 4): -5,
    (4, 5): -1
}
result =  shortest