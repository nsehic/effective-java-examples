package me.nerminsehic.item34;

// Enum that switches on its value to share code - questionable
public enum PayrollDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    private static final int MINS_PER_SHIFT = 8 * 60;

    int pay(int minutesWorked, int payRate) {
        int basePay = minutesWorked * payRate;
        int overtimePay = switch (this) {
            case SATURDAY, SUNDAY -> // weekend
                    basePay / 2;
            default -> // Weekday
                    minutesWorked <= MINS_PER_SHIFT ?
                            0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
        };

        return basePay + overtimePay;
    }
}
