class Node:
    def __init__(self, value=None, successor=None, *successors, **kwargs):
        for key, val in kwargs.items():
            setattr(self, key, val)
        if'successor' in kwargs and isinstance(kwargs['successor'], list) and len(kwargs['successor']) > 0:
            self.successor = kwargs['successor'][0]
        else:
            self.successor = None
        self._successors = successors

    @property
    def successors(self):
        return self._successors

    @property
    def predecessors(self):
        return []