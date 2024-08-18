#ifndef INC_242_A2_UNIVERSITY_H
#define INC_242_A2_UNIVERSITY_H

#include "Building.h"

class University{
private:
    char *universityName;
    Building *buildings[50];
    int numOfBuildings;
public:
    University();
    University(char *universityName, int numOfBuildings);
    University(const University& other);
    ~University();

    char *getUniversityName();
    void setUniversityName(char *universityName);

    int getNumOfBuildings();
    void setNumOfBuildings(int numOfBuildings);

    Building **getBuilding();

    void setBuilding(char* buildingName, int buildingSize);

    void addBuilding(char* buildingName, int buildingSize);

    void printBuildings();

    void printRooms();

    void printRoomsByType(int choice);

    void printRoomTypeStatistics();

    void printAvailableOffices();

    void printTotalCapacityOfOffices();

    void printSuitableClassrooms(int numOfStudents);

    University& operator=(const University& other);
};
#endif //INC_242_A2_UNIVERSITY_H
