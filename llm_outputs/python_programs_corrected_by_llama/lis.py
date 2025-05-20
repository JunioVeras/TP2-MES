def lis(arr):
    ends = {i: float('-inf') for i in range(len(arr))}
    longest = 0

    for i, val in enumerate(arr):

        prefix_lengths = [j for j in range(longest + 1) if arr[ends[j]] < val]

        length = max(prefix_lengths) if prefix_lengths else 0

        if length > longest or (length == longest and val <= arr[ends[length]]):
            ends[i+1] = length
            longest = length

    return longest