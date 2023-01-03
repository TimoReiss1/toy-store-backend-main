package com.oreilly.persistence.Factory;

public interface FactoryBean<A> {
    <T> T getObject() throws Exception;
    Class<?> getObjectType();
    boolean isSingleton();
}
