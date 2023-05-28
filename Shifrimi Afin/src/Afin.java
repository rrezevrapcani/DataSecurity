public class Afin {
    static int a;
    static int b;

    public Afin(int a, int b) {
        Afin.a = a;
        Afin.b = b;
    }

    static String enkriptimi(char[] mesazhi) {

        StringBuilder mesazhiEnkriptuar = new StringBuilder();
        for (char c : mesazhi) {
            // injoro hapesirat
            /* aplikimi i formules ( a x + b ) mod m
            shtojme 'A' me e fit ne rangun e ascii kodit[ 65-90 | A-Z ] */
            if (c != ' ') {
                mesazhiEnkriptuar.append((char) ((((a * (c - 'A')) + b) % 26) + 'A'));
            } else // perndryshe vendos hapesire
            {
                mesazhiEnkriptuar.append(c);
            }
        }
        return mesazhiEnkriptuar.toString();
    }

    static String dekriptimi(String cipher) {
        StringBuilder mesazhi = new StringBuilder();
        int inverzi = 0;
        int flag;

        //gjejme inverzin
        for (int i = 0; i < 26; i++) {
            flag = (a * i) % 26;

            // kontrollo nese (a*i)%26 == 1,
            // atehere i = inverzi multiplikativ i a-se
            if (flag == 1) {
                inverzi = i;
            }
        }
        for (int i = 0; i < cipher.length(); i++) {
            /*aplikimi i formules per dekriptim a^-1 ( x - b ) mod m
            shtojme 'A' me e fit ne rangun e ascii kodit[ 65-90 | A-Z ] */
            if (cipher.charAt(i) != ' ') {
                mesazhi.append((char) (((inverzi * ((cipher.charAt(i) + 'A' - b)) % 26)) + 'A'));
            } else //perndryshe vendos hapesire
            {
                mesazhi.append(cipher.charAt(i));
            }
        }

        return mesazhi.toString();
    }


}
