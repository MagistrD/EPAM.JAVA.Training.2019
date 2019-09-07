package by.epam.hospital.entities;

/**
 * user
 */
public class User {
    private int id;
    private String username;
    private String password;
    private int peopleID;
    private String type;
    private String subType;

    /**
     * constructor without parameters
     */
    public User() {
    }

    /**
     * constructor with parameters
     *
     * @param username username
     * @param password password
     * @param peopleID people id
     * @param type     type
     */
    public User(final String username, final String password, final int peopleID, final String type) {
        this.username = username;
        this.password = password;
        this.peopleID = peopleID;
        this.type = type;
    }

    /**
     * constructor with parameters
     *
     * @param id       id
     * @param username username
     * @param password password
     * @param peopleID people id
     * @param type     type
     */
    public User(final int id, final String username, final String password, final int peopleID, final String type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.peopleID = peopleID;
        this.type = type;
    }

    /**
     * constructor with parameters
     *
     * @param id       id
     * @param username username
     * @param password password
     * @param peopleID people id
     * @param type     type
     * @param subType  subtype
     */
    public User(final int id, final String username, final String password, final int peopleID, final String type,
                final String subType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.peopleID = peopleID;
        this.type = type;
        this.subType = subType;
    }

    /**
     * getter for id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * setter for id
     *
     * @param id id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * getter for username
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * setter for username
     *
     * @param username username
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * getter for password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter for password
     *
     * @param password password
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * getter for people id
     *
     * @return people id
     */
    public int getPeopleID() {
        return peopleID;
    }

    /**
     * setter for people id
     *
     * @param peopleID people id
     */
    public void setPeopleID(final int peopleID) {
        this.peopleID = peopleID;
    }

    /**
     * getter for type
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * setter for type
     *
     * @param type type
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * getter for subtype
     *
     * @return subtype
     */
    public String getSubType() {
        return subType;
    }

    /**
     * setter for subtype
     *
     * @param subType subtype
     */
    public void setSubType(final String subType) {
        this.subType = subType;
    }
}
