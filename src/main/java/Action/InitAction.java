package Action;

import Action.SuperMarket.*;

import javax.swing.*;

public class InitAction {

    //初始化所有事件
    public static void initAction(JFrame jFrame){

        SuperMarketInfoAction.getJFrame(jFrame);
        ManageAction.getJFrame(jFrame);
        SuperMarketInsertAction.getJFrame(jFrame);
        SuperMarketDeleteAction.getJFrame(jFrame);
        SuperMarketSearchAction.getJFrame(jFrame);
        SuperMarketUpdateAction.getJFrame(jFrame);

    }
}
