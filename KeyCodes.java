import java.util.HashMap;
import java.util.Map;
/**The class {@code KeyCodes}, contains all of the KeyCodes with their 
 * respective keys.
 */
public class KeyCodes {
    
        private Map<Integer, String> keyMap = new HashMap<>();
        public KeyCodes() {
            keyMap.put(3, "CANCEL");
            keyMap.put(8, "BACKSPACE");
            keyMap.put(9, "TAB");
            keyMap.put(10, "ENTER");
            keyMap.put(12, "CLEAR");
            keyMap.put(16, "SHIFT");
            keyMap.put(17, "CTRL");
            keyMap.put(18, "ALT");
            keyMap.put(19, "PAUSE");
            keyMap.put(20, "CAPS_LOCK");
            keyMap.put(21, "KANA");
            keyMap.put(24, "FINAL");
            keyMap.put(25, "KANJI");
            keyMap.put(27, "ESCAPE");
            keyMap.put(28, "CONVERT");
            keyMap.put(29, "NO_CONVERT");
            keyMap.put(30, "ACCEPT");
            keyMap.put(31, "MODE_CHANGE");
            keyMap.put(32, "SPACE");
            keyMap.put(33, "PAGE_UP");
            keyMap.put(34, "PAGE_DOWN");
            keyMap.put(35, "END");
            keyMap.put(36, "HOME");
            keyMap.put(37, "LEFT");
            keyMap.put(38, "UP");
            keyMap.put(39, "RIGHT");
            keyMap.put(40, "DOWN");
            keyMap.put(44, "COMMA");
            keyMap.put(45, "MINUS");
            keyMap.put(46, "PERIOD");
            keyMap.put(47, "SLASH");
            keyMap.put(48, "NUM_0");
            keyMap.put(49, "NUM_1");
            keyMap.put(50, "NUM_2");
            keyMap.put(51, "NUM_3");
            keyMap.put(52, "NUM_4");
            keyMap.put(53, "NUM_5");
            keyMap.put(54, "NUM_6");
            keyMap.put(55, "NUM_7");
            keyMap.put(56, "NUM_8");
            keyMap.put(57, "NUM_9");
            keyMap.put(59, "SEMICOLON");
            keyMap.put(61, "EQUALS");
            keyMap.put(65, "A");
            keyMap.put(66, "B");
            keyMap.put(67, "C");
            keyMap.put(68, "D");
            keyMap.put(69, "E");
            keyMap.put(70, "F");
            keyMap.put(71, "G");
            keyMap.put(72, "H");
            keyMap.put(73, "I");
            keyMap.put(74, "J");
            keyMap.put(75, "K");
            keyMap.put(76, "L");
            keyMap.put(77, "M");
            keyMap.put(78, "N");
            keyMap.put(79, "O");
            keyMap.put(80, "P");
            keyMap.put(81, "Q");
            keyMap.put(82, "R");
            keyMap.put(83, "S");
            keyMap.put(84, "T");
            keyMap.put(85, "U");
            keyMap.put(86, "V");
            keyMap.put(87, "W");
            keyMap.put(88, "X");
            keyMap.put(89, "Y");
            keyMap.put(90, "Z");
            keyMap.put(91, "OPEN_BRACKET");
            keyMap.put(92, "BACK_SLASH");
            keyMap.put(93, "CLOSE_BRACKET");
            keyMap.put(96, "NUMPAD_0");
            keyMap.put(97, "NUMPAD_1");
            keyMap.put(98, "NUMPAD_2");
            keyMap.put(99, "NUMPAD_3");
            keyMap.put(100, "NUMPAD_4");
            keyMap.put(101, "NUMPAD_5");
            keyMap.put(102, "NUMPAD_6");
            keyMap.put(103, "NUMPAD_7");
            keyMap.put(104, "NUMPAD_8");
            keyMap.put(105, "NUMPAD_9");
            keyMap.put(106, "NUMPAD_MULTIPLY");
            keyMap.put(107, "NUMPAD_ADD");
            keyMap.put(108, "NUMPAD_COMMA");
            keyMap.put(109, "NUMPAD_SUBTRACT");
            keyMap.put(110, "NUMPAD_PERIOD");
            keyMap.put(111, "NUMPAD_DIVIDE");
            keyMap.put(112, "F1");
            keyMap.put(113, "F2");
            keyMap.put(114, "F3");
            keyMap.put(115, "F4");
            keyMap.put(116, "F5");
            keyMap.put(117, "F6");
            keyMap.put(118, "F7");
            keyMap.put(119, "F8");
            keyMap.put(120, "F9");
            keyMap.put(121, "F10");
            keyMap.put(122, "F11");
            keyMap.put(123, "F12");
            keyMap.put(127, "DELETE");
            keyMap.put(144, "NUM_LOCK");
            keyMap.put(145, "SCROLL_LOCK");
            keyMap.put(150, "AMPERSAND");
            keyMap.put(151, "ASTERISK");
            keyMap.put(152, "DOUBLE_QUOTE");
            keyMap.put(153, "LESS");
            keyMap.put(154, "PRINT_SCREEN");
            keyMap.put(155, "INSERT");
            keyMap.put(156, "HELP");
            keyMap.put(160, "GREATER");
            keyMap.put(161, "LEFT_BRACE");
            keyMap.put(162, "RIGHT_BRACE");
            keyMap.put(192, "BACK_QUOTE");
            keyMap.put(222, "QUOTE");
            keyMap.put(224, "UP_ARROW");
            keyMap.put(225, "DOWN_ARROW");
            keyMap.put(226, "LEFT_ARROW");
            keyMap.put(227, "RIGHT_ARROW");
            keyMap.put(512, "AT");
            keyMap.put(513, "COLON");
            keyMap.put(515, "DOLLAR");
            keyMap.put(516, "EURO");
            keyMap.put(517, "EXCLAMATION_MARK");
            keyMap.put(519, "LEFT_PARENTHESIS");
            keyMap.put(520, "NUMBER_SIGN");
            keyMap.put(521, "PLUS");
            keyMap.put(522, "RIGHT_PARENTHESIS");
            keyMap.put(523, "UNDERSCORE");
            keyMap.put(524, "WINDOWS");
        }
        /**
         * Given a keycode, will return a String of the key that corresponds.
         * @param keyCode
         * @return String of the Key
         */
        public String getKey(int keyCode) {
            return keyMap.get(keyCode);
        }

}