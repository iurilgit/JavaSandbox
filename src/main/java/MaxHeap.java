import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruili1 on 8/22/17.
 *
 * Implementation of a max heap using an array list.
 */
public class MaxHeap {

    List<Integer> heap = null;

    public MaxHeap(){

        heap = new ArrayList<Integer>();
    }

    public void insert(int x){

        insertAt(0, x);
    }

    public Integer getMax(){

        if(heap.isEmpty()){
            return null;
        }else {
            return heap.get(0);
        }
    }

    public Integer popMax(){

        Integer max = getMax();

        if(max != null){ // if the heap is not empty, remove the last one and re-insert it.
            int last = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            heap.set(0, last);
            heapify(0);
        }

        return max;
    }

    public void heapify(int rootIdx){

        Integer max = heap.get(rootIdx);
        if(max == null){
            return;
        }

        if(hasLeftChild(rootIdx) && max >= getLeftChild(rootIdx) // root is larger than both children, do nothing
                && hasRightChild(rootIdx) && max >= getRightChild(rootIdx)){
            return;
        }else{
            if(hasLeftChild(rootIdx) && max < getLeftChild(rootIdx)) { // root is smaller than left child, swap root and left child, then heapify left child
                max = getLeftChild(rootIdx);
                swap(heap, rootIdx, 2*rootIdx + 1);
                heapify(2*rootIdx + 1);
            }

            if(hasRightChild(rootIdx) && max < getRightChild(rootIdx)) { // root is smaller than right child, swap root and right child, then heapify right child
                max = getRightChild(rootIdx);
                swap(heap, rootIdx, 2*rootIdx + 2);
                heapify(2*rootIdx + 2);
            }
        }
    }

    private void swap(List<Integer> list, int i, int j){

        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public void print(){

        System.out.println(heap.toString());
    }

    private void insertAt(int rootIdx, int x){

        if(rootIdx >= heap.size()){
            heap.add(rootIdx, x);
            return;
        }

        // if x is larger than max of the current subtree, then replace max by x
        int max = heap.get(rootIdx);
        if(x > max){
            heap.set(rootIdx, x);
            x = max;
        }

        // insert x (maybe the old max) to the right children
        if(!hasLeftChild(rootIdx)){  // smaller than root and root has no left child, put it as left child
            heap.add(2*rootIdx + 1, x);
        }else{ // smaller than root and root has left child
            if(!hasRightChild(rootIdx)){ // root has no right child, put x as right child
                heap.add(2*rootIdx + 2, x);
            }else {
                insertAt(2*rootIdx + 1, x);
            }
        }
    }

    private boolean hasLeftChild(int nodeIdx){

        return heap.size() > (2*nodeIdx + 1);
    }

    private boolean hasRightChild(int nodeIdx){

        return heap.size() > (2*nodeIdx + 2);
    }

    private Integer getLeftChild(int nodeIdx){

        if( heap.size() > (2*nodeIdx + 1)) {
            return heap.get(2 * nodeIdx + 1);
        }else {
            return null;
        }
    }

    private Integer getRightChild(int nodeIdx){

        if( heap.size() > (2*nodeIdx + 2)) {
            return heap.get(2 * nodeIdx + 2);
        }else {
            return null;
        }
    }

    public static void main(String[] args){

        MaxHeap maxHeap = new MaxHeap();

        maxHeap.insert(2);
//        maxHeap.print();
        maxHeap.insert(3);
//        maxHeap.print();
        maxHeap.insert(5);
//        maxHeap.print();
        maxHeap.insert(6);
        maxHeap.print();

        maxHeap.popMax();
        maxHeap.print();
        maxHeap.popMax();
        maxHeap.print();
        maxHeap.popMax();
        maxHeap.print();
    }
}
