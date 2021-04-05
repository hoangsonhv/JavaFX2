package model;

import java.util.ArrayList;

public interface DataNguoiDung<N> {
    ArrayList<N> listND();
    boolean create(N n);
    boolean update(N n);
    boolean delete(N n);
}
