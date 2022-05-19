package ru.netology;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public boolean hasAge() {
        if (age == 0) {
            return false;
        }
        return true;
    }

    public boolean hasAddress() {
        if (city == null) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return city;
    }

    public void setAddress(String city) {
        this.city = city;
    }

    public void setAge(int age) {
        if (!hasAge()) {
            happyBirthday();
        } else {
            this.age = age;
        }
    }

    public void happyBirthday() {
        this.age = this.age + 1;
    }

    @Override
    public String toString() {
        return "Имя: " + this.name + " фамилия: " + this.surname + " проживает по адресу: " + this.city + " возраст: " + this.age;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + age;
        result = 31 * result + (name != null ? name.hashCode() : 0) + (surname != null ? surname.hashCode() : 0) + (city != null ? city.hashCode() : 0);
        return result;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname).setAddress(this.city);
    }
}
