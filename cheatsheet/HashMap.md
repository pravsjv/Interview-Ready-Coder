## Unlocking HashMap's Power for Coding Challenges: Essential Operations to Know
Ready to tackle those coding problems with HashMap mastery? Let's dive into the crucial operations that'll make you a HashMap ninja!

### Create a HashMap and add values
```
    Map<String, Integer> map = new HashMap<>();
    map.put("apple", 20);
    map.put("banana", 40);

    // If value has to be list
    Map<String, List<Integer>> map = new HashMap<>();
```

### containsKey()

Checks if  a specific key exists in the HashMap

```
    map.containsKey("apple"); // returns true
    map.containsKey("banana"); // returns false
```

### get()

Retrieves the value associated with a given key.

```
    map.get(key);
```

### remove()

Removes a key-value pair from the HashMap.

```
    map.remove(key);
```

## size()

Returns the size of the HashMap.

```
    map.size();
```

### Iterate HashMap for values
```
    // using keySet
    for(String key : map.keySet()){
        Integer val = map.get(key);
    }

    // If only values are required without key
    for(Integer val : map.values()){
        System.out.print(val);
    }

    // Using an entrySet
    for(Map.Entry<String,Integer> entry : map.entrySet()){
        String key = entry.getKey();
        Integer val = entry.getValue();
    }

    // Using for each lambda
    map.forEach((key,value) -> {
        System.out.println(key +" " + value);
    });

```

### putIfAbsent

**putIfAbsent :** allows us to conditionally add a key-value pair to a HashMap only if the key doesn't already exists. A convenient way to avoid overwriting existing values and ensure unique keys.
Behavior: 
    - Checks for existing key
    - If key is Absent
      - inserts the new key-value pair
      - returns null indicating that key-value was not present previously
    - If key is present
      - it doesn't modify the existing data
      - returns existing value

Additional Note:
    - It's an atomic operation, hence ensure thread safety in multithreaded environment
    - Useful in tracking a unique element in a collection
    - Useful for creating thread safe counter or caches

```
  Map<String, Integer> counts = new HashMap<>();
  map.putIfAbsent("apple",1);
  map.putIfAbsent("apple",2);
  map.putIfAbsent("banana",3);
  System.out.print(counts); // outputs: {"apple"=1, "banana"=3}  
```

### computeIfAbsent

**computeIfAbsent :** allows to associate a value in hash map, but only if the key is not present. If key is absent, it computes a new value using provided function and then associates the computed value. 

Additional Note:
    - Like putIfAbsent, this is also an atomic operation and ensure thread safety.

```
    HashMap<String, Integer> wordCounts = new HashMap<>();
    wordCounts.computeIfAbsent("hello", word -> 0); // Initializes count for "hello" to 0
    wordCounts.computeIfAbsent("hello", word -> 0)++; // Increments the existing count
    System.out.println(wordCounts); // Output: {"hello"=1}

    HashMap<String, List<String>> groups = new HashMap<>();
    groups.compteIfAbsent(key, key -> new ArrayList<>()).add(group);
```

### clear

Removes all key-value pairs.

```
    map.clear();
```

### isEmpty()

Returns true if the HashMap is Empty

```
    map.isEmpty();
```