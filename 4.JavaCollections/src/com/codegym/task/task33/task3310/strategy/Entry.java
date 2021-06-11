package com.codegym.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Entry implements Serializable {
    final int hash;
    final Long key;
    String value;
    Entry next;

    public Entry(int hash, Long key, String value, Entry next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return this.key + "=" + this.value;
    }

    public int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
    }

    public final boolean equals(Object o) {
        if (o == this) {
            return true;
        } else {
            Long key1 = getKey();
            Long key2 = ((Entry)o).getKey();
            String value1 = getValue();
            String value2 = ((Entry)o).getValue();
                if (key1 == key2 && value1 == value2) {
                    return true;
                }
            return false;
        }
    }
}
