package com.luo.ad.service;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.DeleteRowsEventData;
import com.github.shyiko.mysql.binlog.event.EventData;
import com.github.shyiko.mysql.binlog.event.UpdateRowsEventData;
import com.github.shyiko.mysql.binlog.event.WriteRowsEventData;

public class BinlogTest {
    public static void main(String[] args) throws Exception {
        BinaryLogClient logClient = new BinaryLogClient("127.0.0.1", 3306,
                "root",
                "123");

        logClient.registerEventListener(event -> {
            EventData data = event.getData();
            if (data instanceof UpdateRowsEventData) {
                System.out.println("up---");
                System.out.println(data.toString());
            }
            if (data instanceof WriteRowsEventData) {
                System.out.println("wr---");
                System.out.println(data.toString());
            }
            if (data instanceof DeleteRowsEventData) {
                System.out.println("de---");
                System.out.println(data.toString());
            }

        });
        logClient.connect();
    }
}
