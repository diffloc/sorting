package sorting;

import java.util.List;

public class InputParts<T> {

    private final List<T> parts;

    public InputParts(List<T> parts) {
        this.parts = parts;
    }

    public List<T> getParts() {
        return parts;
    }
}
