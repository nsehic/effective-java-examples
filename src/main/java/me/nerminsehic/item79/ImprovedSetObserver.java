package me.nerminsehic.item79;

@FunctionalInterface
public interface ImprovedSetObserver<E> {
    // Invoked when an element is added to the observable set.
    void added(ImprovedObservableSet<E> set, E element);
}

