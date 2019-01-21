package com.kalcantrell;

import java.util.List;

public interface Saveable {
    List<String> serialize();
    void load(List<String> properties);
    String toString();
}
