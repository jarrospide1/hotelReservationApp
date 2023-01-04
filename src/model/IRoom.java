package model;

public interface IRoom {
    //All methods in an interface are abstract, which means no method implementation

    public String getRoomNumber();
    public Double getRoomPrice();
    public RoomType getRoomType();
    public boolean isFree();

}
