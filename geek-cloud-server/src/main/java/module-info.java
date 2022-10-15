module geek.cloud.server {
    requires lombok;
    requires io.netty.codec;
    requires io.netty.transport;
    requires java.sql;
    requires com.geekbrains.common;
    exports com.geekbrains.db;
}