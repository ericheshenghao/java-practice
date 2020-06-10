package com.设计模式及实践.第三章__行为型模式.命令模式;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class main {
    public static void main(String[] args) {

    }
}

class dosome{
    public  void  performAction(ActionEvent e){
        Command source = (Command) e.getSource();
        source.execute();
    }
}
interface Command{
    public void execute();
}
class  OpenMenuItem extends JMenuItem implements Command{

    @Override
    public void execute() {
        System.out.println("打开一个文档");
    }
}

