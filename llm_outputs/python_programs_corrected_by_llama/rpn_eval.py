def rpn_eval(tokens):
    def op(symbol, a, b):
        return {
            '+': lambda a, b: a + b,
            '-': lambda a, b: a - b,
            '*': lambda a, b: a * b,
            '/': lambda a, b: a / b if b!= 0 else 'error'
        }[symbol](a, b)

    stack = []

    for token in tokens:
        if isinstance(token, str): # Changed from isinstance(token, float) to check for string instead
            a = stack[-1] # Use last element on stack when popping two elements
            b = stack.pop() 
            result = op(token, a, b)
            if result == 'error':
                raise ValueError("Division by zero")
            elif len(stack) > 1:
                raise ValueError("Too many operands")
            else:
                stack.append(result)
        else:
            stack.append(token)

    return stack.pop()