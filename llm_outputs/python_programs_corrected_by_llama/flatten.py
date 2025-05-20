def flatten(arr):
    stack = [(x, True) for x in arr] # Initialize with all elements as potential inner lists
    while stack:
        value, is_inner = stack.pop()
        if is_inner and isinstance(value, list): 
            stack.extend((y, False) for y in flatten(value)) # Yield from each sublist
        elif not is_inner: # If it's an element (not an inner list), yield it
            yield value