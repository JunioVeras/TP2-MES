def kth(arr, k):
    if k == 0:
        return min(arr)
    pivot = arr[0]
    below = [x for x in arr[1:] if x < pivot]
    equal_to_pivot = [x for x in arr if x == pivot]
    above = [x for x in arr[1:] if x > pivot]

    num_less = len(below)
    num_equal_to_pivot = len(equal_to_pivot)
    num_above = len(above)

    if k < num_less + num_equal_to_pivot:
        return kth(below, k)
    elif k == num_less + num_equal_to_pivot:
        return equal_to_pivot[0] if equal_to_pivot else None
    elif k < num_less + num_equal_to_pivot + num_above:
        return kth(above, k-num_less-num_equal_to_pivot-1)
    else:
        return pivot