def wrap(text, cols):
    words = text.split()
    lines = []
    current_line = ""
    
    for word in words:
        if len(current_line) + len(word) + 1 <= cols:
            current_line += " " + word
        else:
            lines.append(current_line.strip())
            current_line = word + " "
            
    # Handle last line
    if current_line:
        lines.append(current_line.strip())

    return lines