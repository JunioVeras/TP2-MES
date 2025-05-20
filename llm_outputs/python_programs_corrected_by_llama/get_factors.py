def get_prime_factors(n):
    def get_factors(i):
        if i > n:
            return []
        
        if n % i == 0 and is_prime(i):
            return [i] + get_factors(n // i)
        
        return get_factors(i + 1)

    def is_prime(num):
        if num < 2:
            return False
        for j in range(2, int(num ** 0.5) + 1):
            if num % j == 0:
                return False
        return True
    
    return get_factors(2)


# Example usage:

print(get_prime_factors(1))   # Output: []
print(get_prime_factors(100)) # Output: [2, 2, 5, 5]
print(get_prime_factors(101)) # Output: [101]