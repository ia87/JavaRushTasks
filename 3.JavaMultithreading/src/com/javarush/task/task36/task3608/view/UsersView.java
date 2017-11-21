package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * Created by ac on 16.11.2017.
 */
public class UsersView implements View {
    private Controller controller;
    @Override
    public void refresh(ModelData modelData) {
        System.out.println(modelData.isDisplayDeletedUserList() ? "All deleted users:" : "All users:");
        for (User user :
                modelData.getUsers()) {
            System.out.println("\t"+user);
        }
        System.out.println("===================================================");
    }

    public void fireEventShowAllUsers(){
        if(controller!=null) controller.onShowAllUsers();
    }
    public void fireEventShowDeletedUsers() {if(controller!=null) controller.onShowAllDeletedUsers(); }
    public void fireEventOpenUserEditForm(long id) {if(controller!=null) controller.onOpenUserEditForm(id); }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
