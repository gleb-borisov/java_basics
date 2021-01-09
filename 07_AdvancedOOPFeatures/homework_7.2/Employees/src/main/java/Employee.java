import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Employee {

  private String name;
  private Integer salary;
  private Date workStart;

  public Employee(String name, Integer salary, Date workStart) {
    this.name = name;
    this.salary = salary;
    this.workStart = workStart;
  }

  public static List<Employee> loadStaffFromFile(String path) throws IOException {

    List<Employee> staff = new ArrayList<>();

    for (int i = 0; i < Files.lines(Paths.get(path))
            .flatMap(a -> Arrays.asList(a.split("\\n")).stream())
            .collect(Collectors.toList()).size(); i++) {

      staff.add(new Employee(

              Files.lines(Paths.get(path))
                      .flatMap(p -> Arrays.asList(p.split("\\t")).stream())
                      .filter(a -> a.matches("[^\\d\\.\\t]+"))
                      .collect(Collectors.toList()).get(i),

              Files.lines(Paths.get(path))
                      .flatMap(p -> Arrays.asList(p.split("\\t")).stream())
                      .filter(a -> a.matches("\\w+"))
                      .map((a) -> Integer.parseInt(a))
                      .collect(Collectors.toList()).get(i),

              Files.lines(Paths.get(path))
                      .flatMap(p -> Arrays.asList(p.split("\\t")).stream())
                      .filter(a -> a.matches("(\\d{2}).(\\d{2}).(\\d{4})"))
                      .map(a -> {
                        try {
                          return new SimpleDateFormat("dd.MM.yyyy").parse(a);
                        } catch (ParseException e) {
                          e.printStackTrace();
                        }
                        return null;
                      })
                      .collect(Collectors.toList()).get(i)));
    }
    return staff;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public Date getWorkStart() {
    return workStart;
  }

  public void setWorkStart(Date workStart) {
    this.workStart = workStart;
  }

  public String toString() {
    return name + " - " + salary + " - " +
        (new SimpleDateFormat("dd.MM.yyyy")).format(workStart);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(name, employee.name) &&
        Objects.equals(salary, employee.salary) &&
        Objects.equals(workStart, employee.workStart);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, salary, workStart);
  }

}
