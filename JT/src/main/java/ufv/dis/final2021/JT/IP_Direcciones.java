
package ufv.dis.final2021.JT;

public class IP_Direcciones {


    public static class JavaBitwiseExample {

        public static void main(String[] args) {

            JavaBitwiseExample obj = new JavaBitwiseExample();
        }

        public static Long Dot2LongIP(String dottedIP) {
            String[] addrArray = dottedIP.split("\\.");
            long num = 0;
            for (int i=0;i<addrArray.length;i++) {
                int power = 3-i;
                num += ((Integer.parseInt(addrArray[i]) % 256) *
                        Math.pow(256, power));
            }
            return num;
        }

        public String longToIp(long ip) {
            StringBuilder result = new StringBuilder(15);
            for (int i = 0; i < 4; i++) {
                result.insert(0,Long.toString(ip & 0xff));
                if (i < 3) {
                    result.insert(0,'.');
                }
                ip = ip >> 8;
            }
            return result.toString();
        }
    }

