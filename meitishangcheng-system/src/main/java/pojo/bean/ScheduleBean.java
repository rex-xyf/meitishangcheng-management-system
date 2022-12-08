package pojo.bean;

import pojo.Schedule;

import java.util.List;

public class ScheduleBean {
    private List<Schedule> schedules;
    private int count;

    public ScheduleBean() {
    }

    public ScheduleBean(List<Schedule> schedules, int count) {
        this.schedules = schedules;
        this.count = count;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ScheduleBean{" +
                "schedules=" + schedules +
                ", count=" + count +
                '}';
    }
}
