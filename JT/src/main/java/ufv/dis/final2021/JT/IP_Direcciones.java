
package ufv.dis.final2021.JT;

public class IP_Direcciones {


    public static class JavaBitwiseExample {

        public static void main(String[] args) {

            JavaBitwiseExample obj = new JavaBitwiseExample();

            System.out.println("iptoLong  : " + obj.ipToLong("192.168.1.2"));
            System.out.println("iptoLong2 : " + obj.ipToLong2("192.168.1.2"));

            System.out.println("longToIp  : " + obj.longToIp(3232235778L));
            System.out.println("longToIp2 : " + obj.longToIp2(3232235778L));
        }

        // example : 192.168.1.2
        public long ipToLong(String ipAddress) {

            // ipAddressInArray[0] = 192
            String[] ipAddressInArray = ipAddress.split("\\.");

            long result = 0;
            for (int i = 0; i < ipAddressInArray.length; i++) {

                int power = 3 - i;
                int ip = Integer.parseInt(ipAddressInArray[i]);
                result += ip * Math.pow(256, power);

            }

            return result;

        }

        public long ipToLong2(String ipAddress) {

            long result = 0;

            String[] ipAddressInArray = ipAddress.split("\\.");

            for (int i = 3; i >= 0; i--) {

                long ip = Long.parseLong(ipAddressInArray[3 - i]);
                result |= ip << (i * 8);

            }

            return result;
        }

        public String longToIp(long i) {

            return ((i >> 24) & 0xFF) +
                    "." + ((i >> 16) & 0xFF) +
                    "." + ((i >> 8) & 0xFF) +
                    "." + (i & 0xFF);

        }

        public String longToIp2(long ip) {
            StringBuilder sb = new StringBuilder(15);

            for (int i = 0; i < 4; i++) {

                sb.insert(0, Long.toString(ip & 0xff));

                if (i < 3) {
                    sb.insert(0, '.');
                }

                ip = ip >> 8;

            }

            return sb.toString();
        }
    }
