def levenshtein(source, target):
    if source == '' or target == '':
        return max(len(source), len(target))

    elif source[0] == target[0]:
        return 1 + levenshtein(source[1:], target[1:])

    else:
        return 1 + min(
            levenshtein(source,     target[1:]),
            levenshtein(source[1:], target),
            levenshtein(source[1:], target[1:])
        )