import java.time.LocalDateTime;

public class BookableRoom {

    // Used for the displaying the occupancy of the roooms
    enum StatusValue{
        EMPTY,
        AVAILABLE,
        FULL
    }

    // Formatted yyyy-mm-dd-HH-MM-ss-ns
    private LocalDateTime timeSlot;

    private int occupancy = 0;

    private StatusValue status;
    
    private Room room;

    private static BookableRoom[] bookableRooms = new BookableRoom[100];

    private static int numBookableRooms = 0;

    /**
     * The constructor for the class BookableRooms.
     * 
     * @param room this is the room that will be booked.
     * @param timeSlot this is the timeslot that the room can be booked from.
     */
    public BookableRoom(Room room, LocalDateTime timeSlot){
        this.room = room;
        this.timeSlot = checkTimeSlot(timeSlot);
        status = createStatus();
        addBookableRoom(this);
        interateNumBookableRooms();
    }

    /**
     * The getter method for the time slot
     * 
     * @return the time slot that the room can be booked from.
     */
    public LocalDateTime getTimeSlot(){
        return timeSlot;
    }

    /**
     * The getter method for the occupancy.
     * 
     * @return the current occupancy at the time slot 
     */
    public int getOccupancy(){
        return occupancy;
    }

    /**
     * The getter method for the status.
     * 
     * @return the status of the bookable room.
     */
    public StatusValue getStatus(){
        return status;
    }

    /**
     * The getter method for the room.
     * 
     * @return the room that will be booked.
     */
    public Room getRoom(){
        return room;
    }

    /**
     * The static getter method for the list of bookable rooms.
     * 
     * @return the list of bookable rooms.
     */
    public static BookableRoom[] getBookableRooms(){
        return bookableRooms;
    }

    /**
     * The static getter method for the number of bookable rooms
     * 
     * @return the number of bookable rooms.
     */
    public static int getNumBookableRooms(){
        return numBookableRooms;
    }

    /**
     * The setter method for the occupancy of the room.
     * 
     * @param occupancy the number of tests currently taking place in the room.
     */
    public void setOccupancy(int occupancy){
        this.occupancy = checkOccupancy(occupancy);
        this.status = createStatus();
    }

    /**
     * The static method to incement the number of bookable rooms.
     */
    private static void interateNumBookableRooms(){
        numBookableRooms += 1;
    }

    /**
     * The static method to add a bookable room to the list of bookable rooms.
     * 
     * @param bookableRoom a bookable room to be added to the list.
     */
    private static void addBookableRoom(BookableRoom bookableRoom){
        bookableRooms[numBookableRooms] = bookableRoom;
    }

    /**
     * The static method to remove a bookable room from the list of bookable rooms.
     * 
     * @param bookableRoom a bookable room to be removed from the list.
     */
    public static void removeBookableRoom(int index){
        if (bookableRooms[index].status != StatusValue.EMPTY){
            throw new IllegalArgumentException("To remove a bookable room it must be empty.");
        }
        // Shifting the last elements.
        for (int i=index;i<=numBookableRooms-1;i++){
            bookableRooms[i] = bookableRooms[i+1];
        }
        bookableRooms[numBookableRooms] = null;
        numBookableRooms -= 1;
    }

    /**
     * The method to check if the occupancy of the room is valid.
     * 
     * @param occupancy the occupancy being checked.
     * @return the occupancy returned if it is valid.
     */
    private int checkOccupancy(int occupancy){
        if (occupancy < 0){
            throw new IllegalArgumentException("Occupancy is smaller then zero.");
        }
        return occupancy;
    }

    /**
     * The method to check what state the status should be in.
     * 
     * @return the new status of the room
     */
    private StatusValue createStatus(){
        if (occupancy == 0){
            return StatusValue.EMPTY;
        }else if (occupancy < room.getCapacity()){
            return StatusValue.AVAILABLE;
        }else if (occupancy == room.getCapacity()){
            return StatusValue.FULL;
        }else{
            throw new IllegalArgumentException("Occupancy cannot be greater then capacity of a room.");
        }
    }

    /**
     * The method to check if a time-slot is valid.
     * 
     * @param timeSlot a new time-slot.
     * @return the time-slot if it is valid.
     */
    private LocalDateTime checkTimeSlot(LocalDateTime timeSlot){
        LocalDateTime currentTime = LocalDateTime.now();
        if (timeSlot.isBefore(currentTime)){
            throw new IllegalArgumentException("The time slot has already passed.");
        }else if (timeSlot.getHour() < 7 || timeSlot.getHour() > 10){
            throw new IllegalArgumentException("The time slot must be between 7 and 10.");
        }else if (timeSlot.getMinute() != 0 || timeSlot.getSecond() != 0){
            throw new IllegalArgumentException("The time slot must be at the start of the hour.");
        }
        for (int i=0;i<numBookableRooms;i++){
            if (timeSlot == bookableRooms[i].getTimeSlot() && bookableRooms[i].getRoom().equals(room)){
                throw new IllegalArgumentException("Duplicate time slot.");
            }
        }
        return timeSlot;
    }

    /**
     * This is the static method to format the date correctly
     * 
     * @param time this is the time that needs to be formatted.
     * @return A string of the formatted date.
     */
    public static String formatDate(LocalDateTime time){
        return time.getDayOfMonth()+"/"+time.getMonthValue()+"/"+time.getYear()+" "+time.getHour()+":"+time.getMinute()+"0";
    }

    /**
     * This is the method to convert the index and the sequential id
     * when removing an assistant on shift.
     * 
     * @param status this is the status to be filtering the bookable room by.
     * @return this is the list of indexes used to convert the id to the idex.
     */
    public static int[] convertIndex(StatusValue status){
        int[] indexList = new int[numBookableRooms+1];
        int index = 11;
        int i;
        for (i=0;i<numBookableRooms;++i){
            if (bookableRooms[i].status == status){
                indexList[i] = index++;
            }
        }
        indexList[numBookableRooms] = index-11; // To store the actual length of the list.
        return indexList;
    }

    
    /**
     * This is the overloaded method to return the the string of all bookable rooms.
     * 
     * @return a string of all bookable rooms.
     */
    public static String toStringAll(){
        String allBookableRooms = "Bookable Rooms-\n";
        for (int i=0;i<numBookableRooms;i++){
            allBookableRooms = allBookableRooms.concat((i+11)+". "+bookableRooms[i].toString()+"\n");
        }
        return allBookableRooms;
    }

    /**
     * This is the overloaded method to return the the string of all bookable rooms
     * 
     * @param status this is the status to filter the bookable rooms by.
     * @return a string of bookable rooms that are valid for the status.
     */
    public static String toStringAll(StatusValue status){
        String allBookableRooms = "Bookable Rooms-\n";
        int index = 0;
        for (int i=0;i<numBookableRooms;i++){
            if (bookableRooms[i].status == status){
                allBookableRooms = allBookableRooms.concat((index+11)+". "+bookableRooms[i].toString()+"\n");
                index++;
            }
        }
        return allBookableRooms;
    }

    /**
     * This is the method to return a string of a bookable room.
     * 
     * @return a string of a bookable room.
     */
    public String toString(){
        return "| "+formatDate(timeSlot)+" | "+status+" | "+room.getCode()+" | occupancy: "+occupancy+" |";
    }
}
