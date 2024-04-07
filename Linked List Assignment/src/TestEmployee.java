public class TestEmployee {
    public static void main(String[] args) {
        Student chris = new Student("Chris", 19, "CS", 2025);
        Student john = new Student("John", 20, "DS", 2026);
        Student bill = new Student("Bill", 17, "Math", 2027);
        Student mona = new Student("Mona", 18, "Physics", 2034);
        Student tom = new Student("Tom", 18, "Physics", 2018);
        Student dylan = new Student("Dylan", 18, "HackerVibes", 2027);
        Student charlie = new Student("Charlie", 19, "Rizz", 2037);
        Student oz = new Student("Oz", 22, "StudentAdvisor", 2027);
        Student pawan = new Student("Pawan", 25, "Rizz", 2004);
        Student nina = new Student("Nina", 36, "CS", 2025);
        StudentLinkedList list = new StudentLinkedList();
        list.insertNode(chris);
        list.insertNode(john);
        list.insertNode(bill);
        list.insertNode(mona);
        list.insertNode(tom);
        list.insertNode(dylan);
        list.insertNode(charlie);
        list.insertNode(oz);
        list.insertNode(pawan);
        list.insertNode(nina);

        list.printList();
        list.removeAfter(john);
        list.printList();
        list.copy(mona);
        list.removeDuplicateAge(18, john);
        list.printList();
        list.removeDuplicateMajor("Rizz", pawan);
        list.printList();
        list.removeDuplicateYear(2004, nina);
        list.printList();
        list.removeDuplicateYear(2027, pawan);
        list.printList();
        list.maxAge(chris);
        list.printList();
    }
}