def sqrt(x, epsilon):
    if x < 1 or epsilon <= 0:
        raise ValueError("Invalid input")
    
    approx = x / 2
    while True:
        better_approx = 0.5 * (approx + x / approx)
        worse_approx = 0.5 * (approx + x / approx)
        
        if abs(better_approx - approx) < epsilon and abs(worse_approx - approx) < epsilon:
            break
        
        approx = better_approx if abs(approx - better_approx) < abs(approx - worse_approx) else worse_approx
    
    return better_approx