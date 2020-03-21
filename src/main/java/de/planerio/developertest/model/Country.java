package de.planerio.developertest.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String language;

    public Country() {
    }

    public Country(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return getId() == country.getId() &&
                Objects.equal(getName(), country.getName()) &&
                Objects.equal(getLanguage(), country.getLanguage());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getName(), getLanguage());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("language", language)
                .toString();
    }
}
