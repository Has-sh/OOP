#include <iostream>
#include "Room.h"
#include "Building.h"
#include "cstring"
#include "Office.h"
#include "Classroom.h"

Building::Building() {
    this->buildingName = new char[strlen("Undefined") + 1];
    strcpy(this->buildingName, "Undefined");
    this->size = 0; // You may want to set a default size
    this->numOfRooms = 0;
}

Building::Building(char *buildingName, int size){
    this->buildingName = new char[strlen(buildingName) + 1];
    strcpy(this->buildingName, buildingName);
    this->size = size;
    numOfRooms=0;
}

Building::~Building() {
    delete[] buildingName;
    for (int i = 0; i < numOfRooms; ++i)
        delete rooms[i];
}

char *Building::getBuildingName() {
    return buildingName;
}

void Building::setBuildingName(char *buildingName) {
    Building::buildingName = buildingName;
}

int Building::getSize() {
    return size;
}

void Building::setSize(int size) {
    Building::size = size;
}

int Building::getNumOfRooms() {
    return numOfRooms;
}

void Building::setNumOfRooms(int numOfRooms) {
    Building::numOfRooms = numOfRooms;
}

Room **Building::getRooms() {
    return rooms;
}

void Building::addRoom(char* roomName, int floorName, officeType type ,int numOfPeople){
    rooms[numOfRooms] = new Office(roomName, floorName, type, numOfPeople);
    this->numOfRooms++;
}

void Building::addRoom(char* roomName, int floorName, int capacity){
    rooms[numOfRooms] = new Classroom(roomName, floorName, capacity);
    this->numOfRooms++;
}

void Building::printBuilding(){
    std::cout << "Building size = "<< getSize() << std::endl;
    std::cout << "Building number of rooms = " << getNumOfRooms() << std::endl;
    std::cout << std::endl;
}

void Building::printRooms(){
    std::cout << "All rooms in " << getBuildingName() << " building:" << std::endl;
    for (int j = 0; j < getNumOfRooms(); ++j) {
        getRooms()[j]->printRoom();
    }
}

void Building::printRoomsByType(){
    std::cout << "All classrooms in " << getBuildingName() << " building:" << std::endl;
    for (int j = 0; j < getNumOfRooms(); ++j) {
        if(getRooms()[j]->getType())
            getRooms()[j]->printRoom();
    }
}

int Building::getNumberOfClassrooms(){
    int count=0;
    for (int i = 0; i < numOfRooms; ++i) {
        if(getRooms()[i]->getType())
            count++;
    }
    return count;
}

int Building::getNumberOfOffices(){
    int count=0;
    for (int i = 0; i < numOfRooms; ++i) {
        if(!getRooms()[i]->getType())
            count++;
    }
    return count;
}

void Building::printAvailableOffices(){
    std::cout << "Available offices in  " << getBuildingName() << " building:\n" << std::endl;
    for (int i = 0; i < numOfRooms; ++i) {
        if (!getRooms()[i]->getType())
            if(!getRooms()[i]->isFull()){
                this->getRooms()[i]->printRoom();
            }
    }
}

void Building::getTotalCapacity(){
    int countOffice = 0;
    for (int j = 0; j < getNumOfRooms(); ++j) {
        if(!getRooms()[j]->getType()){
            countOffice += getRooms()[j]->getCapacity();
        }
    }
    std::cout << "Office capacity in " << getBuildingName() << " building = "
    << countOffice << std::endl;
}

void Building::printSuitableClassrooms(int numOfStudents){
    std::cout << "Classrooms which are suitable for " << numOfStudents
    << " students in " << getBuildingName() << " building" << std::endl;
    for (int j = 0; j < getNumOfRooms(); ++j) {
        if(getRooms()[j]->getType() && getRooms()[j]->checkSuitability(numOfStudents)) {
            getRooms()[j]->printRoom();
        }
    }
}