programming-pearls-practice
===========================
Chapter01
---------
It's commonly said to use QuickSort or Merge Sort for file sorting.  
However, we can analyze the problem carefully to gain benifits.  
As the author said, easy programme can be safer, robuster, more effective and more reliable.  
So we need to find a good way to balance the time complexity and space complexity.  
In `prac01.java`, I implemented the sort algorithm in the book.  
And when I type n = 100000, it turned out that library function in java needs 34s while using bitmap needs only 7s!  

