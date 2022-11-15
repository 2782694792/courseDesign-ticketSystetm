package 课程设计;

import java.awt.*;

public class prefund0{
    public static void main(String args[]) {
	    // JFrame window = new JFrame("practice");   //窗口标题
    	prefund win = new prefund();
    	Container win1 = win.getContentPane();       //初始化容器,使得便于添加控件 
		win.setBounds(750,50,592,660);              //距左,距顶,窗口宽度,高度 
    	win1.setBackground(Color.LIGHT_GRAY);        //窗口背景颜色
	}
}