package com.javarush.task.task36.task3608.model;

/**
 * Created by ac on 15.11.2017.
 */
public interface Model {
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long userId);
}
