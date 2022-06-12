package ss10_ArrayList_LinkedList.bai_tap.arrayList_theo_thu_vien;

import java.util.Arrays;

public class MyArrayList<E> {
    /**
    Số lượng phần tử có trong MyArrayList
 */
    private int size =0;
    /**
     * Sức chứa của MyArrayList
     */
    private static final int DEFAULT_CAPACITY =10;
    /**
     * Mảng chứa các phần tử
     */
     Object elements[];

    /**
     * Sức chứa mặc định khi khởi tạo bằng contructor có tham số
     */
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     *Phương thức contructor vs sức chứa truyền vào
     * @param capacity
     */
    public MyArrayList(int capacity) {
        if (capacity >=0){
            elements = new Object[capacity];
        }else {
            throw new IndexOutOfBoundsException("capacity: " +capacity);
        }
    }

    /**
     * phương thức trả về số lượng phần tử
     * @return
     */
    public int size(){
        return this.size;
    }

    /**
     * Phương thúc clear ArrayList
     */
    public void clear(){
        size =0;
        for (int i = 0; i <elements.length ; i++) {
            elements[i] = null;

        }
    }

    /**
     * Phuơng thức add một phần tử vào MyArrayList
     * @param element
     * @return
     */
    public boolean add(E element){
        if (elements.length== size){
            this.ensureCapacity(5);
        }
        elements[size] = element;
        size++;
        return true;
    }

    public void add(E element, int index) {
        if (index > elements.length) {
            throw new IndexOutOfBoundsException("index " + index);
        } else if (elements.length == size) {
            this.ensureCapacity(5);
        }

        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }

    /**
     * Phương thúc tăng kích thước của MyArrayList
     * @param minCapacity
     */
    public void ensureCapacity(int minCapacity){
        if (minCapacity >= 0){
            int newSize = this.elements.length+minCapacity;
            elements = Arrays.copyOf(elements,newSize);

        }else throw new IndexOutOfBoundsException("minCapacity "+ minCapacity);

    }

}
