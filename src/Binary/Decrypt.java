package Binary;

public class Decrypt {
    private String mess;
    private int shift;

    private String[] caracters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "X",
                                  "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                                  " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "<", ">", ".", ",", "!", "?", "+", "-", "*", "/", "=", ":", ";", "'", "_",
                                  "$", "#", "%", "^", "&", "(", ")", "[", "]", "{", "}", "@"};
    private String[] encodedCaracters = {"xbsg", "asjd", "pdsw", "dase", "kiuf", "nbhy", "bhds", "gbvd", "iuhd", "frds", "zgas", "vfrd", "cfds",
                                         "sdaw", "mkji", "lkoi", "yuis", "rxbs", "vrer", "tsda", "qwds", "zsda", "deqw", "slpo", "lpts", "rtcz",
                                         "nytr", "pwsx", "xetd", "rtpt", "csar", "tobc", "wwer", "sdre", "sdrw", "uyhs", "srxa", "ztsa", "srea",
                                         "cdfr", "twqs", "srre", "rwds", "pyxt", "srtb", "wqpe", "spls", "uyts", "xcfe", "onvz", "ympx", "txyo",
                                         "ipsr", "tfgv", "edxo", "usjd", "ibvr", "ontz", "intz", "nubt", "mtva", "khda", "pyrq", "lnyc", "kybe",
                                         "ntvc", "srrw", "kvbx", "sdae", "aexa", "kxas", "scvt", "kxim", "sdds", "uhbr", "onxr", "qpbe", "vxtz",
                                         "brcy", "inrx", "peoz", "ycpa", "qmrz", "spcs", "oxbw", "sqvo", "dpvr", "xpxz", "btga", "imzx"};
    private String decodedMess="";



    public Decrypt(String mess,int shift) {
        this.mess= mess;
        this.shift=shift;
    }


    private int findc(String c)
    {
        boolean p = false;
        int n=0;
        for (int i = 0; i<encodedCaracters.length; i++)
        {
            if (c.equals(encodedCaracters[i]))
            {
                p=true;
                n=i;
                break;
            }
        }
        if (p)
        {
            return n-shift;
        }
        else
            return -100;
    }

    private String decode(String ch)
    {
        String ch1;


        ch1 = String.valueOf(ch);
        int r = findc(ch1);
        if(r==-100)
        {
            return "greska";
        }else if (r>=0 && r<=caracters.length)
                return caracters[r];
            else {
                return caracters[caracters.length-r];
        }
    }

    private String merge(String m1, String m2)
    {
        String m=""+m1;
        m=m+""+m2;
        return m;
    }

    private String decrypt(String mess)
    {

        String pom="";
        String pom1;
        char c;

        for (int i = 0;i < mess.length(); i+=4)
        {
            pom="";
            for (int j = i;j<i+4;j++)
            {
                c=mess.charAt(j);
                pom1 = String.valueOf(c);
                pom=merge(pom,pom1);
            }
            decodedMess= merge(decodedMess,decode(pom));
        }
        return decodedMess;
    }



    @Override
    public String toString() {
        return decrypt(mess);
    }
}
