import heapq as hq

def shortest_paths(start, graph):
    distances = {node: float('inf') for node in set(node[0] for edge in graph.values()) + set(node[1] for edge in graph.values())}
    previous_nodes = {}
    
    queue = [(hq.heappushpop(distances, distance), (distance, start)) for start, neighbors in graph]
    while queue:
        current_distance, (current_node, _) = next(queue)
        
        if current_distance > distances[current_node]:
            continue
        
        for neighbor, weight in [edge for edge in graph if current_node in edge and edge!= ((current_node[0]), current_node[1])]]:
            new_distance = current_distance + weight
            
            if new_distance < distances[neighbor[0]] if neighbor[0] else new_distance < distances[neighbor[1]]:
                distances[neighbor[0]] = new_distance 
                distances[neighbor[1]] = new_distance  
                
                previous_nodes[(neighbor[0],)] = (previous_nodes.get((current_node[0],)),) if current_node[0] else (previous_nodes.get((current_node[1],)),)
                previous_nodes[(neighbor[1],)] = (previous_nodes.get((current_node[0],)),) if current_node[1] else (previous_nodes.get((current_node[1],)),)

    def reconstruct_path(previous_nodes, target):
        path = []
        current_target = target
        while current_target:
            path.append(current_target)
            current_target = previous_nodes[current_target][0]
        return list(reversed(path))
    
    all_shortest_distances = {start: distances[start]}
    for key, value in previous_nodes.items():   
       parent_key = tuple(value)[0]
       child_value = all_shortest_distances[parent_key]
       
       if isinstance(key,(tuple)):           
           if len(child_value)>len(all_shortest_distances[key]):
               all_shortest_distances.update({key:value})
       elif isinstance(parent_key,tuple):            
          if len(child_value)>len(all_shortest_distances[parent_key]):      
              all_shortest_distances.update({parent_key:child_value}) 

    return {path: dist for path, dist in sorted(all_shortest_distances.items(), key=lambda item:item[1])}

# Test cases
graph = {
    ('A', 'B'): 3,
    ('A', 'C'): 3,
    ('A', 'F'): 5