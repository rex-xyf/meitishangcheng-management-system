package pojo;

public class Department {
    private String text;
    private String value;

    public Department() {
    }

    public Department(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Department{" +
                "text='" + text + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
