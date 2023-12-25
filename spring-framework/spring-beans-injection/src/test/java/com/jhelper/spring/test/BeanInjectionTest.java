package com.jhelper.spring.test;

import com.jhelper.spring.beans.Address;
import com.jhelper.spring.beans.Author;
import com.jhelper.spring.beans.Bike;
import com.jhelper.spring.beans.Boat;
import com.jhelper.spring.beans.Book;
import com.jhelper.spring.beans.Bus;
import com.jhelper.spring.beans.Car;
import com.jhelper.spring.beans.Course;
import com.jhelper.spring.beans.Department;
import com.jhelper.spring.beans.Employee;
import com.jhelper.spring.beans.Person;
import com.jhelper.spring.beans.Student;
import com.jhelper.spring.beans.Truck;
import com.jhelper.spring.beans.Van;
import com.jhelper.spring.config.AppConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BeanInjectionTest {

  private ApplicationContext applicationContext;

  @BeforeAll
  void setup() {
    applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
  }

  @Test
  void testConstructorInjectionWithBeanAnnotation() {
    Author author = applicationContext.getBean(Author.class);
    assertNotNull(author);
    author.setName("John Doe");

    Book book = applicationContext.getBean(Book.class);
    assertNotNull(book);
    assertEquals("John Doe", book.getAuthorName());
  }

  @Test
  void testSetterInjectionWithBeanAnnotation() {
    Course course = applicationContext.getBean(Course.class);
    assertNotNull(course);
    course.setName("Cyber Security Basics");

    Student student = applicationContext.getBean(Student.class);
    assertNotNull(student);
    assertEquals("Cyber Security Basics", student.getCourseName());
  }

  @Test
  void testConstructorInjectionWithStereotypeAnnotation() {
    Department department = applicationContext.getBean(Department.class);
    assertNotNull(department);
    department.setName("Human Resources");

    Employee employee = applicationContext.getBean(Employee.class);
    assertNotNull(employee);
    assertEquals("Human Resources", employee.getDepartmentName());
  }

  @Test
  void testSetterInjectionWithStereotypeAndAutowiredAnnotations() {
    Address address = applicationContext.getBean(Address.class);
    assertNotNull(address);
    address.setHouseNumber(51);

    Person person = applicationContext.getBean(Person.class);
    assertNotNull(person);
    assertEquals(51, person.getHouseNumber());
  }

  @Test
  void testFieldInjectionWithAutowiredAnnotation() {
    Truck truck = applicationContext.getBean(Truck.class);
    assertNotNull(truck);
    assertEquals(500, truck.getMaxTorque());
  }

  @Test
  void testFieldInjectionWithBeanAndAutowiredAnnotation() {
    Car car = applicationContext.getBean(Car.class);
    assertNotNull(car);
    assertEquals(500, car.getMaxTorque());
  }

  @Test
  void testFieldInjectionWithInjectAnnotation() {
    Bike bike = applicationContext.getBean(Bike.class);
    assertNotNull(bike);
    assertEquals(500, bike.getMaxTorque());
  }

  @Test
  void testSetterInjectionWithInjectAnnotation() {
    Van van = applicationContext.getBean(Van.class);
    assertNotNull(van);
    assertEquals(500, van.getMaxTorque());
  }

  @Test
  void testFieldInjectionWithResourceAnnotation() {
    Bus bus = applicationContext.getBean(Bus.class);
    assertNotNull(bus);
    assertEquals(500, bus.getMaxTorque());
  }

  @Test
  void testSetterInjectionWithResourceAnnotation() {
    Boat boat = applicationContext.getBean(Boat.class);
    assertNotNull(boat);
    assertEquals(500, boat.getMaxTorque());
  }
}
