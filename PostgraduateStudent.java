class PostgraduateStudent extends Student {
    public PostgraduateStudent(String name, int matricNo) {
        super(name, matricNo);
    }

    @Override
    public String getStudentInfo() {
        return super.getStudentInfo() + "\nStudent Type: Postgraduate";
    }
}