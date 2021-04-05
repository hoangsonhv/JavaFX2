package model;

import java.util.ArrayList;

public interface DataAccsessObject<T> {
    ArrayList<T> getList();
    boolean create(T t);
    boolean update(T t);
    boolean delete(T t);
}
