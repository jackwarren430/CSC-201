public interface MyList{
    // Remove all contents from the list, so that it is empty.
    public void clear();

    // Insert ``item'' at the end of the List.
    public void append(Object item);

    // Remove and return the item located at ``pos''. Return `null' if pos is invalid.
    public Object remove(int pos);

    // Insert ``item'' at pos. Do nothing if pos is invalid.
    public void insert(Object item, int pos);

    // Return the number of elements in the list.
    public int length();

    // Return true if List is empty, false otherwise.
    public boolean isEmpty();

}