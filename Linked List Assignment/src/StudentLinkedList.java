public class StudentLinkedList {
    private StudentNode head;
    private StudentNode tail;

    //constructs student linked list
    public StudentLinkedList(){
        head = null;
        tail = null;
    }

    //returns head of linked list
    public Student getFirst(){
        StudentNode current = head;
        return current.getStudent();
    }

    //inserts student node into linked list
    public void insertNode(Student student){
        StudentNode node = new StudentNode(student);
        if(head == null){
            head = node;
        }
        else {
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail = node;
    }

    //deletes node
    public void deleteNode(String name){
        StudentNode current = head;
        if(!current.getStudent().getName().equals(name)){
            while(current.getNext() != null){
                String sname = current.getNext().getStudent().getName();
                if(sname.equals(name)){
                    current.setNext(current.getNext().getNext());
                    break;
                }
                else
                    current = current.getNext();
            }
        } else {
            head = current.getNext();
        }
    }

    //returns a string of the linked list
    public String returnPrintList(){
        StudentNode current = head;
        StringBuilder s = new StringBuilder();
        while(current.getNext() != null){
            String sCurNodeName = current.getStudent().getName();
            s.append(sCurNodeName).append(" <==> ").append(current.getNext().getStudent().getName()).append("\n");
            current = current.getNext();
        }
        return "\n========Print Start=============\n" + s.toString() + "========Print End=============";
    }

    //removes the node after the input node
    public void removeAfter(String name) {
        System.out.println("\nRemoved Node After " + name + "\n");
        StudentNode current = head;
        while(current.getNext() != null){
            String sname = current.getNext().getStudent().getName();
            if(sname.equals(name)){
                deleteNode(current.getNext().getNext().getStudent().getName());
                break;
            }
            else
                current = current.getNext();
        }
    }

    //copys the linked list
    public StudentLinkedList copy(String student) {
        StudentNode current = head;
        StudentLinkedList newLinkedList = new StudentLinkedList();
        newLinkedList.insertNode(current.getStudent());
        while(current.getNext() != null){
            newLinkedList.insertNode(current.getNext().getStudent());
            current = current.getNext();
        }
        System.out.println("\nCopy of " + student + "'s list has been created \nHere it is:\n");
        return newLinkedList;
    }

    //removes all nodes with input age
    public void removeDuplicateAge(int age, Student newStudent) {
        System.out.println("\nRemoved All Nodes Aged " + age + "\n");
        StudentNode current = head;
        while(current.getNext() != null){
            if(current.getStudent().getAge() == age){
                deleteNode(current.getStudent().getName());
                current = current.getNext();
            }
            else
                current = current.getNext();
        }
        if(current.getStudent().getAge() == age){
            deleteNode(current.getStudent().getName());
        }
    }

    //removes all nodes with input year
    public void removeDuplicateYear(int year, Student newStudent) {
        System.out.println("\nRemoved All Nodes With GradYear: " + year + "\n");
        StudentNode current = head;
        while(current.getNext() != null){
            if(current.getStudent().getGradYear() == year){
                deleteNode(current.getStudent().getName());
                current = current.getNext();
            }
            else
                current = current.getNext();
        }
        if(current.getStudent().getGradYear() == year){
            deleteNode(current.getStudent().getName());
        }
    }

    //removes all nodes with input major
    public void removeDuplicateMajor(String major, Student newStudent) {
        System.out.println("\nRemoved All Nodes With " + major + " Major\n");
        StudentNode current = head;
        while(current.getNext() != null){
            if(current.getStudent().getMajor().equals(major)){
                deleteNode(current.getStudent().getName());
                current = current.getNext();
            }
            else
                current = current.getNext();
        }
        if(current.getStudent().getMajor().equals(major)){
            deleteNode(current.getStudent().getName());
        }
    }

    //returns max age
    public int maxAge(Student firstNode) {
        StudentNode current = head;
        int age = 0;
        while(current.getNext() != null){
            int newAge = current.getStudent().getAge();
            if(newAge > age){
                age = newAge;
                current = current.getNext();
            }
            else
                current = current.getNext();
        }
        int newAge = current.getStudent().getAge();
        if(newAge > age){
            age = newAge;
        }
        System.out.println("\nMax Age: " + age + "\n");
        return age;
    }

    //returns max year
    public int maxYear(Student firstNode) {
        StudentNode current = head;
        int year = 0;
        while(current.getNext() != null){
            int newYear = current.getStudent().getGradYear();
            if(newYear > year){
                year = newYear;
                current = current.getNext();
            }
            else
                current = current.getNext();
        }
        int newYear = current.getStudent().getGradYear();
        if(newYear > year){
            year = newYear;
        }
        System.out.println("\nMax Year: " + year + "\n");
        return year;
    }
}