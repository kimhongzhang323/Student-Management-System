class UndergraduateStudent extends Student {
    public UndergraduateStudent(String name, int matricNo) {
        super(name, matricNo);
    }

    @Override
    public String getStudentInfo() {
        return super.getStudentInfo() + "\nStudent Type: Undergraduate"; 
    }
}