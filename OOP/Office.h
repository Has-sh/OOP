#ifndef INC_242_A2_OFFICE_H
#define INC_242_A2_OFFICE_H

#include "Room.h"

enum officeType{None=0, CoordinatorOffice=1, StandardOffice=2,
    SharedOfficeFor2People=3, SharedOfficeFor3People=4, SharedOfficeFor10People=5};

class Office: public Room{
private:
    int numOfPeople;
    officeType type;
public:
    Office();
    Office(char* roomName, int floorName, officeType type, int numOfPeople);
    Office(const Office& other);
    Office& operator=(const Office& other);
    ~Office();

    void printRoom();
    int isFull();
    int getCapacity();
    int getType();
};

#endif //INC_242_A2_OFFICE_H
