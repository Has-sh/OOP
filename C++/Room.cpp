#include <cstring>
#include <iostream>
#include "Room.h"

Room::Room() {
    this->roomName = new char[strlen("Undefined") + 1];
    strcpy(this->roomName, "Undefined");
    this->floorNum = 0;
}

Room::Room(char *roomName, int floorNum) {
    this->roomName = new char[strlen(roomName) + 1];
    strcpy(this->roomName, roomName);
    this->floorNum = floorNum;
}

Room::Room(const Room& other) {
    this->roomName = new char[strlen(other.roomName) + 1];
    strcpy(this->roomName, other.roomName);
    this->floorNum = other.floorNum;
}

Room& Room::operator=(const Room& other) {
    if (this != &other) {
        delete[] this->roomName;
        this->roomName = new char[strlen(other.roomName) + 1];
        strcpy(this->roomName, other.roomName);
        this->floorNum = other.floorNum;
    }
    return *this;
}

Room::~Room() {
    delete[] roomName;
}

char *Room::getRoomName() const {
    return roomName;
}

void Room::setRoomName(char *roomName) {
    Room::roomName = roomName;
}

int Room::getFloorName() const {
    return floorNum;
}

void Room::setFloorName(int floorName) {
    Room::floorNum = floorName;
}

void Room::printRoom(){}

int Room::getType(){}

int Room::isFull(){}

int Room::getCapacity(){}

bool Room::checkSuitability(int){}

