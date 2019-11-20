package p2.interfaces;

public interface IMinMaxHeap<Key extends Comparable<? super Key>> {

 /**
  * methode to implement to insert a Element in the Heap
  * @param k element (Key)
  */
 void insert(Key k);

 /**
  * method to implement to return the max Key (have to be on the first Level or on the second)
  * @return max Value(Key) in Heap
  */
 Key max();

 /**
  * method to implement to return the min Key (have to be on the first Level)
  * @return min Value(Key) in Heap
  */
 Key min();

 /**
  * method to implement to deleting the min Key (have to be on the first Level)
  * @return min Value(Key) in Heap
  */
 Key delMin();

 /**
  * method to implement to deleting the min Key (have to be on the first Level)
  * @return min Value(Key) in Heap
  */
 Key delMax();

 /**
  * getting the Sizo of the Heap
  * @return size of the Heap
  */
 int size();
}
