package entity;

import javax.persistence.*;

@Entity
public class User {
    @Id
    private int id;
    private String namik;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamik() {
        return namik;
    }

    public void setNamik(String namik) {
        this.namik = namik;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (namik != null ? !namik.equals(user.namik) : user.namik != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (namik != null ? namik.hashCode() : 0);
        return result;
    }
}
