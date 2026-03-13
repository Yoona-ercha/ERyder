public class Feedback{
    private String firstName;
    private String lastName;
    private String email;
    
    private String completeFeedback;
    private String reviewID;
    private boolean longFeedback;

    public Feedback(String firstName , String lastName , String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this. email = email;
    }

    public void analyseFeedback(boolean isConcatenation , String sent1 , String sent2 , String sent3 , String sent4 , String sent5){

        if(isConcatenation){
            completeFeedback = feedbackUsingConcatenation(sent1 , sent2 , sent3 , sent4 , sent5);
            checkFeedbackLength(completeFeedback);
            createReviewID(firstName , lastName , completeFeedback);
        }else{
            completeFeedback = feedbackUsingStringBuilder(sent1 , sent2 , sent3 , sent4 , sent5).toString();
            checkFeedbackLength(completeFeedback);
            createReviewID(firstName , lastName , completeFeedback);
        }
    }

    private String feedbackUsingConcatenation(String sent1 , String sent2 , String sent3 , String sent4 , String sent5){
        String concatenatedFeedback;
        concatenatedFeedback = sent1 + " " + sent2 + " " + sent3 + " " + sent4 + " " + sent5;
        return concatenatedFeedback;
    }

    private StringBuilder feedbackUsingStringBuilder(String sent1 , String sent2 , String sent3 , String sent4 , String sent5){
        StringBuilder sb = new StringBuilder();
        sb.append(sent1).append(" ");
        sb.append(sent2).append(" ");
        sb.append(sent3).append(" ");
        sb.append(sent4).append(" ");
        sb.append(sent5).append(" ");
        return sb;
    }

    private boolean checkFeedbackLength(String completeFeedback){
        if(completeFeedback.length() > 500){
            this.longFeedback = true;
        }else{
            this.longFeedback = false;
        }
        return this.longFeedback;
    }

    private void createReviewID(String firstName , String lastName , String completeFeedback){
        String namePart = (firstName + lastName).substring(2,6).toUpperCase();
        String feedbackPart = completeFeedback.substring(10,15).toLowerCase();
        String combined = namePart + feedbackPart + completeFeedback.length() + "_" + System.currentTimeMillis();
        combined = combined.replace(" ","");
        this.reviewID = combined;
    }

    @Override
    public String toString(){
        return "firstName: " + firstName + "\n" 
        + "lastName: " + lastName + "\n" 
        + "email: " + email + "\n" 
        + "completeFeedback: " + completeFeedback + "\n" 
        + "longFeedback: " + longFeedback + "\n" 
        + "reviewID: " + reviewID + "\n";
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }
}