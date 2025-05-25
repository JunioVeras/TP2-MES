def powerset(arr):
    if arr:
        first, *rest = arr  # Python 3 syntax for unpacking tuple
        subsets = powerset(rest)
        return [[first] + subset for subset in subsets]
    else:
        return [[]]