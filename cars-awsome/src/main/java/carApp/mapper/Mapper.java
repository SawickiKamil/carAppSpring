package carApp.mapper;

public interface Mapper<F, T> {
    
    T map(F from);

    F revers(T to);
}