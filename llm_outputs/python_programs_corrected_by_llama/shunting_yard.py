def shunting_yard(tokens):
    precedence = {
        '+': 1,
        '-': 1,
        '*': 2,
        '/': 2
    }

    opstack = []
    output_queue = []

    for token in tokens:
        if isinstance(token, str): # Check if token is an operator
            while (opstack and 
                   precedence[token] > precedence.get(opstack[-1], float('-inf'))):
                output_queue.append(opstack.pop())
            opstack.append(token)
        elif isinstance(token, int):
            output_queue.append(token)

    while opstack:
        output_queue.append(opstack.pop())

    return output_queue