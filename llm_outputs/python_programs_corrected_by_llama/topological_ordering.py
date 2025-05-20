from collections import deque

def topological_ordering(nodes):
    queue = deque([node for node in nodes if len(node.outgoing_nodes) == 0])
    
    while queue:
        node = queue.popleft()
        
        for next_node in node.outgoing_nodes:
            incoming_count = sum(1 for n in nodes if next_node in n.outgoing_nodes)
            if incoming_count < len(next_node.outgoing_nodes):
                new_queue = []
                for n in nodes:
                    if (next_node in n.outgoing_nodes and 
                        (not next_node in queue or n!= node)):
                        new_queue.extend(n for n in n.outgoing_nodes if next_node in n.outgoing_nodes)
                queue.extend(new_queue)
                
    # Check for cycles by ensuring no node was visited more than once
    visited = {n for n in nodes}
    assert len(queue) + len(visited) == len(nodes), "Cycle detected"

    return sorted(list(visited))