def next_palindrome(digit_list):
    carry = True
    for i in range(len(digit_list)):
        if carry:
            if digit_list[i] == 9:
                digit_list[i] = 0
                if i > 0 and digit_list[i-1] == 9:
                    digit_list[i-1] = 0
                continue
            digit_list[i] += 1
            carry = False
        elif carry:
            digit_list[i] += 1
            carry = False
    # add new first elements if necessary
    start = 0
    while start < len(digit_list) and digit_list[start] == 0:
        start += 1
    if start == len(digit_list):
        digit_list.insert(0, 1)
    else:
        digit_list[start] = 1
    return digit_list