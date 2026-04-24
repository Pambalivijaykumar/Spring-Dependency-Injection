# Spring-Dependency-Injection

#Spring Dependency Injection (DI) – Example

This project demonstrates **Dependency Injection (DI)** in Spring using three approaches:

* byType
* byName
* constructor

The example uses two classes:

* `User` → dependent class
* `Address` → dependency

---

# What is Dependency Injection?

Dependency Injection (DI) is a design pattern where **Spring creates objects and injects their dependencies**, instead of objects creating them manually.

### Example

Instead of:

```
User user = new User("Vijay", 22, new Address());
```

Spring does:

* Create `Address`
* Inject it into `User`

---

# Project Structure

```
com.module
 ├── User.java
 └── Address.java

resources
 └── beans.xml

com
 └── SpringContext.java
```

---

# Beans Configuration (beans.xml)

```xml
<bean id="user" class="com.module.User" autowire="constructor">
  <constructor-arg value="Vijay"/>
  <constructor-arg value="22"/>
  <constructor-arg ref="address"/>
</bean>

<bean id="address" class="com.module.Address">
    <constructor-arg value="Medchal"/>
    <constructor-arg value="500078"/>
</bean>
```

---

# Important Fixes (From Given Code)

You had:

* Duplicate bean IDs (`address`)
* Mixed `autowire="constructor"` + `constructor-arg`

### Correct Rules:

* Bean IDs must be unique
* Use **either autowire OR constructor-arg**, not both unnecessarily

---

# Types of Dependency Injection

---

## 1 byType

👉 Injection happens based on **data type**

### ✔ Example

```xml
<bean id="address" class="com.module.Address"/>

<bean id="user" class="com.module.User" autowire="byType"/>
```

### How it works:

* Spring checks: `private Address address;`
* Finds bean of type `Address`
* Injects it

### Limitation:

* Multiple beans of same type → error

---

## 2️ byName

 Injection happens based on **property name**

### ✔ Example

```xml
<bean id="address" class="com.module.Address"/>

<bean id="user" class="com.module.User" autowire="byName"/>
```

###  How it works:

* Field name: `address`
* Spring looks for bean with id `"address"`
* Injects it

###  Limitation:

* Name must match exactly
* Otherwise → dependency remains `null`

---

## 3️ constructor

Injection happens through **constructor parameters**

### ✔ Example (Recommended)

```xml
<bean id="user" class="com.module.User">
  <constructor-arg value="Vijay"/>
  <constructor-arg value="22"/>
  <constructor-arg ref="address"/>
</bean>
```

### How it works:

* Matches constructor:

  ```
  User(String name, int id, Address address)
  ```
* Injects values accordingly

---

###  About Autowire Constructor

```xml
<bean id="user" class="com.module.User" autowire="constructor"/>
```

* Spring automatically matches constructor arguments
* Less control compared to explicit configuration

---

#  Comparison Table

| Type        | Based On      | Advantage         | Limitation                    |
| ----------- | ------------- | ----------------- | ----------------------------- |
| byType      | Data type     | Simple            | Multiple beans → error        |
| byName      | Property name | Clear mapping     | Name must match exactly       |
| constructor | Parameters    | Immutable objects | Can be complex with many args |

---

#    Output

```
User [name=Vijay, id=22, address=Address [village=Medchal, zipCode=500078]]
```

---
