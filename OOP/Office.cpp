#include <iostream>
#include "Office.h"

Office::Office() : Room() {
    this->type = None;
    this->numOfPeople = 0;
}

Office::Office(char* roomName, int floorName, officeType type, int numOfPeople) : Room(roomName, floorName) {
    this->type = type;
    this->numOfPeople = numOfPeople;
}

Office::Office(const Office& other) : Room(other) {
    this->type = other.type;
    this->numOfPeople = other.numOfPeople;
}

Office& Office::operator=(const Office& other) {
    if (this != &other) {
        Room::operator=(other);
        this->type = other.type;
        this->numOfPeople = other.numOfPeople;
    }
    return *this;
}

Office::~Office() {
}

void Office::printRoom() {
    std::cout << "Office name = " << this->getRoomName() << std::endl;
    std::cout << "Office floor number = " << this->getFloorName() << std::endl;
    std::cout << "Office type = ";

    switch (this->type) {
        case None:
            std::cout << "None";
            break;
        case CoordinatorOffice:
            std::cout << "Coordinator Office";
            break;
        case StandardOffice:
            std::cout << "Standard Office";
            break;
        case SharedOfficeFor2People:
            std::cout << "Shared Office for 2 People";
            break;
        case SharedOfficeFor3People:
            std::cout << "Shared Office for 3 People";
            break;
        case SharedOfficeFor10People:
            std::cout << "Shared Office for 10 People";
            break;
        default:
            std::cout << "Unknown";
            break;
    }
    std::cout << std::endl;

    std::cout << "Number of people in office = " << this->numOfPeople << std::endl;
    std::cout << "Office capacity = " << this->getCapacity() << std::endl;

    if(isFull())
        std::cout << "Office is full" <<  std::endl;
    else
        std::cout << "Office is not full" <<  std::endl;

    std::cout <<  std::endl;
}

int Office::getCapacity(){
    int capacity;
    switch(this->type) {
        case None:
            capacity = 0;
            break;
        case CoordinatorOffice:
            capacity = 1;
            break;
        case StandardOffice:
            capacity = 1;
            break;
        case SharedOfficeFor2People:
            capacity = 2;
            break;
        case SharedOfficeFor3People:
            capacity = 3;
            break;
        case SharedOfficeFor10People:
            capacity = 10;
            break;
        default:
            break;
    }
    return capacity;
}

int Office::isFull(){
    if(getCapacity()>this->numOfPeople){
        return 0; //not full
    }
    else{
        return 1;
    }
}

int Office::getType() {
    return 0;
}

