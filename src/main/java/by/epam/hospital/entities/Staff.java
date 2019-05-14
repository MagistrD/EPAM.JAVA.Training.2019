package by.epam.hospital.entities;

/**
 * entity staff
 */
public class Staff extends People {

    private int staffType;

    /**
     * constructor with parameters
     *
     * @param firstName  first name
     * @param secondName second name
     * @param surname    surname
     * @param staffType  staff type
     */
    public Staff(final String firstName, final String secondName, final String surname, final int staffType) {
        super(firstName, secondName, surname);
        this.staffType = staffType;
    }

    /**
     * getter for staff type
     *
     * @return staff type
     */
    public int getStaffType() {
        return staffType;
    }

    /**
     * setter for staff type
     *
     * @param staffType staff type
     */
    public void setStaffType(final int staffType) {
        this.staffType = staffType;
    }

}
