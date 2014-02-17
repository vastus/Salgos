# Description

This task is going to focus on the implementation, and analysis of sorting
algorithms. Some of the sorting algorithms will be using abstract datatypes
assisting on how the sorting works; these ADT's will also be implemented.

For example in heap sort the algorithm exploits heavy usage ofa a max heap ADT.


# Specification

How the algorithms will be implemented is mainly going to base on the pseudo
code that has been provided in the material that this work will rely on.

## Merge sort

Merge sort is a good example of a [divide and conquer][wiki/dac] algorithm.
It is a good example of a basic comparison sort.

Steps for sorting an array using merge sort:

1. Divide - split the array in half (creating sub-arrays)
2. Recur - call sort recursively until array length is less than two
3. Conquer - merge the sub-arrays by comparing size

### Time and space constraints

Time ![Time constraint for merge sort][eq/time/nlogn]

Space ![Space constraint for merge sort][eq/space/n]

## Heap sort

Heap sort is an inplace sorting algorithm thus making its time constraint
constant (which is useful for large arrays). It's quite an efficient sorting
algorithm that can sort n items in ```O(n log n)``` time. Heap sort is not a stable 
sorting algorithm nor is it a comparing one.

The idea of heap sort is as follows:

1. Build (max) heap - heapify the given array to be sorted from last parent to root
2. Delete max item - swap the first and last item, decrease heap size, heapify root
3. Repeat step 2. until root item

### Time and space constraints

Time ![Time constraint for heap sort][eq/time/nlogn]

Space ![Space constraint for heap sort][eq/space/1]

## Quick sort

Continuing the divide and conquer paradigm quick sort is also implemented in this way.
Quick sort is an in-place comparison sorting algorithm which takes no extra space and
can sort in linear logarithmic time on average, but worst case time constraint is
<code>O(n<sup>2</sup>)</code>.

1. Divide - select (specified item) pivot
2. Recur - recursively sort given array
3. Conquer - put items back into given array to be sorted

### Time and space constraints

Time ![Time constraint for quick sort][eq/time/n2]

Space ![Space constraint for quick sort][eq/space/n]


# References

Implementation and analysis will be refering to the material used in
'Tietorakenteet ja Algoritmit' -course held by Helsingin yliopisto IT Dep.

Juho Hautala &lt;juho.hautala@helsinki.fi&gt;

[wiki/dac]: http://en.wikipedia.org/wiki/Divide_and_conquer_algorithm "wiki/Divide and conquer algorithm"
[eq/time/nlogn]: http://latex.codecogs.com/png.latex?O%28n%20log%20n%29 "Time constraint is linear logarithmic"
[eq/time/n2]: http://latex.codecogs.com/png.latex?O(n^2) "Time constraint is quadratic."
[eq/space/n]: http://latex.codecogs.com/png.latex?O(n) "Space constraint is linear."
[eq/space/1]: http://latex.codecogs.com/png.latex?O(1) "Space constraint is constant."

