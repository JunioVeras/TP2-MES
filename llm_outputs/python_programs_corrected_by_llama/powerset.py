def powerset(arr):
    if len(arr) == 0:
        return [[]]
    elif len(arr) == 1:
        return [arr, []]
    else:
        first, *rest = arr 
        rest_subsets = powerset(rest)
        return [[first] + subset for subset in rest_subsets] + rest_subsets