#ifndef INC_242_A2_CLASSROOM_H
#define INC_242_A2_CLASSROOM_H

#include "Room.h"

class Classroom : public Room{
public:
    int Capacity;
public:
    Classroom();
    Classroom(char *roomName, int floorName, int capacity);
    Classroom(const Classroom& other);
    Classroom& operator=(const Classroom& other);
    ~Classroom();

    void printRoom();

    int getCapacity() const;

    void setCapacity(int capacity);

    bool checkSuitability(int);

    int getType();

};
#endif //INC_242_A2_CLASSROOM_H
