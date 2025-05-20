from collections import defaultdict

def shortest_path_lengths(n, length_by_edge):
    length_by_path = defaultdict(lambda: float('inf'))
    for i in range(n):
        length_by_path[(i, i)] = 0
    
    for u, v, w in length_by_edge.items():
        if isinstance(u, tuple) and len(u) == 2:
            length_by_path[u[0], u[1]] = w
        elif isinstance(v, tuple) and len(v) == 2:
            length_by_path[v[0], v[1]] = w
        else:
            raise ValueError("Edge lengths must be tuples with two elements")

    for k in range(n):
        for i in range(n):
            for j in range(n):
                length_by_path[i, j] = min(
                    length_by_path[i, j],
                    length_by_path[i, k] + length_by_path[k, j]
                )

    return {tuple(sorted(key)): value for key, value in length_by_path.items()}