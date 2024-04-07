public class StudentNode {
    private Student student;
    private StudentNode next;
    private StudentNode prev;

    // constructs student node
    public StudentNode(Student student){
        this.student = student;
        this.next = null;
        this.prev = null;
    }

    // gets student
    public Student getStudent() {
        return student;
    }

    // gets next node
    public StudentNode getNext() {
        return next;
    }

    // sets next node
    public void setNext(StudentNode next) {
        this.next = next;
    }

    // set prev node
    public void setPrev(StudentNode prev) {
        this.prev = prev;
    }
}