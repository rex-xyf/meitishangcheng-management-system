package pojo;

public class manager {
    private int id;
    private String username;
    private String password;
    private boolean permission;
    private String name;

    public manager() {
    }

    public manager(int id, String username, String password, boolean permission, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.permission = permission;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "manager{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", permission=" + permission +
                ", name='" + name + '\'' +
                '}';
    }
}
