package de.zedlitz.opendocument;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CellIterator implements Iterator<Cell> {
    private final Row row;
    private Cell next;

    CellIterator(Row row) {
        this.row = row;
        this.next = row.nextCell();
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public Cell next() {
        if (next == null) {
            throw new NoSuchElementException("No more cells available.");
        }
        Cell current = next;
        next = row.nextCell();
        return current;
    }
}
