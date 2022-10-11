package pojo;

public class Manager {
    private int id;
    private String username;
    private String password;
    private boolean permission;
    private String email;

    public Manager() {
    }

    public Manager(int id, String username, String password, boolean permission, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.permission = permission;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "manager{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", permission=" + permission +
                ", email='" + email + '\'' +
                '}';
    }
}
