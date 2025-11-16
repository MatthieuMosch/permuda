package nl.novi.matthieu.permuda.model;

public class User {
    private String username;
    private String password;
    private String email;

    // getters (no password getter)
    public String getUsername() {return username;}
    public String getEmail() {return email;}

    // setters
    public void setUsername(String username) {this.username = username;}
    public void setPassword(String password) {this.password = password;}
    public void setEmail(String email) {this.email = email;}
}
