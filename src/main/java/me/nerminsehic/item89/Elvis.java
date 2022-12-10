package me.nerminsehic.item89;

public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() {}

    public void leaveTheBuilding() {

    }

    // readResolve for instance control - you can do better
    private Object readResolve() {
        // Return the one true Elvis and let the garbage collector
        // take care of the Elvis impersonator
        return INSTANCE;
    }
}
