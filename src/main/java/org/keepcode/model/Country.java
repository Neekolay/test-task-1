package org.keepcode.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Country {
    private Long id;
    private String name;

    public Country(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getLong("country");
        this.name = jsonObject.getString("country_text");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [id=" + id + ", name=" + name + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (!Objects.equals(id, country.id)) return false;
        return Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
