public class PersonBuilder {
    protected String name = null;
    protected String surname = null;
    protected int age = -1;
    protected String address = null;

    public PersonBuilder setName(String name) {
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException("Name must have length > 0 and not null");

        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null || surname.length() == 0)
            throw new IllegalArgumentException("Surname must have length > 0 and not null");

        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0)
            throw new IllegalArgumentException("Age must be >= 0");

        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        if (address == null || address.length() == 0)
            throw new IllegalArgumentException("Name must have length > 0 and not null");

        this.address = address;
        return this;
    }

    public Person build() {
        if (this.name == null)
            throw new IllegalStateException("Name not initialized");
        if (this.surname == null)
            throw new IllegalStateException("Surname not initialized");

        Person p = null;

        if (age >= 0)
            p = new Person(this.name, this.surname, this.age);
        else
            p = new Person(this.name, this.surname);

        if (this.address != null)
            p.setAddress(this.address);

        return p;
    }
}