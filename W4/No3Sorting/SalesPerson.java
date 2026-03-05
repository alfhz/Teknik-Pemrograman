package No3Sorting;

// *******************************************************
// Salesperson.java
//
// Represents a sales person who has a first name, last
// name, and total number of sales.
// *******************************************************
public class SalesPerson implements Comparable {
    private String firstName, lastName;
    private int totalSales;

    // ------------------------------------------------------
    // Constructor: Sets up the sales person object with
    // the given data.
    // ------------------------------------------------------
    public SalesPerson(String first, String last, int sales) {
        firstName = first;
        lastName = last;
        totalSales = sales;
    }

    // -------------------------------------------
    // Returns the sales person as a string.
    // -------------------------------------------
    public String toString() {
        return lastName + ", " + firstName + ": \t" + totalSales;
    }

    // -------------------------------------------
    // Returns true if the sales people have
    // the same name.
    // -------------------------------------------
    public boolean equals(Object other) {
        return (lastName.equals(((SalesPerson) other).getLastName()) &&
                firstName.equals(((SalesPerson) other).getFirstName()));
    }

    // --------------------------------------------------
    // Order is based on total sales with the name
    // (last, then first) breaking a tie.
    // --------------------------------------------------
    public int compareTo(Object other) {
        SalesPerson sp = (SalesPerson) other;

        if (totalSales != sp.totalSales)
            return totalSales - sp.totalSales;

        int lastCompare = lastName.compareTo(sp.lastName);
        if (lastCompare != 0)
            return lastCompare;

        return firstName.compareTo(sp.firstName);
    }

    // -------------------------
    // First name accessor.
    // -------------------------
    public String getFirstName() {
        return firstName;
    }

    // -------------------------
    // Last name accessor.
    // -------------------------
    public String getLastName() {
        return lastName;
    }

    // -------------------------
    // Total sales accessor.
    // -------------------------
    public int getSales() {
        return totalSales;
    }
}
