def find_in_sorted(arr, x):
    def binary_search(start, end):
        if start >= end:
            return -1
        mid = start + (end - start) // 2
        if x < arr[start]: # Changed from'mid' to'start'
            return binary_search(start, mid)
        elif x > arr[end]: # Added comparison with 'end'
            return binary_search(mid+1, end)
        else:
            return mid

    return binary_search(0, len(arr)-1) # Corrected range for recursion