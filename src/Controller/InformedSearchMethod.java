package Controller;

import Domain.Table;

import java.util.List;

public abstract class InformedSearchMethod<T> implements SearchMethod {
    abstract T getBestFit(List<T> population);
}
