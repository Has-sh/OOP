#ifndef INC_242_A2_BUILDING_H
#define INC_242_A2_BUILDING_H

#include "Room.h"
#include "Office.h"

class Building {
private:
    char *buildingName;
    int size;
    Room *rooms[100];
    int numOfRooms;
public:
    Building();
    Building(char *buildingName, int size);
    ~Building();

    char *getBuildingName();

    void setBuildingName(char *buildingName);

    int getSize();

    void setSize(int size);

    Room **getRooms();

    int getNumOfRooms();

    void setNumOfRooms(int numOfRooms);

    void addRoom(char* roomName, int floorName, officeType type ,int numOfPeople);

    void addRoom(char* roomName, int floorName, int capacity);

    void printBuilding();

    void printRooms();

    void printRoomsByType();

    int getNumberOfClassrooms();

    int getNumberOfOffices();

    void printAvailableOffices();

    void getTotalCapacity();

    void printSuitableClassrooms(int);
};
#endif //INC_242_A2_BUILDING_H
