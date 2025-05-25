def possible_change(coins, total):
    if total == 0:
        return 1
    if total < 0:
        return 0

    first, *rest = sorted(coins) # changed 'first, *rest' to'sorted(coins)'
    return sum(possible_change(coins[:i+1], total-first) for i in range(len(coins))) + possible_change(rest, total)