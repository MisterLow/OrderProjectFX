package orderprojectfx;

import javafx.scene.input.KeyCode;

/**
 * Alexander Low
 * 991266865
 * Project
 * 2020/04/05
 */
public class KeyCodeCheck {

    /**
     * Checks if a code is an allowed character
     *
     * @param code
     * @return true if the is backspace, tab, or enter
     */
    public static boolean acceptableChar(KeyCode code) {
        return (code.toString().equals("BACK_SPACE") || code.toString().equals("TAB") || code.toString().equals("ENTER"));
    }
}
