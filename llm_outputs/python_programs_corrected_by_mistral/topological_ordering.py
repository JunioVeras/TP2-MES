import itertools
from collections import defaultdict

def dfs(node, visited):
    visited[node] = True
    for neighbor in node.neighbors:
        if not visited[neighbor]:
            dfs(neighbor)

def topological_sort(graph):
    visited = defaultdict(bool)
    ordering = []
    
    for node in graph:
        if not visited[node]:
            dfs(node, visited)
            ordering.append(node)
            
    return ordering