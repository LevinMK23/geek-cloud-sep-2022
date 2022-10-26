module geek.cloud.server {
    requires lombok;
    requires io.netty.codec;
    requires io.netty.transport;
    requires java.sql;
    requires com.geekbrains.common;
    requires io.netty.buffer;
    requires org.slf4j;
    exports com.geekbrains.db;
}