# Implementation

The implemented sorting algorithms used in this work are:

  * Heapsort
  * Quicksort
  * Merge sort, and
  * Bubble sort

This document will focus on the implementation, possible flaws, and analysis
with pseudocode.

## Heapsort

Heapsort works by first building a max-heap of the given array to be sorted.
After building the heap the algorithm swaps the element at the first index
(element with max value), decrements the heap size, heapifies the root of the
heap, and continues until the heap has only one element left in it.

### Pseudo code

```python
def heapsort(Array a):
  buildheap(a)
  for i in range(1, a.length):
    swap(a, 0, a.length - i)
    heapify(a, a.length - i, 0)
```


```python
def buildheap(Array a):
  for i in range(parent(a.length - 1), -1, step=-1):
    heapify(a, a.length, i)
```

```python
def heapify(Array a, Integer len, Integer i):
  if i < 0: return

  l = (2 * i + 1) # left child of given parent i
  r = l + 1 # right child of given parent i
  
  if r < len: # we have both children
    greater = (a[l] < a[r]) ? r : l
    if a[i] < a[greater]:
      # i needs to be swapped w/ greater
      swap(a, i, greater)
      heapify(a, len, greater)

  if l == (len - 1) && a[i] < a[l]:
    swap(a, i, l)
```

```python
def parent(Integer child):
  return (child / 2) + (child % 2) - 1;
```

### Analysis

As we can see from the pseudo code heapsort builds the heap which takes
O(n log n) time and then calls swap O(1) and heapify O(log n) n - 1 times,
where n is the number of elements in the given array to be sorted. Thus given
our time constraint for heapsort to O(n log n) + O(n log n) = O(n log n).

## Merge sort

Merge sort uses a simple and straight-forward sorting algorithm which is
implemented by the use of divide and conquer -technique.

Because the implementation relies on recursion we have to first determine our
base case. The base case for merge sort is that an array consisting of only
one element is sorted. In the recursion part our array to be sorted is divided
to two equal sized (or n/2 and n/2, n/2 + 1 depending if even or odd) arrays.
Then the merging part begins, where each element of the both arrays is merged
into one by taking the element which is the lowest of the two arrays.

An example demonstration of merge sort applied to <code>[5, 1, 7]</code>:

<code>
<pre>
[5, 7, 1]  # Divide.

[5] [7, 1] # Here 5 is sorted. Divide [7, 1]

[7] [1]    # Merge these two into one array by lowest element.

[1, 7]     # The results. Return and Recur.

[5] [1, 7] # Merge by lowest.

[1, 5, 7]  # Sorted.
</pre>
</code>

### Pseudo code

```python
def sort(Array a):
  if (a.length < 2): return

  # Divide.
  s = divide(a)

  # Recur.
  sort(s[0]); sort(s[1])

  # Conquer.
  merge(a, s[0], s[1]);
```

```python
def divide(Array a):
  Integer len = a.length
  Integer mid = len / 2
  Array first = Array(mid) # new array of size mid
  Array last = Array(mid + (len % 2)) # new array of size mid + (len % 2)

  Integer i = 0, j = 0, k = 0
  while i < first.length: first[i++] = ary[k++]
  while j < last.lenght: last[j++] = ary[k++]

  return [first, last]
```

```python
def merge(Array ary, Array a, Array b):
  Integer i = 0, j = 0, k = 0
  # Loop until we have gone through sub-arys a and/or b.
  while i < a.length and j < b.length:
    ary[k++] = (a[i] <= b[j]) ? a[i++] : b[j++]

  # Loop through remaining elements (if any).
  while i < a.length: ary[k++] = a[i++]
  while j < b.length: ary[k++] = b[j++]
```

### Analysis

As we can see from the pseudo code the time constraint for merge operation
is relative to the two given array length <code>ary</code> n. And because
every iteration is done consecutively our final time constraint for the merge
function is O(n).

The sort is done by recursion and by splitting the array to two equal sized
arrays generates a recursion tree. Now the merge function is called relatively
to the height of the recursion tree which is </code>log<sub>2</sub> n</code>,
thus giving our worst case time performance <code>O(n log n)</code>.

Merge sort is not an in place sorting algorithm. We conclude that using
sub-arrays of the array to be sorted recursively our worst case space
complexity is <code>O(n)</code> where n is the number of elements to be sorted
in the given array.

