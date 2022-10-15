module com.geekbrains.sep.geekcloudclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.geekbrains.common;
    requires io.netty.codec;
    requires MaterialFX;
    requires java.sql;
    requires geek.cloud.server;

    opens com.geekbrains.sep22.geekcloudclient to javafx.fxml;
    exports com.geekbrains.sep22.geekcloudclient;
}