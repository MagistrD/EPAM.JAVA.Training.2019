package by.epam.hospital.entities;

/**
 * staff specialization
 */
public class StaffSpecialization {

    private int staffSpecializationID;
    private String specializationType;
    private String specializationName;

    /**
     * constructor without parameters
     */
    public StaffSpecialization() {
    }

    /**
     * contructor with parameters
     *
     * @param staffSpecializationID staff specialization id
     * @param specializationType    specialization type
     * @param specializationName    specialization name
     */
    public StaffSpecialization(final int staffSpecializationID, final String specializationType,
                               final String specializationName) {
        this.staffSpecializationID = staffSpecializationID;
        this.specializationType = specializationType;
        this.specializationName = specializationName;
    }

    /**
     * constructor with parameters
     *
     * @param specializationType spec. type
     * @param specializationName spec. name
     */
    public StaffSpecialization(final String specializationType, final String specializationName) {
        this.specializationType = specializationType;
        this.specializationName = specializationName;
    }


    /**
     * getter for spec. ID
     *
     * @return ID
     */
    public int getStaffSpecializationID() {
        return staffSpecializationID;
    }

    /**
     * getter for spec. type
     *
     * @return spec. type
     */
    public String getSpecializationType() {
        return specializationType;
    }

    /**
     * setter for spec. type
     *
     * @param specializationType spec. type
     */
    public void setSpecializationType(final String specializationType) {
        this.specializationType = specializationType;
    }

    /**
     * getter for spec. name
     *
     * @return spec. name
     */
    public String getSpecializationName() {
        return specializationName;
    }

    /**
     * setter for spec. name
     *
     * @param specializationName spec. name
     */
    public void setSpecializationName(final String specializationName) {
        this.specializationName = specializationName;
    }

    @Override
    public String toString() {
        return "Staff specialization{"
                + "ID=" + staffSpecializationID
                + ", specialization type='" + specializationType + '\''
                + ", specialization name='" + specializationName + '\''
                + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffSpecialization that = (StaffSpecialization) o;
        if (staffSpecializationID != that.staffSpecializationID) return false;
        if (!specializationType.equals(that.specializationType)) return false;
        return specializationName.equals(that.specializationName);
    }

    @Override
    public int hashCode() {
        int result = staffSpecializationID;
        result = 31 * result + specializationType.hashCode();
        result = 31 * result + specializationName.hashCode();
        return result;
    }
}
