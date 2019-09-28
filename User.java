public class User{
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    
    //No Argument Constructor
    public User(){

    }
    //Getters
    String getFristName(){
        return this.firstName;
    }
    String getLastName(){
        return this.lastName;
    }
    String getEmail(){
        return this.email;
    }
    String getPhoneNumber(){
        return this.phoneNumber;
    }
    String getPassword(){
        return this.password;
    }

    //Setters
    void setFirstName(String name){
        this.firstName = name;
    }
    void setLastName(String lastName){
        this.lastName = lastName;
    }
    void setEmail(String email){
        this.email = email; 
    }
    void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    void setPassword(String password){
        this.password = password;
    }
    
    //Class Methods
    //TODO
    public String toString(){
        String userAsString = "";
        
        return userAsString;
    }
}