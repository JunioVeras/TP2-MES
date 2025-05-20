def is_valid_parenthesization(parens):
    stack = []
    for paren in parens:
        if paren == '(':
            stack.append('(')
        elif paren == ')':
            if len(stack) > 0 and stack[-1] == '(':
                stack.pop()
            else:
                return False
    return len(stack) == 0