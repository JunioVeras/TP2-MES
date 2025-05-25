 ```python
from.shortest_paths import shortest_paths


def main():
    # Case 1: Graph with multiple paths
    graph = {
        ('A', 'B'): 3,
        ('A', 'C'): 3,
        ('A', 'F'): 5,
        ('C', 'B'): -2,
        ('C', 'D'): 7,
        ('C', 'E'): 4,
        ('D', 'E'): -5,
        ('E', 'F'): -1
    }
    result = shortest_paths('A', graph)
    for path in result:
        print(path, result[path])
    print()

    # Case 2: Graph with one path
    graph2 = {
        ('A', 'B'): 1,
        ('B', 'C'): 2,
        ('C', 'D'): 3,
        ('D', 'E'): -1,
        ('E', 'F'): 4
    }
    result = shortest_paths('A', graph2)
    for path in result:
        print(path, result[path])
    print()

    # Case 3: Graph with cycle
    graph3 = {
        ('A', 'B'): 1,
        ('B', 'C'): 2,
        ('C', 'D'): 3,
        ('D', 'E'): -1,
        ('E', 'D'): 1,
        ('E', 'F'): 4
    }
    result = shortest_paths('A', graph3)
    for path in result:
        print(path, result[path])
    print()
```