# Sorting and Heap code Snippets
We often run into the requirement of sorting an array of elements or need to find kth smallest or largest element from a data structure. Following is the cheat sheet that will be handy.

## Convert a Linked List to an array

```java
    LinkedList<Integer> ll = new LinkedList<>();
    ll.add(1);
    ll.add(2);
    ll.add(3);
    ll.add(4);
    // convert it to an array
    ll.toArray(new int[ll.size]);

    LinkedList<int[][]> llm = new LinkedList<>();
    llm.add(1,2);
    llm.add(3,4);
    llm.add(5,6);
    llm.add(6,7);
    // convert it to an array
    llm.toArray(new int[llm.size()][]);

    // Covert an ArrayList to array
    List<Integer> list = new ArrayList<>();
    list.add(5);
    list.add(6);
    list.add(7);

    list.toArray();
```

## Sort an array

```java
    int[] arr = new int[]{8,34,4,1,7,29,64,3};
    Arrays.sort(arr);

    int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
    // Sort the intervals 
    Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
```

## MinHeap with priorityQueue(kth largest element)

```java
    int[] arr = new int[]{8,34,4,1,7,29,64,3};
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int val : arr){
        pq.add(val);
        if(pq.size() > k)
            pq.remove();
    }
    return pq.peek();
```

## MaxHeap with priorityQueue(kth smallest element)

```java
    int[] arr = new int[]{8,34,4,1,7,29,64,3};
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for(int val : arr){
        pq.add(val);
        if(pq.size() > k)
            pq.remove();
    }
    return pq.peek();
```

## Sort elements in a Map

```java
    Map<Integer,String> map = new HashMap<>();
    map.put(1, "bard");
    map.put(2, "chatgpt");
    map.put(3, "claude");

    List<Map.Entry<Integer, String>> sortedEntries = new ArrayList<>(map.entrySet());
    // Sort the entries based on their key values
    sortedEntries.sort(Comparator.naturalOrder());

    // Sort the entries based on their values using a custom comparator
    sortedEntries.sort(Map.Entry.comparingByValue());
```

## Sort elements in an array list
```java
    List<Integer> list = new ArrayList<>();
    list.add(78);
    list.add(16);
    list.add(56);
    list.add(45);
    //Ascending order
    Collections.sort(list);

    // Descending order
    Collections.sort(list, Collections.reverseOrder());
```