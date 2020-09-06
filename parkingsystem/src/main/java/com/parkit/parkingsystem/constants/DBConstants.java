package com.parkit.parkingsystem.constants;

public class DBConstants {

    public static final String GET_NEXT_PARKING_SPOT = "select min(PARKING_NUMBER) from parking where AVAILABLE = true and TYPE = ?";
    public static final String UPDATE_PARKING_SPOT = "update parking set available = ? where PARKING_NUMBER = ?";

    public static final String SAVE_TICKET = "insert into ticket(PARKING_NUMBER, VEHICLE_REG_NUMBER, PRICE, IN_TIME, OUT_TIME) values(?,?,?,?,?)";
    public static final String UPDATE_TICKET = "update ticket set PRICE=?, OUT_TIME=? where ID=?";
//    Ajout de : and t.OUT_TIME is NULL afin qu'en cas de doublon on sort bien le doublon qui n'est pas encore sorti
	public static final String GET_TICKET = "select t.PARKING_NUMBER, t.ID, t.PRICE, t.IN_TIME, t.OUT_TIME, p.TYPE from ticket t,parking p where p.parking_number = t.parking_number and t.VEHICLE_REG_NUMBER=? and t.OUT_TIME is NULL order by t.IN_TIME limit 1";
	//
    public static final String COUNT_RECURENT = "select count(*) from ticket where vehicle_reg_number=?";
    public static final String DUPLICATE = "select VEHICLE_REG_NUMBER from TICKET";
}
