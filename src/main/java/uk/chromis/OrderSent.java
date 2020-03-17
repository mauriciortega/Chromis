package uk.chromis;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.util.Properties;

public class OrderSent {
    public static final Boolean EXTERNAL = Boolean.valueOf(false);


    public OrderSent(Connection con, JTable m_jTicketTable) {}


    public void runTask(Properties attributes, int index) {}


    public void runTask(int rowCount, int i) {}


    public Color runTask(int row, boolean isSelected) { return Color.black; }
}
