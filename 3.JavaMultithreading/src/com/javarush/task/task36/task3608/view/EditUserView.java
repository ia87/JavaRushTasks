package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * Created by ac on 21.11.2017.
 */
public class EditUserView implements View {
    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        System.out.println("User to be edited:");
            System.out.println("\t"+modelData.getActiveUser());
        System.out.println("===================================================");
    }

    public void fireEventUserDeleted(long id){if(controller!=null) controller.onUserDelete(id);}
    public void fireEventUserChanged(String name, long id, int level) {if(controller!=null) controller.onUserChange(name, id, level);}


    @Override
    public void setController(Controller controller) {
        this.controller=controller;
    }
}
