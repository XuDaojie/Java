class X {
    static void main(String[] args) {
        println('-----------groovy---------');
                def certificateNo = '331021199205220614';
                String birthday = "";
                String age = "";
                String sexCode = "";

                int year = Calendar.getInstance().get(Calendar.YEAR);
                char[] number = certificateNo.toCharArray();
                boolean flag = true;
                if (number.length == 15) {
                    for (int x = 0; x < number.length; x++) {
                        if (!flag)
//                            return new HashMap<String, String>();
                        flag = Character.isDigit(number[x]);
                    }
                } else if (number.length == 18) {
                    for (int x = 0; x < number.length - 1; x++) {
                        if (!flag)
//                            return new HashMap<String, String>();
                        flag = Character.isDigit(number[x]);
                    }
                }
                if (flag && certificateNo.length() == 15) {
                    birthday = "19" + certificateNo.substring(6, 8)  + certificateNo.substring(8, 10) + certificateNo.substring(10, 12);
                    sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 3, certificateNo.length())) % 2 == 0 ? "F" : "M";
                    age = (year - Integer.parseInt("19" + certificateNo.substring(6, 8))) + "";
                } else if (flag && certificateNo.length() == 18) {
                    birthday = certificateNo.substring(6, 10) + certificateNo.substring(10, 12) + certificateNo.substring(12, 14);
                    sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 4, certificateNo.length() - 1)) % 2 == 0 ? "F" : "M";
                    age = (year - Integer.parseInt(certificateNo.substring(6, 10))) + "";
                }

                Map<String, String> map = new HashMap<String, String>();
                map.put("birthday", birthday);
                map.put("age", age);
                map.put("sexCode", sexCode);

        println(map)
        println('------------groovy---------');
    }
}
