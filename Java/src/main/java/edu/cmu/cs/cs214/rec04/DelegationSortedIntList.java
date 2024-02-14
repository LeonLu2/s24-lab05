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
    private SortedIntList sortedList;

    // constructor
    public DelegationSortedIntList() {
        sortedList = new SortedIntList();
        totalAdded = 0;
    }

    // implement get method
    public int get(int index) {
        return sortedList.get(index);
    }

    // implement size method
    public int size() {
        return sortedList.size();
    }

    // implement remove method
    public boolean remove(int num) {
        return sortedList.remove(num);
    }

    // implement removeAll method
    public boolean removeAll(IntegerList list) {
        return sortedList.removeAll(list);
    }

    // getter for totalAdded
    public int getTotalAdded() {
        return totalAdded;
    }

    // implement add method, increment totalAdded
    public boolean add(int num) {
        boolean success = sortedList.add(num);
        if (success) {
            totalAdded++;
        }
        return success;
    }

    // implement addAll method, increment totalAdded
    public boolean addAll(IntegerList list) {
        boolean success = false;
        for (int i = 0; i < list.size(); i++) {
            success |= sortedList.add(list.get(i));
            if (success) {
                totalAdded++;
            }
        }
        return success;
    }
}