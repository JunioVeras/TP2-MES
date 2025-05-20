def reverse_linked_list(node):
    prevnode = None
    current = node
    while current:
        nexttemp = current.nextsuccessor
        current.nextsuccessor = prevnode
        current.next = nexttemp
        prevnode = current
        current = nexttemp
    return prevnode