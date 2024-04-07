public class StudentLinkedList {
    private StudentNode head;
    private StudentNode tail;

    public StudentLinkedList(){
        head = null;
        tail = null;
    }

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

    public StudentNode searchNode(String name){
        StudentNode current = head;
        if(!current.getStudent().getName().equals(name)){
            while(current.getNext() != null){
                String sname = current.getNext().getStudent().getName();
                if(sname.equals(name)){
                    System.out.println("Current Node => " + current.getNext().getStudent().getName());
                    return current.getNext();
                }
                else
                    current = current.getNext();
            }
        }
        return current;
    }

    public void deleteNode(String name){
        StudentNode current = head;
        if(!current.getStudent().getName().equals(name)){
            while(current.getNext() != null){
                String sname = current.getNext().getStudent().getName();
                if(sname.equals(name)){
                    current.setNext(current.getNext().getNext());
                    //current.getNext().getNext().setPrev(current.getPrev().getPrev());
                    break;
                }
                else
                    current = current.getNext();
            }
        }
    }


    public void printList(){
        StudentNode current = head;
        System.out.println("========Print Start=============");
        while(current.getNext() != null){
            String sCurNodeName = current.getStudent().getName();
            System.out.println(sCurNodeName + " <==> " + current.getNext().getStudent().getName());
            current = current.getNext();
        }
        System.out.println("========Print End=============");
    }

    public void removeAfter(Student newName) {
        String name = newName.getName();
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

    public void copy(Student newStudent){
        String name = newStudent.getName();
        StudentNode current = head;
        StudentLinkedList newLinkedList = new StudentLinkedList();
        newLinkedList.insertNode(current.getStudent());
        while(current.getNext() != null){
            newLinkedList.insertNode(current.getNext().getStudent());
            current = current.getNext();
        }
        System.out.println("\nCopy of " + name + "'s list has been created \nHere it is:\n");
        newLinkedList.printList();
    }

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