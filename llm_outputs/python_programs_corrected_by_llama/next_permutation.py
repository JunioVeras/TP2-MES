def next_permutation(perm):
    for i in range(len(perm) - 2, -1, -1):
        if perm[i] > perm[i + 1]: # Changed '<' to '>'
            for j in range(len(perm) - 1, i, -1): 
                if perm[j] > perm[i]: # Added '>' here
                    next_perm = list(perm)
                    next_perm[i], next_perm[j] = perm[j], perm[i]
                    next_perm[:i+1] = reversed(next_perm[:i+1]) # Corrected slicing index
                    return next_perm