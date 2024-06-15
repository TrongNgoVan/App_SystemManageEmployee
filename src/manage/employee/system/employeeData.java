/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage.employee.system;

import java.sql.Date;

/**
 *
 * @author MEDIAMART PHU SON
 */
public class employeeData {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNum;
    private String position;
    private String image;
    private Date date;
    private Integer wday1;
    private Integer wday2;
    private Integer wday3;
    private Integer wday4;
    private Double salary1;
    private Double salary2;
    private String acc;
    private String bank;
    
    
    public employeeData(Integer employeeId, String firstName, String lastName, String gender, String phoneNum, String position, String image, Date date,Integer wday1,Integer wday2,Integer wday3,Integer wday4,Double salary1,Double salary2 , String acc , String bank){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNum = phoneNum;
        this.position = position;
        this.image = image;
        this.date = date;
        this.wday1 = wday1;
        this.wday2 = wday2;
        this.wday3 = wday3;
        this.wday4 = wday4;
        this.salary1 = salary1;
        this.salary2 = salary2;
        this.acc=acc;
        this.bank=bank;
    }

    
    public Integer getEmployeeId(){
        return employeeId;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getGender(){
        return gender;
    }
    public String getPhoneNum(){
        return phoneNum;
    }    
    public String getPosition(){
        return position;
    }
    public String getImage(){
        return image;
    }
    public Date getDate(){
        return date;
    }
    public Integer getWday1(){
        return wday1;
    }
    public Integer getWday4(){
        return wday4;
    }
    public Integer getWday2(){
        return wday2;
    }
    public Integer getWday3(){
        return wday3;
    }
   public Double getSalary1() {
    // Format salary1 to two decimal places
    return salary1;
}

public Double getSalary2() {
    int s = wday1 + wday2 + wday3 + wday4;
    if (s == 0) return 0.0;
    else {
        salary2 = salary1 * (wday1 + wday2 * 1.2 + wday3 * 2) / 31;
        // Format salary2 to two decimal places
        return salary2;
    }
}

// Helper method to format double to two decimal places

    
     public String getAcc(){
        return acc;
    }
      public String getBank(){
        return bank;
    }
    
}
