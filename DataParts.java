package sorting;

import java.util.List;

public class DataParts<T> {

    private final List<T> parts;

    public DataParts(List<T> parts) {
        this.parts = parts;
    }

    public List<T> getParts() {
        return parts;
    }

    public void setParts(List<?> part) {
        parts.addAll((List<T>) part);
    }
}
