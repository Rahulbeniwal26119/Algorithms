class ll:
    def __init__(self, key, value, prev=None):
        self.value = value
        self.key = key
        self.next = None
        if prev:
            prev.next = self

    @staticmethod
    def traverse(head):
        while head :
            print(head.value)
            head = head.next

    @staticmethod
    def append_to_last(head, key, value):
        if not head:
            return ll(key, value)
        last_index = None
        while head.next:
            head = head.next
        ll(key, value, head)


HASH_SIZE=100
HASH_MULT_FACTOR = 0xFF

def hash_function(key):
    hash_sum = 0
    if type(key) is str:
        for c in key:
            hash_sum += ord(c) * HASH_MULT_FACTOR
        return hash_sum % HASH_SIZE
    else:
        raise Exception("This implementation only support string as keys")

hash_table = [None] * HASH_SIZE

def insert(key, value):
    hash_value = hash_function(key)
    if hash_table[hash_value]:
        # collision detected -> append the value at end of index ll
        index_ll = hash_table[hash_value]
        ll.append_to_last(index_ll, key, value)
    else:
        hash_table[hash_value] = ll(key, value)


def get(key):
    hash_value = hash_function(key)
    if not hash_table[hash_value]:
        raise Exception("Key does not exist")
    else:
        # if key exist than check for identical key value
        indexed_ll = hash_table[hash_value]
        while indexed_ll:
            if indexed_ll.key == key:
                return indexed_ll.value
            else:
                indexed_ll=indexed_ll.next
        raise Exception("Key does not exist")
try:
    insert("rahul", "beniwal")
    insert("ab", "value1")
    insert(1, "value2")

    print(get("rahul"))
    print(get("ab"))
    print(get("ba"))
except Exception as e:
    print("Error: ", e)
