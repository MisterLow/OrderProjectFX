package orderprojectfx;


import javafx.scene.control.TextField;

/**
 *
 * @author Alexander
 */
public class NumField extends TextField{
    private int num;

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        setText(Integer.toString(num));
        this.num = num;
    }
    
}
