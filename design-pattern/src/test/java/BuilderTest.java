import builder.Builder;
import builder.Student;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuilderTest {
    @Test
    public void obj() {
        String name = "zhangsan";
        int age = 10;
        Student student = Student.builder().name(name).age(age).build();
        assertEquals(student.getName(), name);
        assertEquals(student.getAge(), age);
    }

    @Test
    public void builder() {
        String name = "zhangsan";
        int age = 20;
        Predicate<Integer> predictor = it -> it < 100;
        Student student = Builder.of(Student::new)
                .with(Student::setName, name)
                .with(Student::setAge, age, predictor)
                .build();
        assertEquals(student.getName(), name);
        assertEquals(student.getAge(), age);
    }
}
