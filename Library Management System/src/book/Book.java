package book;

public class Book {
    private final String title;
    private int quantity;
    private boolean isReserved;
    private boolean isBorrowed;
    private boolean isReturnPending;
    private boolean isReservePending;

    public Book(String title, int quantity) {
        this.title = title;
        this.quantity = quantity;
        this.isReserved = false;
        this.isBorrowed = false;
        this.isReturnPending = false;
        this.isReservePending = false;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public boolean isReturnPending() {
        return isReturnPending;
    }

    public boolean isReservePending() {
        return isReservePending;
    }

    public void requestBorrow() {
        if (quantity > 0 && !isReserved && !isBorrowed) {
            quantity--;
            isBorrowed = true;
        }
    }

    public void requestReturn() {
        if (isBorrowed) {
            isReturnPending = true;
        }
    }

    public void requestReserve() {
        if (!isReserved && !isBorrowed && !isReservePending) {
            isReservePending = true;
        }
    }

    public void approveReturn() {
        if (isReturnPending) {
            isReturnPending = false;
            quantity++;
            isBorrowed = false;
        }
    }

    public void approveReserve() {
        if (isReservePending) {
            isReservePending = false;
            isReserved = true;
        }
    }
}
