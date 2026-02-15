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

public class Room {

    private int roomNumber;
    private String status;
    private List<Observer> observers;

    public Room(int roomNumber, String status) {
        this.roomNumber = roomNumber;
        this.status = status;
        this.observers = new ArrayList<>();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update("Room " + roomNumber + " status changed to: " + status);
        }
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + " | Status: " + status;
    }
}
