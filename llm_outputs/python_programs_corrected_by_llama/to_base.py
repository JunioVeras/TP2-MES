import string
def to_base(num, b):
    if num == 0 and b!= 10:
        return "0"
    result = ''
    alphabet = string.digits + string.ascii_lowercase
    while num > 0:
        i = num % b
        num = num // b
        result = alphabet[i] + result
    return result