/* Muhammad Hashaam Shahid – 2491488
I read and accept the submission rules and the extra rules specified in each
question. This is my own work that is done by myself only */

#include <iostream>
#include <cstring>
#include "University.h"

void displayMenu() {
    std::cout << "\n[1] Add a new building to the university\n";
    std::cout << "[2] Add a new room to a selected building\n";
    std::cout << "[3] Print the buildings in the university\n";
    std::cout << "[4] Print the rooms in each building in the university\n";
    std::cout << "[5] Print the rooms in each building in the university based on type\n";
    std::cout << "[6] Print the total number of classrooms and offices in the university\n";
    std::cout << "[7] Print the available offices in each building in the university\n";
    std::cout << "[8] Print the total capacity of all the offices\n";
    std::cout << "[9] Print the suitable classrooms in the university based on the given number of students\n";
    std::cout << "[0] Exit\n";
}
int main() {
    int choice;
    University university("METU NCC", 0);

    while (true) {
        displayMenu();
        std::cout << "Please enter your choice:";
        std::cin >> choice;

        switch (choice) {
            case 1:
                char buildingName[100];
                int buildingSize;
                std::cout << "Please enter name of building:";
                std::cin >> buildingName;
                std::cout << "Please enter size of building:";
                std::cin >> buildingSize;
                university.addBuilding(buildingName, buildingSize);
//                university.addBuilding("T", 100);
//                university.addBuilding("S", 100);
                break;
            case 2:
                int numOfBuilding, capacity, typechoice, floorNumber,offChoice,NumPeopleInOffice;
                officeType offType;
                char roomName[100];

                university.printBuildings();
                std::cout << "Please enter the number of building to which the room should be added:";
                std::cin >> numOfBuilding;
                std::cout << "Please enter the type of room(1: Classroom / 2: Office):";
                std::cin >> typechoice;
                std::cout << "Please enter the name of the new room:";
                std::cin >> roomName;
                std::cout << "Please enter the floor number of the new room:";
                std::cin >> floorNumber;

                if(typechoice==2){
                    std::cout << "[1] Coordinator Office\n"
                                 "[2] Standard Office\n"
                                 "[3] Shared Office for 2 people\n"
                                 "[4] Shared Office for 3 people\n"
                                 "[5] Shared Office for 10 people\n";
                    std::cout << "Please enter type of office:";
                    std::cin >> offChoice;
                    std::cout << "Please enter number of people in the office:";
                    std::cin >> NumPeopleInOffice;

                    switch (offChoice) {
                        case 1:
                            offType = CoordinatorOffice;
                            break;
                        case 2:
                            offType = StandardOffice;
                            break;
                        case 3:
                            offType = SharedOfficeFor2People;
                            break;
                        case 4:
                            offType = SharedOfficeFor3People;
                            break;
                        case 5:
                            offType = SharedOfficeFor10People;
                            break;
                        default:
                            std::cerr << "Invalid office type input!\n";
                            return 1;
                    }
                    university.getBuilding()[numOfBuilding-1]->addRoom(roomName,floorNumber,offType,NumPeopleInOffice);
                }
                else if (typechoice==1){
                    std::cout << "Please enter capacity of classroom:";
                    std::cin >> capacity;
                    university.getBuilding()[numOfBuilding-1]->addRoom(roomName,floorNumber,capacity);
                }
                else{
                    std::cout << "Invalid room type input!\n";
                    return 1;
                }

//                university.printBuildings();
//                university.getBuilding()[0]->addRoom("TZ-18",1,SharedOfficeFor10People,1);
//                university.printBuildings();
//                university.getBuilding()[1]->addRoom("S-145",2,StandardOffice,1);
//                university.printBuildings();
//                university.getBuilding()[0]->addRoom("TZ-22",1,43);
//                university.printBuildings();
//                university.getBuilding()[1]->addRoom("SZ-22",1,20);
                break;
            case 3:
                university.printBuildings();
                break;
            case 4:
                university.printRooms();
                break;
            case 5:
                int roomChoice;
                std::cout << "Please enter type of room to display: \n"
                                 "[1] Classrooms \n"
                                 "[2] Offices\n";
                std::cin >> roomChoice;
                university.printRoomsByType(roomChoice);
//                university.printRoomsByType(1);
//                university.printRoomsByType(2);
                break;
            case 6:
                university.printRoomTypeStatistics();
                break;
            case 7:
                university.printAvailableOffices();
                break;
            case 8:
                university.printTotalCapacityOfOffices();
                break;
            case 9:
                int numOfStudents;
                std::cout << "Please enter number of students: ";
                std::cin >> numOfStudents;
                university.printSuitableClassrooms(numOfStudents);

//                university.printSuitableClassrooms(30);
                break;
            case 0:
                std::cout << "Thank you for using the university campus management system\n";
                return 0;
            default:
                std::cout << "Invalid choice. Please try again.\n";
                break;
        }
    }
}

