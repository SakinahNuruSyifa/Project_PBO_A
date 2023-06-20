package Com.Config;

import java.sql.Connection;

public class KoneksiDatabase {
    MyConfig Con = new MyConfig();
    Connection MyConfig = Con.getConnect();
}