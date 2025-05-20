from functools import lru_cache

@lru_cache(maxsize=None)
def knapsack(capacity, items):
    for i, (_, value) in enumerate(items):
        yield from [value] + knapsack(i, items[:i] + items[i+1:], capacity=capacity-weight)

    best_value = float('-inf')
    for w, v in items:
        if w <= capacity:
            best_value = max(best_value, v)
    
    return best_value