### Knowledge:

###### Bubble sort: [(link)][1]
* Worst and Average Time Complexity: **O(n * n)**. 
    Worst case occurs when array is reverse sorted.
* Best Case Time Complexity: **O(n)**. 
    Best case occurs when array is already sorted.
* Auxiliary Space: **O(1)**. 
    (Sorts in place)
* Possible optimizations: 
    * Stopping the algorithm if inner loop did not cause any swap.
* Application: 
    * In computer graphics it is popular for its capability to detect
        a very small error (like swap of just two elements) in 
        almost-sorted arrays and fix it with just linear complexity (2n).
    
###### Merge sort: [(link)][2]
* Worst, Best and Average Time complexity: **O(n * log(n))**
* Auxiliary Space: **O(n)**
* Possible optimization: 
    * Natural merge sort - finding already sorted sequences (Best -> O(n))
    * Using linked lists (Auxiliary space -> O(1))
* Applications
    * Merge Sort is useful for sorting linked lists.
    * Inversion Count Problem - inversions are pairs of numbers, in 
        a disordered list, where the larger of the two numbers is to the 
        left of smaller number.
    * Used in External Sorting - a class of sorting algorithms that can 
        handle massive amounts of data. External sorting is required when 
        the data being sorted do not fit into the main memory of a 
        computing device (usually RAM) and instead they must reside in 
        the slower external memory, usually a hard disk drive.
    
[1]: https://www.tutorialspoint.com/data_structures_algorithms/bubble_sort_algorithm.htm
[2]: https://www.tutorialspoint.com/data_structures_algorithms/merge_sort_algorithm.htm