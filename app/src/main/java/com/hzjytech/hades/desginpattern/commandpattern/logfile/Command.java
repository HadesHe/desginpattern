package com.hzjytech.hades.desginpattern.commandpattern.logfile;

import com.hzjytech.hades.desginpattern.logutil.LogOut;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by zhanghehe on 2017/10/22.
 */

abstract class Command implements Serializable{

    protected  String name;

    protected String args;

    protected ConfigOperator configOperator;

    public Command(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public ConfigOperator getConfigOperator() {
        return configOperator;
    }

    public void setConfigOperator(ConfigOperator configOperator) {
        this.configOperator = configOperator;
    }

    public abstract void execute(String args);

    public abstract void execute();
}

class InsertCommand extends Command{

    public InsertCommand(String name) {
        super(name);
    }

    @Override
    public void execute(String args) {
        this.args=args;
        configOperator.insert(args);

    }

    @Override
    public void execute() {
        configOperator.insert(this.args);

    }
}

class ModifyCommand extends Command{

    public ModifyCommand(String name) {
        super(name);
    }

    @Override
    public void execute(String args) {
        this.args=args;
        configOperator.modify(args);

    }

    @Override
    public void execute() {
        configOperator.modify(this.args);
    }
}

class DeleteCommand extends Command{

    public DeleteCommand(String name) {
        super(name);
    }

    @Override
    public void execute(String args) {
        this.args=args;
        configOperator.delete(args);

    }

    @Override
    public void execute() {
        configOperator.delete(this.args);

    }
}

class ConfigOperator implements Serializable{
    public void insert(String args){
        LogOut.println("insert:"+args);
    }

    public void modify(String args){
        LogOut.println("modify:"+args);
    }

    public void delete(String args){
        LogOut.println("delete:"+args);
    }


}

class ConfigSettingWindow{
    private ArrayList<Command> commands=new ArrayList<>();

    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call(String args){
        command.execute(args);
        commands.add(command);
    }

    public void save(){
        FileUtil.writeCommands(commands);
    }

    public void recover(){
        ArrayList<Command> list;
        list=FileUtil.readCommands();

        for (Command command1 : list) {
            command1.execute();
        }
    }
}

class FileUtil{

    public static void writeCommands(ArrayList commands){
        LogOut.println("write Commands");
    }

    public static ArrayList readCommands(){

        return new ArrayList();
    }



}
