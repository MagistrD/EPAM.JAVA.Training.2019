package by.epam.hospital.entities;

/**
 * entity Doctor
 */
public class Doctor extends Staff {

    private int doctorID;

    /**
     * Constructor with parameters
     *
     * @param firstName  first name
     * @param secondName second name
     * @param surname    surname
     * @param staffType  type
     */
    public Doctor(final String firstName, final String secondName, final String surname, final int staffType) {
        super(firstName, secondName, surname, staffType);
    }

    /**
     * Constructor with parameters
     *
     * @param doctorID   ID of doctor
     * @param firstName  first name
     * @param secondName second name
     * @param surname    surname
     * @param staffType  type
     */
    public Doctor(final int doctorID, final String firstName, final String secondName, final String surname,
                  final int staffType) {
        super(firstName, secondName, surname, staffType);
        this.doctorID = doctorID;
    }

    /**
     * getter for doctor ID
     *
     * @return doctor ID
     */
    public int getDoctorID() {
        return doctorID;
    }

    /**
     * setter for doctor ID
     *
     * @param doctorID doctor ID
     */
    public void setDoctorID(final int doctorID) {
        this.doctorID = doctorID;
    }

    @Override
    public String toString() {
        return "Doctor {"
                + "First name = " + getFirstName()
                + ", Second name = " + getSecondName()
                + ", Surname = " + getSurname()
                + ", Specialization = " + getStaffType()
                + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return doctorID == doctor.doctorID;
    }

    @Override
    public int hashCode() {
        return doctorID;
    }
}
