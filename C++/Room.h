#ifndef INC_242_A2_ROOM_H
#define INC_242_A2_ROOM_H
class Room{
private:
    char* roomName;
    int floorNum;
public:
    Room();
    Room(char *roomName, int floorName);
    Room& operator=(const Room& other);
    Room(const Room& other);
    virtual ~Room();

    char *getRoomName() const;

    void setRoomName(char *roomName);

    int getFloorName() const;

    void setFloorName(int floorName);

    virtual void printRoom();

    virtual int getType();

    virtual int isFull();

    virtual int getCapacity();

    virtual bool checkSuitability(int);

};
#endif //INC_242_A2_ROOM_H
