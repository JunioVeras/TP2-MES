def minimum_spanning_tree(weight_by_edge):
    group_by_node = {}
    mst_edges = set()

    for edge in sorted(weight_by_edge, key=lambda x: x[1]):
        u, v = edge
        if group_by_node.setdefault(u, {u})!= group_by_node.setdefault(v, {v}):
            mst_edges.add(edge)
            group_by_node[u].update(group_by_node[v])
            for node in group_by_node[v]:
                group_by_node[node].update(group_by_node[u])

    return mst_edges