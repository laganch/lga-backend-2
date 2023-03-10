package com.government.government.repository.app;

public interface QueryResultTransformer<E, T> {

    T transaform(E e);
}
