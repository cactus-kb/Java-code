public class IODemo {
    public static void main(String[] args) {
        String str = "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&" +
                "tn=78000241_13_hao_pg&wd=C%2B%2B&rsv_pq=8deca289001847bd&" +
                "rsv_t=02faHbD6u8TpEt60rTPVPzocqIYmtjDQseTmhSQ7BlVwNe9xBzak2Ar%2FCQAa3vIIGyFKlbavoArK&" +
                "rqlang=cn&rsv_enter=0&rsv_dl=tb&rsv_sug3=5&rsv_sug1=4&rsv_sug7=101&inputT=11946&rsv_sug4=13047";
        int index = str.indexOf("://");
        String schema = str.substring(0,index);
        System.out.println(schema);
        str = str.substring(index + 3);
        index = str.indexOf("/");
        String hostPort = str.substring(0,index);
        String host;
        int port;
        if (hostPort.contains(":")) {
            String[] group = str.split(":");
            index = str.indexOf(":");
            host = str.substring(0,index);
            port = Integer.parseInt(str.substring(index + 1));
        } else {
            System.out.println(hostPort);
        }
    }
}
