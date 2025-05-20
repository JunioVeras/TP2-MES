def hanoi(height, start=1, end=3):
    if height == 0:
        return []

    steps = []
    if start!= end and start < end:
        helper_peg = max([i for i in [1, 2, 3] if i not in (start, end)])
        
        # Move n-1 disks from start to helper
        sub_steps = hanoi(height - 1, start, helper_peg)
        
        # Move nth disk from start to end
        sub_steps.append((start, end))
        
        # Move n-1 disks from helper to end
        sub_steps.extend(hanoi(height - 1, helper_peg, end))
    
    elif start == end:
        return [(start, end)]
    
    else:
        raise ValueError("Invalid input")

    return steps