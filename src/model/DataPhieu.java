package model;

import java.util.ArrayList;

public interface DataPhieu<P> {
    ArrayList<P> listPM();
    boolean create(P p);
    boolean update(P p);
    boolean delete(P p);
}
