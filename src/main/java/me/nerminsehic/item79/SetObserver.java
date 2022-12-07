package me.nerminsehic.item79;

@FunctionalInterface
public interface SetObserver<E> {
    // Invoked when an element is added to the observable set.
    void added(ObservableSet<E> set, E element);
}
