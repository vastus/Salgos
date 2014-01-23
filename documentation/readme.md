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

Steps for sorting an array using merge sort

1. Divide - split the array in half (creating sub-arrays)
2. Recur - call sort recursively until array length is less than two
3. Conquer - merge the sub-arrays by comparing size

### Time and space constraints
Time ![Time constraint for merge sort][eq/merge/time]
Space ![Time constraint for merge sort][eq/merge/space]

# References
Implementation and analysis will be refering to the material used in 
'Tietorakenteet ja Algoritmit' -course held by Helsingin yliopisto IT Dep.


Juho Hautala &lt;juho.hautala@helsinki.fi&gt;

[wiki/dac]: http://en.wikipedia.org/wiki/Divide_and_conquer_algorithm "wiki/Divide and conquer algorithm"
[eq/merge/time]: http://latex.codecogs.com/png.latex?O%28nlog%28n%29%29 "Time constraint for Merge sort"
[eq/merge/space]: http://latex.codecogs.com/png.latex?O(n) "Time constraint for Merge sort"
