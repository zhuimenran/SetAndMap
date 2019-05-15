package com.txb.hashtable;

public class Student {
    int grade;
    int cls;
    String firstName;
    String lastName;

    Student(int grade, int cls, String firstName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;

    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {//相同的引用
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {//类型不相等，
            return false;
        }

        //到这里就可以说明obj这个类肯定是Student类型的了
        Student another = (Student) obj;
        return this.cls == another.cls &&
                this.grade == another.grade &&
                //不区分大小写
                this.firstName.toLowerCase().equals(another.firstName.toLowerCase()) &&
                //不区分大小写
                this.lastName.toLowerCase().equals(another.lastName.toLowerCase());
    }
}
