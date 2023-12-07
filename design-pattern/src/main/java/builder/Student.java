package builder;

public class Student {
    private String name;
    private Integer age;

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private final Student student;

        public Builder() {
            this.student = new Student();
        }

        public Builder name(String name) {
            this.student.setName(name);
            return this;
        }

        public Builder age(Integer age) {
            this.student.setAge(age);
            return this;
        }

        public Student build() {
            return this.student;
        }
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
