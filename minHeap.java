import java.util.Arrays;
public class minHeap {
  private int size = 0;
  private int capacity = 10;
  int[] items = new int[capacity];

  // Helper methods

  private int getLeftChildIndex(int parentIndex) {return 2 * parentIndex + 1;}
  private int getRightChildIndex(int parentIndex) {return 2 * parentIndex + 2;}
  private int getParentIndex(int childIndex) { return (childIndex-1)/2;}

  private boolean hasLeftChild(int index) {return getLeftChildIndex(index) <  size;}
  //why < size? because all getleftChildIndex does is a formula. if that formula is greater than the actual size, it is not real
  private boolean hasRightChild(int index) {return getRightChildIndex(index) < size;}
  private boolean hasParent(int index) {return getParentIndex(index) >= 0;}
  //the bound of the index of the parent is 0. Obviously the parent index cannot be == size so it is less than that but it must also not be less than 0.


  private int leftChild(int index) {return items[getLeftChildIndex(index)];}
  private int rightChild(int index) {return items[getRightChildIndex(index)];}
  private int parent(int index) {return items[getParentIndex(index)];}

  private void swap(int index_one, int index_two) {
    int temp = index_one;
    items[index_one] = items[index_two];
    items[index_two] = items[temp];
  }

  private void ensureExtraCapacity() {
    // allows us to make sure we always have space to add more to the heap
    if (capacity == size) {
      items = Arrays.copyOf(items, capacity*2);
      capacity *= 2;
    }
  }

  public int peek() {
    // Allows us to find the smallest or biggest/smallest in the heap based on if min or max heap
    if (size == 0) { throw new IllegalStateException();}
    return items[0];
  }

  public int poll() {
    // allows us to pop off the biggest or smallest int, resulting in a changed list with a new root
    int item = items[0];
    items[0] = items[size-1];
    size--;
    heapifyDown();
    return item;
  }

  public void add(int item) {
    ensureExtraCapacity();
    items[size] = item;
    size++;
    heapifyUp();
  }

  public void heapifyUp() {
    // starts at last possible index added then goes up the parents to check if it is bigger or smaller than each parent
    int index = size-1;
    while (hasParent(index) && parent(index) > items[index]) {
      swap(getParentIndex(index), index);
      index = getParentIndex(index);
    }
  }

  public void heapifyDown() {
    // starts at first index (where size-1 has been moved to) then moves it to place where quickest change is possible
    int index = 0;
    while (hasLeftChild(index)) {
      int smallerChildIndex = getLeftChildIndex(index);
      if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
        smallerChildIndex = getRightChildIndex(index);
      }
      if (items[index] < items[smallerChildIndex]) {
        break;
      } 
      else {
        swap(index, smallerChildIndex);
        index = smallerChildIndex;
      }
    }
  }
  public static void main(String[] args) {
    System.out.println("this works");
  }
}
