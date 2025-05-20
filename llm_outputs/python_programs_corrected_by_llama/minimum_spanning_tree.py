def minimum_spanning_tree(weight_by_edge):
    parent = {}
    rank = {}

    def find(node):
        if node not in parent:
            parent[node] = node
            rank[node] = 0
        if parent[node]!= node:
            parent[node] = find(parent[node])
        return parent[node]

    def union(u, v):
        root_u = find(u)
        root_v = find(v)

        if root_u!= root_v:
            if rank[root_u] > rank[root_v]:
                parent[root_v] = root_u
            else:
                parent[root_u] = root_v
                if rank[root_u] == rank[root_v]:
                    rank[root_v] += 1

    groups = {}
    for node in weight_by_edge.keys():
        groups.setdefault(node, []).append(node)

    for node in groups:
        for other_node in groups[node]:
            if (node, other_node) in weight_by_edge and (other_node, node) in weight_by_edge:
                weight = weight_by_edge[(node, other_node)]
                union(node, other_node)

    mst_edges = []
    visited_nodes = set()
    
    for edge in sorted(weight_by_edge, key=lambda x: weight_by_edge[x]):
        u, v = edge
        if find(u)!= find(v):
            mst_edges.append(edge)
            visited_nodes.update([find(i) for i in [u,v]])
            
            for neighbor in groups[find(u)]:
                if find(neighbor) not in visited_nodes:
                    for n in groups[find(neighbor)]:
                        group = groups[n]
                        for g in group:
                            if find(g) not in visited_nodes:
                                group.remove(g)
                                break
    
    return mst_edges