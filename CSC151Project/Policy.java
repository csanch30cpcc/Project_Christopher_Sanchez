/**
 * The Policy class stores information about an insurance policy and its
 * policyholder. It also calculates the policyholder's body mass index (BMI)
 * and the price of the insurance policy.
 */
public class Policy {
    private int policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    /**
     * Creates a Policy object with default values.
     */
    public Policy() {
        policyNumber = 0;
        providerName = "";
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }

    /**
     * Creates a Policy object with the supplied policy and policyholder data.
     *
     * @param policyNumber the insurance policy number
     * @param providerName the name of the insurance provider
     * @param firstName the policyholder's first name
     * @param lastName the policyholder's last name
     * @param age the policyholder's age in years
     * @param smokingStatus the policyholder's smoking status
     * @param height the policyholder's height in inches
     * @param weight the policyholder's weight in pounds
     */
    public Policy(int policyNumber, String providerName, String firstName,
                  String lastName, int age, String smokingStatus,
                  double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Sets the insurance policy number.
     *
     * @param policyNumber the new insurance policy number
     */
    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * Gets the insurance policy number.
     *
     * @return the insurance policy number
     */
    public int getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Sets the insurance provider's name.
     *
     * @param providerName the new insurance provider's name
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * Gets the insurance provider's name.
     *
     * @return the insurance provider's name
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Sets the policyholder's first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the policyholder's first name.
     *
     * @return the policyholder's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the policyholder's last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the policyholder's last name.
     *
     * @return the policyholder's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the policyholder's age.
     *
     * @param age the new age in years
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the policyholder's age.
     *
     * @return the policyholder's age in years
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the policyholder's smoking status.
     *
     * @param smokingStatus the new smoking status
     */
    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    /**
     * Gets the policyholder's smoking status.
     *
     * @return the policyholder's smoking status
     */
    public String getSmokingStatus() {
        return smokingStatus;
    }

    /**
     * Sets the policyholder's height.
     *
     * @param height the new height in inches
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Gets the policyholder's height.
     *
     * @return the policyholder's height in inches
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the policyholder's weight.
     *
     * @param weight the new weight in pounds
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Gets the policyholder's weight.
     *
     * @return the policyholder's weight in pounds
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Calculates the policyholder's body mass index (BMI).
     *
     * @return the BMI, or 0.0 when the height is not positive
     */
    public double calculateBMI() {
        if (height <= 0.0) {
            return 0.0;
        }
        return (weight * 703.0) / (height * height);
    }

    /**
     * Calculates the insurance policy price using the policyholder's age,
     * smoking status, and BMI.
     *
     * @return the calculated insurance policy price
     */
    public double calculatePolicyPrice() {
        double price = 600.0;

        if (age > 50) {
            price += 75.0;
        }

        if (smokingStatus.equalsIgnoreCase("smoker")) {
            price += 100.0;
        }

        if (calculateBMI() > 35.0) {
            price += (calculateBMI() - 35.0) * 20.0;
        }

        return price;
    }
}
