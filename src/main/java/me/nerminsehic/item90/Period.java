package me.nerminsehic.item90;

import java.io.*;
import java.util.Date;

public final class Period implements Serializable {
    private Date start;
    private Date end;

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if(this.start.compareTo(this.end) > 0)
            throw new IllegalArgumentException(start + " after " + end);
    }

    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    @Override
    public String toString() {
        return start + " - " + end;
    }

    @Serial
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required.");
    }

    private static class SerializationProxy implements Serializable {
        private final Date start;
        private final Date end;

        SerializationProxy(Period period) {
            this.start = period.start;
            this.end = period.end;
        }

        // readResolve method for Period.SerializationProxy
        @Serial
        private Object readResolve() {
            return new Period(start, end);
        }

        @Serial
        private static final long serialVersionUID = 1231289789535L; //Any number will do (Item 87)
    }

    @Serial
    private Object writeReplace() {
        return new SerializationProxy(this);
    }
}
