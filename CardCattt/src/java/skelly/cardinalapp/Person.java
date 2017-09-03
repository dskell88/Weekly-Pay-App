package skelly.cardinalapp;


/**
 * The <code>Person</code> class is a superclass
 * @author dskelly
 * @version Card Cat Proj 1
 */
public abstract class Person {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
 
/**
 * Creates a <code>Person</code> with default values.
 */
public Person() {
    firstName = "";
    lastName = "";
    email = "";
    phoneNumber = "";
    
    
}


    /**
     * Returns a <code>String</code> that represents the Person's first name.
     * @return A <code>String</code> for the first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name to the specified <code>String</code>
     * @param firstName A <code>String</code> for the Person's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns a <code>String</code> that represents the Person's last name.
     * @return A <code>String</code> for the last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name to the specified <code>String</code>
     * @param lastName A <code>String</code> for the Person's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns a <code>String</code> that represents the Person's email.
     * @return A <code>String</code> for the Person's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email to the specified <code>String</code>
     * @param email A <code>String</code> for the Person's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns a <code>String</code> that represents the Person's phone number.
     * @return A <code>String</code> for the Person's email.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the last name to the specified <code>String</code>
     * @param phoneNumber A <code>String</code> for the Person's phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString()
    {
	String displayText =  
	     "Name: " + this.getFirstName() + " " + this.getLastName() + "\n" +
             "Email: " + this.getEmail() + "\n" +
             "Phone: " + this.getPhoneNumber() + "\n";
	return displayText;
    }
    abstract String getDisplayText();

    
}
