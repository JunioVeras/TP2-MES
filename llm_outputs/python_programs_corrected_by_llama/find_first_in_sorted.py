def find_first_in_sorted(arr, x):
    lo = 0
    hi = len(arr) - 1  # Changed from 'hi' to 'len(arr)-1'

    while lo <= hi:
        mid = (lo + hi) // 2

        if x == arr[mid]:
            if mid == 0 or x!= arr[mid - 1]: 
                return mid
            elif arr[hi-1] < x:  
                return -1
            else:
                hi -= 1  

        elif x <= arr[mid]:
            hi = mid - 1  # Corrected this line

        else:
            lo = mid + 1

    return -1