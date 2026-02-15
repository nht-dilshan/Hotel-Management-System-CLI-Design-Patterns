/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NHT-Dilshan
 */
import java.util.ArrayList;
import java.util.List;

public class HotelManager {

    private static HotelManager instance;
    private List<Room> rooms;

    private HotelManager() {
        rooms = new ArrayList<>();
        System.out.println("Hotel Manager System Started...");
    }

    public static HotelManager getInstance() {
        if (instance == null) {
            instance = new HotelManager();
        }
        return instance;
    }

    // CREATE
    public void addRoom(Room room) {
        rooms.add(room);
        System.out.println("Room added successfully.");
    }

    // READ
    public void viewRooms() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }

        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    // UPDATE
    public void updateRoomStatus(int roomNumber, String newStatus) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                room.setStatus(newStatus);
                return;
            }
        }
        System.out.println("Room not found.");
    }

    // DELETE
    public void deleteRoom(int roomNumber) {
        boolean removed = rooms.removeIf(room -> room.getRoomNumber() == roomNumber);

        if (removed) {
            System.out.println("Room deleted successfully.");
        } else {
            System.out.println("Room not found.");
        }
    }
}
