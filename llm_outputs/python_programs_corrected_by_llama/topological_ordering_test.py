class Node:
    def __init__(self, value):
        self.value = value
        self.incoming_nodes = []
        self.outgoing_nodes = []

def topological_ordering(graph):
    visited = set()
    order = []

    def dfs(node):
        if node in visited:
            return False
        visited.add(node)
        
        for neighbor in node.outgoing_nodes:
            if not dfs(neighbor):
                return False
        
        order.append(node)
        return True

    for node in graph:
        if len(node.incoming_nodes) > 0 and all(len(n.incoming_nodes) == 0 for n in node.outgoing_nodes):
            continue
        elif len(node.incoming_nodes)!= 0:
            raise ValueError(f"Node {node} has incoming edges but no outgoing edges.")
        else:
            dfs(node)

    while len(order) > 0 and len(order[-1].incoming_nodes) > 0:
        last_node = order.pop()
        for i, node in enumerate(last_node.outgoing_nodes):
            new_outgoing_nodes = list(set(node.outgoing_nodes))
            old_incoming_nodes = [n for n in last_node.incoming_nodes if n!= node]
            
            if len(new_outgoing_nodes) < len(old_incoming_nodes + [last_node]):
                raise ValueError(f"Inconsistent edge connections between nodes {last_node} and {node}.")
                
            for j, n in enumerate(new_outgoing_nodes):
                n.incoming_nodes.remove(last_node)
                n.incoming_nodes.extend(old_incoming_nodes[:j] + [last_node])
    
    return sorted(order, key=lambda x: (len(x.outgoing_nodes), -x.value))

# Case 1: Wikipedia graph
five = Node(5)
seven = Node(7)
three = Node(3)
eleven = Node(11)
eight = Node(8)
two = Node(2)
nine = Node(9)
ten = Node(10)

five.outgoing_nodes = [eleven]
seven.outgoing_nodes = [eleven, eight]
three.outgoing_nodes = [eight, ten]
eleven.incoming_nodes = [five, seven]
eleven.outgoing_nodes = [two, nine, ten]
eight.incoming_nodes = [seven, three]
eight.outgoing_nodes = [nine]
two.incoming_nodes = [eleven]
nine.incoming_nodes = [eleven, eight]
ten.incoming_nodes = [eleven, three]

try