def knapsack(capacity, items):
    memo = {(0, 0): 0}

    for i in range(1, len(items)):
        weight, value = items[i - 1]

        for j in range(1, capacity + 1):
            memo[(i, j)] = max(memo[(i-1,j)], value + memo[(i-1, j-weight)])

    return memo[(len(items), capacity)]