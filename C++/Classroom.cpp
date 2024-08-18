#include "Room.h"
#include "Classroom.h"
#include <iostream>

Classroom::Classroom() : Room() {
    this->Capacity = 0;
}

Classroom::Classroom(char *roomName, int floorName, int capacity) : Room(roomName, floorName) {
    this->Capacity=capacity;
}

Classroom::Classroom(const Classroom& other) : Room(other) {
    this->Capacity = other.Capacity;
}

Classroom& Classroom::operator=(const Classroom& other) {
    if (this != &other) {
        Room::operator=(other);
        this->Capacity = other.Capacity;
    }
    return *this;
}

Classroom::~Classroom() {
}

void Classroom::printRoom() {
    std::cout << "Classroom name = " << this->getRoomName() << std::endl;
    std::cout << "Classroom floor number = " << this->getFloorName() << std::endl;
    std::cout << "Classroom capacity = " << this->getCapacity() << std::endl;
    std::cout <<  std::endl;
}

int Classroom::getCapacity() const {
    return Capacity;
}

void Classroom::setCapacity(int capacity) {
    Capacity = capacity;
}

bool Classroom::checkSuitability(int numOfStudents){
    if(getCapacity()>=numOfStudents)
        return true;
    else
        return false;
}

int Classroom::getType() {
    return 1;
}
