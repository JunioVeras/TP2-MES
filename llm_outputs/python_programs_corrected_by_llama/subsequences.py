def subsequences(a, b, k):
    def helper(start, end, depth):
        if depth == k and start < end:
            result.append([start])
        elif depth > k:
            return
        else:
            for i in range(start, end + 1):
                helper(i + 1, end, depth + 1)
    
    result = []
    helper(a, b, 1)
    return result