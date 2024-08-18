#include "University.h"
#include "Office.h"
#include "Classroom.h"
#include <cstring>
#include <iostream>

University::University(){
    this->universityName = new char[strlen("Undefined") + 1];
    strcpy(this->universityName, "Undefined");
    this->numOfBuildings = 0;
};

University::University(char *universityName, int numOfBuildings) {
    this->universityName = new char[strlen(universityName) + 1];
    strcpy(this->universityName, universityName);
    this->numOfBuildings = numOfBuildings;
}

University::University(const University& other) {
    this->universityName = new char[strlen(other.universityName) + 1];
    strcpy(this->universityName, other.universityName);

    this->numOfBuildings = other.numOfBuildings;
    for (int i = 0; i < this->numOfBuildings; ++i) {
        this->buildings[i] = new Building(*(other.buildings[i]));
    }
}

University::~University() {
    delete[] this->universityName;
    for (int i = 0; i < numOfBuildings; ++i)
        delete this->buildings[i];
}

University& University::operator=(const University& other) {
    if (this == &other)
        return *this;

    delete[] this->universityName;
    for (int i = 0; i < numOfBuildings; ++i)
        delete this->buildings[i];

    this->universityName = new char[strlen(other.universityName) + 1];
    strcpy(this->universityName, other.universityName);

    this->numOfBuildings = other.numOfBuildings;
    for (int i = 0; i < this->numOfBuildings; ++i) {
        this->buildings[i] = new Building(*(other.buildings[i]));
    }

    return *this;
}

char *University::getUniversityName()  {
    return universityName;
}

Building **University::getBuilding()  {
    return buildings;
}

void University::setBuilding(char* buildingName, int buildingSize){
    buildings[numOfBuildings] = new Building(buildingName, buildingSize);
    this->numOfBuildings++;
}

int University::getNumOfBuildings() {
    return numOfBuildings;
}

void University::setNumOfBuildings(int numOfBuildings) {
    University::numOfBuildings = numOfBuildings;
}

void University::setUniversityName(char *universityName) {
    University::universityName = universityName;
}

void University::addBuilding(char* buildingName, int buildingSize){
    setBuilding(buildingName, buildingSize);
}

void University::printBuildings(){
    std::cout << "Buildings in " << getUniversityName() << " university:" << std::endl;
    for (int i = 0; i < this->numOfBuildings; ++i) {
        std::cout << "[" << i+1 << "]" <<" Building name = " << this->buildings[i]->getBuildingName()  << std::endl;
        this->buildings[i]->printBuilding();
    }
}

void University::printRooms() {
    std::cout << "Rooms in " << getUniversityName() << " university:" << std::endl;
    for (int i = 0; i < this->numOfBuildings; ++i) {
        this->buildings[i]->printRooms();
    }
}

void University::printRoomsByType(int choice) {
    if(choice==1){
        Room* room;
        std::cout << "Classrooms in " << getUniversityName() << " university:" << std::endl;
        for (int i = 0; i < this->numOfBuildings; ++i) {
            this->buildings[i]->printRoomsByType();
        }
    }
    else if(choice==2){
        std::cout << "Offices in " << getUniversityName() << " university:" << std::endl;
        for (int i = 0; i < this->numOfBuildings; ++i) {
            std::cout << "All offices in " << this->buildings[i]->getBuildingName() << " building:" << std::endl;
            for (int j = 0; j < this->buildings[i]->getNumOfRooms(); ++j) {
                if(!this->buildings[i]->getRooms()[j]->getType())
                    this->buildings[i]->getRooms()[j]->printRoom();
            }
        }
    }
    else {
        std::cout << " Invalid choice " << std::endl;
        exit(1);
    }
}

void University::printRoomTypeStatistics(){
    int countClassroom = 0, countOffice = 0;
    std::cout << "Room Type statistics for " << getUniversityName() << " university:" << std::endl;
    for (int i = 0; i < this->numOfBuildings; ++i) {
        countClassroom += this->buildings[i]->getNumberOfClassrooms();
        countOffice += this->buildings[i]->getNumberOfOffices();
    }
    std::cout << "Number of offices = " << countOffice << std::endl;
    std::cout << "Number of classrooms = " << countClassroom << std::endl;
}

void University::printAvailableOffices() {
    std::cout << "Available offices in " << getUniversityName() << " university:" << std::endl;
    for (int i = 0; i < this->numOfBuildings; ++i) {
        this->buildings[i]->printAvailableOffices();
    }
}

void University::printTotalCapacityOfOffices() {
    std::cout << "Office capacity in " << getUniversityName() << " university:\n" << std::endl;
    for (int i = 0; i < this->numOfBuildings; ++i) {
        this->getBuilding()[i]->getTotalCapacity();
    }

}

void University::printSuitableClassrooms(int numOfStudents){
    std::cout << "Suitable classes in " << getUniversityName() << " university for " << numOfStudents << " students\n" << std::endl;
    for (int i = 0; i < this->numOfBuildings; ++i) {
        this->getBuilding()[i]->printSuitableClassrooms(numOfStudents);
    }
}
