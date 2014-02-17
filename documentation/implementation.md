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
def sort(Array a):
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

