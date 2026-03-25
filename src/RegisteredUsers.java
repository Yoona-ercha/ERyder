public class RegisteredUsers {

    private String fullName;
    private String emailAddress;
    private String dateOfBirth;
    private long cardNumber;
    private String cardExpiryDate;
    private String cardProvider;
    private int cvv;
    private String userType;
    private String[] lastThreeTrips;

    public RegisteredUsers(){}
    
    public RegisteredUsers(String fullName, String emailAddress, String dateOfBirth, long cardNumber, String cardExpiryDate, String cardProvider, int cvv, String userType, String[] lastThreeTrips) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.cardNumber = cardNumber;
        this.cardExpiryDate = cardExpiryDate;
        this.cardProvider = cardProvider;
        this.cvv = cvv;
        this.userType = userType;
        this.lastThreeTrips = lastThreeTrips;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public String getCardProvider() {
        return cardProvider;
    }

    public int getCvv() {
        return cvv;
    }

    public String getUserType() {
        return userType;
    }

    public String[] getLastThreeTrips() {
        return lastThreeTrips;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public void setCardProvider(String cardProvider) {
        this.cardProvider = cardProvider;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setLastThreeTrips(String[] lastThreeTrips) {
        this.lastThreeTrips = lastThreeTrips;
    }

    @Override
    public String toString(){
        return "Registration successful! Here are your details:\n" 
        + "User Type: " + userType + "\n" 
        + "Full Name: " + fullName + "\n" 
        + "Email Address: " + emailAddress + "\n" 
        + "Date of Birth: " + dateOfBirth + "\n" 
        + "Card Number: " + cardNumber + "\n" 
        + "Card Expiry Date: " + cardExpiryDate + "\n"
        + "Card Provider: " + cardProvider + "\n" 
        + "CVV: " + cvv + "\n"
        + "Last Thress Trips" + lastThreeTrips;
    }
    
}
