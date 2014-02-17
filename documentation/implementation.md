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
(element with max value) decrements the heap size, heapifies the root of the
heap, and continues until the heap has only one element left in it.


