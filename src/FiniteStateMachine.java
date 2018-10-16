import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FiniteStateMachine {

    // State Table
   
    private final static int [][] STATE_TABLE =
    {
        // c,  e,  i,  m,  n,  o,  r,  t, other
        {  1,  0,  6, 11, 17, 21,  0,  0,  0}, //State 0
        {  1,  0,  2, 11, 17, 21,  0,  0,  0}, //State 1
        {  1,  0,  6, 11, 17,  7,  0,  3,  0}, //State 2
        {  1,  4,  6,  11,  17,  21,  0,  0,  0}, //State 3
        {  1,  0,  6,  11,  17,  21,  5,  0,  0}, //State 4
        {  1,  0,  6,  11,  17,  21,  0,  0,  0}, //State 5
        {  1,  0,  6,  11,  17,  7,  0,  0,  0}, //State 6
        {  1,  0,  6,  11,  8,  21,  0,  0,  0}, //State 7
        {  1,  0,  9,  11,  17,  18,  0,  0,  0}, //State 8
        {  10, 0,  6, 11,  17,  24,  0,  0,  0}, //State 9
        {  1,  0,  2, 11,  17,  21,  0,  0,  0}, //State 10
        {  1,  0,  6,  11,  17,  12,  0,  0,  0}, //State 11
        {  1,  0,  6,  11,  22,  21,  0,  13,  0}, //State 12
        {  1,  0,  14,  11,  17,  21,  0,  0,  0}, //State 13
        {  1,  0,  6,  11,  17,  15,  0,  0,  0}, //State 14
        {  1,  0,  6,  11,  16,  21,  0,  0,  0}, //State 15
        {  1,  0,  9,  11,  17,  18,  0,  0,  0}, //State 16
        {  1,  0,  6,  11,  17,  18,  0,  0,  0}, //State 17
        {  1,  0,  6,  11,  22,  21,  19,  0,  0}, //State 18
        {  1,  0,  6,  20,  17,  21,  0,  0,  0}, //State 19
        {  1,  0,  6,  11,  17,  12,  0,  0,  0}, //State 20
        {  1,  0,  6,  11,  22,  21,  0,  0,  0}, //State 21
        {  1,  0,  23,  11,  17,  18,  0,  0,  0}, //State 22


        {  1,  0,  6,  11,  17,  24,  0,  0,  0}, //State 23
        {  1,  0,  6,  11,  25,  21,  0,  0,  0}, //State 24
        {  1,  0,  9,  11,  17,  18,  0,  0,  0}, //State 25
    };

    // Table constants
    private final static int c_COLUMN   = 0;
    private final static int e_COLUMN   = 1;
    private final static int i_COLUMN   = 2;
    private final static int m_COLUMN   = 3;
    private final static int n_COLUMN   = 4;
    private final static int o_COLUMN   = 5;
    private final static int r_COLUMN   = 6;
    private final static int t_COLUMN   = 7;
    private final static int ERR_COLUMN = 8;

    // Special states
    private final static int START = 0;
    private final static int citer_ACCEPT = 5;
    private final static int ionic_ACCEPT = 10;
    private final static int motion_ACCEPT = 16;
    private final static int norm_ACCEPT = 20;
    private final static int onion_ACCEPT = 25;



    private BufferedReader in;


    public FiniteStateMachine() {
        in = new BufferedReader(
                 new InputStreamReader(System.in));
    }


    public void run() throws IOException {
        int input;
        int state;
        int citerCount = 0;
        int ionicCount = 0;
        int motionCount = 0;
        int normCount = 0;
        int onionCount = 0;


        input = in.read();
        state = START;
            
        while (input != -1) {
           char ch = (char) input;
           state = STATE_TABLE[state][charToColumn(ch)];
           input = in.read();
           if( state == citer_ACCEPT)
               citerCount++;
           else if( state == ionic_ACCEPT)
               ionicCount++;
           else if( state == motion_ACCEPT)
               motionCount++;
           else if( state == norm_ACCEPT)
               normCount++;
           else if( state == onion_ACCEPT)
               onionCount++;
        }

        // display counts
        System.out.println("Occurrence counts:");
        System.out.println("citer: " + citerCount);
        System.out.println("ionic: "  + ionicCount);
        System.out.println("motion: " + motionCount);
        System.out.println("norm: " + normCount);
        System.out.println("onion: " + onionCount);
    }


    public int charToColumn(char ch) {
        int column = ERR_COLUMN;

        switch( ch ) {
        case 'c':
            column = c_COLUMN;
            break;
        case 'e':
            column = e_COLUMN;
            break;
        case 'i':
            column = i_COLUMN;
            break;

        case 'm':
            column = m_COLUMN;
            break;
        case 'n':
            column = n_COLUMN;
            break;
        case 'o':
            column = o_COLUMN;
            break;
        case 'r':
            column = r_COLUMN;
            break;
        case 't':
            column = t_COLUMN;
            break;
        }

        return column;
    }


    public static void main(String[] args) {
        try {
            FiniteStateMachine fsm = new FiniteStateMachine();
            fsm.run();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
