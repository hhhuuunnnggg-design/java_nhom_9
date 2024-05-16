package DTO;

public class user {
   private String username;
   private String password;
   private String role;
   public user (String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
      
    }

    public String username() {
        return username;
    }
    public String password() {
        return password;
    }
    public String role() {
        return role;
    }

    public void setusername(String username) {
        this.username = username;
    }
    public void setpassword(String password) {
        this.password = password;
    }
    public void setrole(String role) {
        this.role = role;
    }
   
}
