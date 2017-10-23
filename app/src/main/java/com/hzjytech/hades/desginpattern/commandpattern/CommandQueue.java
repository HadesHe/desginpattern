package com.hzjytech.hades.desginpattern.commandpattern;

import java.util.ArrayList;

/**
 * Created by zhanghehe on 2017/10/21.
 */

public class CommandQueue {

    private ArrayList<Command> commands=new ArrayList<>();

    public void addCommand(Command command){
        commands.add(command);
    }

    public void removeCommand(Command command){
        commands.remove(command);
    }

    public void execute(){
        for (Command command : commands) {
            command.execute();
        }
    }


}
