package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList{
    // Write your implementation below with API documentation
    private int totalAdded;
    private SortedIntList list;

    // constructor
    public DelegationSortedIntList() {
        list = new SortedIntList();
        totalAdded = 0;
    }

    // implement get method
    public int get(int index) {
        return list.get(index);
    }

    // implement size method
    public int size() {
        return list.size();
    }

    // implement remove method
    public boolean remove(int num) {
        return list.remove(num);
    }

    // implement removeAll method
    public boolean removeAll(IntegerList list) {
        return this.list.removeAll(list);
    }

    // getter for totalAdded
    public int getTotalAdded() {
        return totalAdded;
    }

    // implement add method, increment totalAdded
    public boolean add(int num) {
        boolean success = list.add(num);
        if (success) {
            totalAdded++;
        }
        return success;
    }

    // implement addAll method, increment totalAdded
    public boolean addAll(IntegerList list) {
        boolean success = false;
        for (int i = 0; i < list.size(); i++) {
            success |= list.add(list.get(i));
            if (success) {
                totalAdded++;
            }
        }
        return success;
    }
}