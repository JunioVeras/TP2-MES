def detect_cycle(node):
    hare = tortoise = node

    while hare and hare.next:
        if hare == tortoise:
            return True

        tortoise = tortoise.next
        hare = hare.next.next

    return False