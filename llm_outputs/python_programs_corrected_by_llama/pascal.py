def pascal(n):
    rows = [[1]]
    for r in range(1, n):
        row = []
        for c in range(r): # changed from 'r' to 'c'
            left = rows[r-1][:c]
            right = rows[r-1][c+1:]
            row.extend(left) 
            row.extend(right)
        rows.append(row)

    return rows