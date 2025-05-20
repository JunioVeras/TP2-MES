import heapq

def kheapsort(arr, k):
    if len(arr) == 0:
        raise ValueError("Array cannot be empty")

    min_heap = []
    max_heap = []

    for num in arr:
        # Push number into heaps based on whether it's smaller or larger than current smallest/largest value
        if not min_heap or num < -min_heap[0]:
            heapq.heappush(min_heap, -num)
        else:
            heapq.heappush(max_heap, num)

        # If there are more numbers in max_heap than in min_heap, pop and push back
        if len(max_heap) > len(min_heap):
            heapq.heappush(min_heap, -heapq.heappop(max_heap))

        # If there are more numbers in min_heap than in max_heap, pop and push back
        elif len(min_heap) > len(max_heap):
            heapq.heappush(max_heap, -heapq.heappop(min_heap))

    result = []
    while min_heap or max_heap:
        if min_heap:
            result.append(-heapq.heappop(min_heap))
        if max_heap:
            result.append(heapq.heappop(max_heap))

    return result