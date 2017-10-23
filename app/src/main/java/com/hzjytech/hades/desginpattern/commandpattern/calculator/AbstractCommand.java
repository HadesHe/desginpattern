package com.hzjytech.hades.desginpattern.commandpattern.calculator;

/**
 * Created by zhanghehe on 2017/10/21.
 */

abstract class AbstractCommand {

    public abstract int execute(int value);

    public abstract int undo();
}
