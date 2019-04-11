package entities;

/**
 * Describe Diagnosis's entity.
 */
public class Diagnosis {
    /**
     * Name of diagnosis.
     */
    private String name;

    /**
     * Constructor without parameters.
     */
    public Diagnosis() {
    }

    /**
     * Constructor with parameters.
     *
     * @param name name of diagnosis.
     */
    public Diagnosis(final String name) {
        this.name = name;
    }


    /**
     * Getter for diagnosis name.
     *
     * @return name of diagnosis
     */
    public String getName() {
        return name;
    }

    /**
     * setter for name of diagnosis
     *
     * @param name name of diagnosis
     */
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
