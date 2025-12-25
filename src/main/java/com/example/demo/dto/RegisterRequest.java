public class RegisterRequest {

    private String fullName;
    private String email;
    private String password;
    private String role;

    // Test-required
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Test-required
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Controller-required alias
    public String getUsername() {
        return email;
    }

    public void setUsername(String username) {
        this.email = username;
    }

    // Controller-required
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
