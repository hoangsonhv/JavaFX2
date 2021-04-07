package model;

import java.util.ArrayList;

public interface DataPhieu<P> {
    ArrayList<P> listPM();
    boolean createP(P p);
    boolean updateP(P p);
    boolean deleteP(P p);
}
