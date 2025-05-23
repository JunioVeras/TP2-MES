def bucket_sort(arr, k):
    counts = [0] * k
    for x in arr:
        if isinstance(x, int) and 0 <= x < k:
            counts[x] += 1

    sorted_arr = []
    for i, count in enumerate(counts): # Changed from 'arr' to 'counts'
        sorted_arr.extend([i] * count)

    return sorted_arr