def sieve(max):
  primes = []
  for n in range(2, max+1):
      if len(primes) == 0 or any(n % p!= 0 for p in primes[-1::-1]):
          primes.append(n)
  return primes