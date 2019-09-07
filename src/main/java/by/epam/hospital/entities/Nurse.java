package by.epam.hospital.entities;

/**
 * nurse entity
 */
public class Nurse extends Staff {

    private int nurseID;

    /**
     * constructor with parameters
     *
     * @param nurseID    nurse ID
     * @param firstName  first name
     * @param secondName second name
     * @param surname    surname
     * @param staffType  type
     */
    public Nurse(final int nurseID, final String firstName, final String secondName, final String surname,
                 final int staffType) {
        super(nurseID, firstName, secondName, surname, staffType);
    }

    /**
     * getter for Nurse ID
     *
     * @return nurse ID
     */
    public int getNurseID() {
        return nurseID;
    }

    /**
     * setter for Nurse ID
     *
     * @param nurseID nurse ID
     */
    public void setNurseID(final int nurseID) {
        this.nurseID = nurseID;
    }

    @Override
    public String toString() {
        return "Nurse{"
                + "ID=" + nurseID
                + "first name=" + getFirstName()
                + "second name=" + getSecondName()
                + "surname=" + getSurname()
                + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nurse nurse = (Nurse) o;
        return nurseID == nurse.nurseID;
    }

    @Override
    public int hashCode() {
        return nurseID;
    }
}
