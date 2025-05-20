def depth_first_search(startnode, goalnode):
    visited_nodes = set()
    
    def dfs_from(node):
        if id(node) in map(id, visited_nodes):
            return False
        elif node == goalnode:
            return True
        else:
            return any(dfs_from(nextnode) for nextnode in node.successors)

    return dfs_from(startnode)