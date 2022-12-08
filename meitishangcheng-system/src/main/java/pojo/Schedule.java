package pojo;

public class Schedule {
    private int id;
    private String name;
    private String username;
    private Boolean attendance;
    private Boolean leave;
    private int daysOff;
    private int state;

    public Schedule() {
    }

    public Schedule(int id, String name, String username, Boolean attendance, Boolean leave, int daysOff, int state) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.attendance = attendance;
        this.leave = leave;
        this.daysOff = daysOff;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getAttendance() {
        return attendance;
    }

    public void setAttendance(Boolean attendance) {
        this.attendance = attendance;
    }

    public Boolean getLeave() {
        return leave;
    }

    public void setLeave(Boolean leave) {
        this.leave = leave;
    }

    public int getDaysOff() {
        return daysOff;
    }

    public void setDaysOff(int daysOff) {
        this.daysOff = daysOff;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", attendance=" + attendance +
                ", leave=" + leave +
                ", daysOff=" + daysOff +
                ", state=" + state +
                '}';
    }
}
