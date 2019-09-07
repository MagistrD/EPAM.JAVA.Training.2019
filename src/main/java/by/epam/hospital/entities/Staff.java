package by.epam.hospital.entities;

/**
 * entity staff
 */
public class Staff extends People {

    private int staffID;
    private int staffType;

    /**
     * constructor without parametes
     */
    public Staff() {
    }

    /**
     * constructor with parameter
     *
     * @param staffType staff type
     */
    public Staff(final int staffType) {
        this.staffType = staffType;
    }

    /**
     * constructor with parameters
     *
     * @param staffID staff id
     * @param firstName  first name
     * @param secondName second name
     * @param surname    surname
     * @param staffType  staff type
     */
    public Staff(final int staffID, final String firstName, final String secondName, final String surname,
                 final int staffType) {
        super(firstName, secondName, surname);
        this.staffID = staffID;
        this.staffType = staffType;
    }

    /**
     * getter for staff id
     * @return staff id
     */
    public int getStaffID() {
        return staffID;
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

    @Override
    public String toString() {
        return "Staff{"
                + "first name = " + getFirstName()
                + "second name = " + getSecondName()
                + "surname =" + getSurname()
                + "type = " + getStaffType()
                + '}';
    }
}
