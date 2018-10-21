import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Owner {

    private String fName, lName;
    private String username, password; //use StringBuilder to create these
    private String dob; //only over 18 allowed
    private String[] countries = {"Finland", "Sweden", "Norway", "Germany", "United Kingdom", "Spain"};
    private String country;
    private String phoneNb;
    private String email;

    private String NOT_MATCH = "s do not match";
    private String TOO_YOUNG = "You are too young";

    public void setOwnerName(String fName, String lName) {
        if (testAlphabet(fName) && testAlphabet(lName)) {
            this.fName = fName;
            this.lName = lName;
        }
    }

    public void setUsername(String username) {
        int counter = 0;
        for( int i=0; i<username.length(); i++ ) {
            if( username.charAt(i) == '_' ) {
                counter++;
            }
        }

        if (counter<=1 && username.length()<=15) {
            this.username = username;
        }
    }

    public void setPassword(String password, String pwCheck) {
        if (password.equals(pwCheck) && password.length() >= 8){
            this.password = password;
        }else {
            System.out.println("passwords " + NOT_MATCH);
        }
    }

    public void setCountry(int cCode) {

        this.country = countries[cCode];

    }

    public void setDob(String dob) {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();
        LocalDate birth = LocalDate.parse(dob,dt);

        if (ChronoUnit.YEARS.between(birth,today)<18){
            System.out.println(TOO_YOUNG);
        }else {
            this.dob = dob;
        }
    }

    public void setPhoneNb(String phoneNb) {
        try {
            Integer.parseInt(phoneNb);
            this.phoneNb = phoneNb;
        }
        catch (NumberFormatException e) {
            // phoneNb is not numeric
            System.out.println("Invalid Phone Number");
        }
    }

    public void setEmail(String email, String emailCheck) {
        if (email.equals(emailCheck)){
            this.email = email;
        }else {
            System.out.println("email" + NOT_MATCH);
        }
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDob() {
        return dob;
    }

    public String[] getCountries() {
        return countries;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNb() {
        return phoneNb;
    }

    public String getEmail() {
        return email;
    }

    private boolean testAlphabet(String test){
        return test.chars().allMatch(Character::isLetter);
    }
}
