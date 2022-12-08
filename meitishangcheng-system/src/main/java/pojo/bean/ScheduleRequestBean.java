package pojo.bean;

public class ScheduleRequestBean {
    private int id;
    private String name;
    private int daysOff;

    public ScheduleRequestBean() {
    }

    public ScheduleRequestBean(int id, String name, int daysOff) {
        this.id = id;
        this.name = name;
        this.daysOff = daysOff;
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

    public int getDaysOff() {
        return daysOff;
    }

    public void setDaysOff(int daysOff) {
        this.daysOff = daysOff;
    }

    @Override
    public String toString() {
        return "ScheduleRequestBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", daysOff=" + daysOff +
                '}';
    }
}
