# Hands-on 4: Difference between JPA, Hibernate and Spring Data JPA

## Aim

To understand the difference between JPA, Hibernate, and Spring Data JPA.

---

## 1. Java Persistence API (JPA)

* JPA stands for **Java Persistence API**.
* It is a **specification (JSR 338)** for persisting, reading, and managing data from Java objects.
* JPA only defines the rules and interfaces.
* It does **not** provide any implementation.
* Hibernate is one of the most popular implementations of JPA.

### Features

* Standard API for persistence.
* Uses annotations such as `@Entity`, `@Table`, `@Id`, and `@Column`.
* Database independent.

---

## 2. Hibernate

* Hibernate is an **ORM (Object Relational Mapping)** framework.
* It is an implementation of JPA.
* It converts Java objects into database tables and vice versa.
* Hibernate manages sessions and transactions manually.

### Hibernate Example

```java
public Integer addEmployee(Employee employee) {

    Session session = factory.openSession();
    Transaction tx = null;
    Integer employeeID = null;

    try {
        tx = session.beginTransaction();
        employeeID = (Integer) session.save(employee);
        tx.commit();
    } catch (HibernateException e) {
        if (tx != null)
            tx.rollback();
        e.printStackTrace();
    } finally {
        session.close();
    }

    return employeeID;
}
```

---

## 3. Spring Data JPA

* Spring Data JPA is a Spring Framework module.
* It does not implement JPA.
* It works on top of JPA implementations like Hibernate.
* It reduces boilerplate code by providing built-in repository methods.
* It automatically manages transactions using `@Transactional`.

### Spring Data JPA Example

**EmployeeRepository.java**

```java
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
```

**EmployeeService.java**

```java
@Autowired
private EmployeeRepository employeeRepository;

@Transactional
public void addEmployee(Employee employee) {
    employeeRepository.save(employee);
}
```

---

# Comparison Table

| Feature                | JPA                       | Hibernate      | Spring Data JPA                              |
| ---------------------- | ------------------------- | -------------- | -------------------------------------------- |
| Type                   | Specification             | ORM Framework  | Spring Module                                |
| Implementation         | No                        | Yes            | No                                           |
| Purpose                | Defines persistence rules | Implements JPA | Simplifies JPA/Hibernate                     |
| ORM Tool               | No                        | Yes            | Uses Hibernate internally                    |
| Transaction Management | No                        | Manual         | Automatic using `@Transactional`             |
| Boilerplate Code       | More                      | Moderate       | Very Less                                    |
| CRUD Operations        | Manual                    | Manual         | Built-in (`save()`, `findAll()`, `delete()`) |

---

# Difference Between Hibernate and Spring Data JPA

### Hibernate

* Open Session
* Begin Transaction
* Save Object
* Commit Transaction
* Close Session

Requires more code.

### Spring Data JPA

Only one statement is required:

```java
employeeRepository.save(employee);
```

Spring automatically manages:

* Session
* Transaction
* Commit
* Rollback
* Resource cleanup

---

# Conclusion

* **JPA** is a specification that defines how Java objects are persisted.
* **Hibernate** is an ORM framework that implements JPA.
* **Spring Data JPA** is a Spring module that simplifies Hibernate by reducing boilerplate code and providing ready-to-use repository methods.

Spring Data JPA is preferred in Spring Boot applications because it requires less code, provides automatic transaction management, and makes database operations easier.
