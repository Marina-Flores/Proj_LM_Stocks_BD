package Repositories.Shared;

import java.util.List;

public interface IRepository<T> {
	void Insert(T entity);
    void Update(T entity, String identificador);
    boolean Remove(String identificador);
    T Get(String identificador);
    List<T> GetAll(); 
}
