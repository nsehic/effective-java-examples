package me.nerminsehic.item79;

import me.nerminsehic.item18.ForwardingSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Set;


// Broken - invokes alien method from synchronized block!
public class ImprovedObservableSet<E> extends ForwardingSet<E> {
    public ImprovedObservableSet(Set<E> set) {
        super(set);
    }

    private final List<ImprovedSetObserver<E>> observers = new ArrayList<>();

    public void addObserver(ImprovedSetObserver<E> observer) {
        synchronized(observers) {
            observers.add(observer);
        }
    }

    public boolean removeObserver(ImprovedSetObserver<E> observer) {
        synchronized(observers) {
            return observers.remove(observer);
        }
    }

    // Alien method moved outside of synchronized block - open calls
    private void notifyElementAdded(E element) {
        List<ImprovedSetObserver<E>> snapshot = null;
        synchronized(observers) {
            snapshot = new ArrayList<>(observers);
        }

        for(ImprovedSetObserver<E> observer: observers) {
            observer.added(this, element);
        }
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if(added)
            notifyElementAdded(element);

        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for(E element: c)
            result |= add(element); // Calls notifyElementAdded

        return result;
    }

}

