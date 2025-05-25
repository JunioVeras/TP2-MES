def subsequences(a, b, k):
  if k == 0:
    return []

  ret = []
  for i in range(a, b+1-k):
      ret.append([i])
      ret.extend(subsequences(i+1,b,k-1))
  return ret