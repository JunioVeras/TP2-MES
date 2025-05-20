def possible_change(coins, total):
    memo = {}

    def helper(total):
        if total == 0:
            return 1
        if total < 0:
            return 0
        key = (total,)
        if key in memo:
            return memo[key]
        
        result = 0
        for i, coin in enumerate(coins):
            new_total = total - coin
            result += helper(new_total)

        memo[key] = result
        return result

    return helper(total)