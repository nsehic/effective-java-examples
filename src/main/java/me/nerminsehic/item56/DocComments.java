package me.nerminsehic.item56;

public interface DocComments<E> {

    /**
     * Returns the element at the specified position in this list/
     *
     * <p>This method is <i>not</i> guaranteed to run in constant time. In some implementations
     *  it may run in time proportional to the element position.</p>
     *
     * @param index index of element to return; must be non-negative and less than the size of this list
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index >= this.size()})
     */
    E get(int index);

    /**
     * Returns true if this collection is empty.
     *
     * @implSpec
     * This implementation returns {@code this.size() == 0}.
     *
     * @return true if this collection is empty
     */
    boolean isEmpty();

    /**
     * This method compiles with the {@index IEEE 754} standard.
     */
    void indexExample();
}


// Doc comments are 'inherited' from superclasses or interfaces.
class ImplementationExample implements DocComments<String> {
    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void indexExample() {

    }
}
