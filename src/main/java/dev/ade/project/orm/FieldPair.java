package dev.ade.project.orm;

import java.util.Objects;

public class FieldPair {
    private String name;
    private Object value;
    private boolean isPrimaryKey;

    public FieldPair(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public FieldPair(String name, Object value, boolean isPrimaryKey) {
        this.name = name;
        this.value = value;
        this.isPrimaryKey = isPrimaryKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        isPrimaryKey = primaryKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldPair fieldPair = (FieldPair) o;
        return isPrimaryKey == fieldPair.isPrimaryKey && Objects.equals(name, fieldPair.name) && Objects.equals(value, fieldPair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value, isPrimaryKey);
    }

    @Override
    public String toString() {
        return "FieldPair{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", isPrimaryKey=" + isPrimaryKey +
                '}';
    }
}
