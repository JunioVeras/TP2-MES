from collections import deque as Queue

def breadth_first_search(startnode, goalnode):
    queue = Queue([startnode]) # Initialize with list instead of just append
    seen_nodes = set() 
    seen_nodes.add(startnode) 

    while len(queue) > 0:
        node = queue.popleft()

        if node == goalnode:
            return True
        else:
            queue.extend(successor for successor in node.successors if successor not in seen_nodes)
            seen_nodes.update(node.successors)

    return False