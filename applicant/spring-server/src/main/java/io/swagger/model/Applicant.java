package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Applicant
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-06T01:48:27.968Z")

public class Applicant   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("studentnumber")
  private Integer studentnumber = null;

  @JsonProperty("familyname")
  private String familyname = null;

  @JsonProperty("givenname")
  private String givenname = null;

  @JsonProperty("program")
  private String program = null;

  @JsonProperty("year")
  private Integer year = null;

  @JsonProperty("tacourses")
  private String tacourses = null;

  @JsonProperty("courses")
  private String courses = null;

  @JsonProperty("phonenumber")
  private String phonenumber = null;

  @JsonProperty("emailaddress")
  private String emailaddress = null;

  @JsonProperty("workstatus")
  private String workstatus = null;

  @JsonProperty("workstatusexplain")
  private String workstatusexplain = null;

  @JsonProperty("studentdepartment")
  private String studentdepartment = null;

  @JsonProperty("studentdepartmentexplain")
  private String studentdepartmentexplain = null;

  @JsonProperty("dateofapplication")
  private String dateofapplication = null;

  public Applicant id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Applicant studentnumber(Integer studentnumber) {
    this.studentnumber = studentnumber;
    return this;
  }

   /**
   * Get studentnumber
   * @return studentnumber
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getStudentnumber() {
    return studentnumber;
  }

  public void setStudentnumber(Integer studentnumber) {
    this.studentnumber = studentnumber;
  }

  public Applicant familyname(String familyname) {
    this.familyname = familyname;
    return this;
  }

   /**
   * Get familyname
   * @return familyname
  **/
  @ApiModelProperty(required = true, value = "")
  public String getFamilyname() {
    return familyname;
  }

  public void setFamilyname(String familyname) {
    this.familyname = familyname;
  }

  public Applicant givenname(String givenname) {
    this.givenname = givenname;
    return this;
  }

   /**
   * Get givenname
   * @return givenname
  **/
  @ApiModelProperty(required = true, value = "")
  public String getGivenname() {
    return givenname;
  }

  public void setGivenname(String givenname) {
    this.givenname = givenname;
  }

  public Applicant program(String program) {
    this.program = program;
    return this;
  }

   /**
   * Get program
   * @return program
  **/
  @ApiModelProperty(required = true, value = "")
  public String getProgram() {
    return program;
  }

  public void setProgram(String program) {
    this.program = program;
  }

  public Applicant year(Integer year) {
    this.year = year;
    return this;
  }

   /**
   * Get year
   * @return year
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Applicant tacourses(String tacourses) {
    this.tacourses = tacourses;
    return this;
  }

   /**
   * Get tacourses
   * @return tacourses
  **/
  @ApiModelProperty(required = true, value = "")
  public String getTacourses() {
    return tacourses;
  }

  public void setTacourses(String tacourses) {
    this.tacourses = tacourses;
  }

  public Applicant courses(String courses) {
    this.courses = courses;
    return this;
  }

   /**
   * Get courses
   * @return courses
  **/
  @ApiModelProperty(required = true, value = "")
  public String getCourses() {
    return courses;
  }

  public void setCourses(String courses) {
    this.courses = courses;
  }

  public Applicant phonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
    return this;
  }

   /**
   * Get phonenumber
   * @return phonenumber
  **/
  @ApiModelProperty(required = true, value = "")
  public String getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }

  public Applicant emailaddress(String emailaddress) {
    this.emailaddress = emailaddress;
    return this;
  }

   /**
   * Get emailaddress
   * @return emailaddress
  **/
  @ApiModelProperty(required = true, value = "")
  public String getEmailaddress() {
    return emailaddress;
  }

  public void setEmailaddress(String emailaddress) {
    this.emailaddress = emailaddress;
  }

  public Applicant workstatus(String workstatus) {
    this.workstatus = workstatus;
    return this;
  }

   /**
   * Get workstatus
   * @return workstatus
  **/
  @ApiModelProperty(required = true, value = "")
  public String getWorkstatus() {
    return workstatus;
  }

  public void setWorkstatus(String workstatus) {
    this.workstatus = workstatus;
  }

  public Applicant workstatusexplain(String workstatusexplain) {
    this.workstatusexplain = workstatusexplain;
    return this;
  }

   /**
   * Get workstatusexplain
   * @return workstatusexplain
  **/
  @ApiModelProperty(required = true, value = "")
  public String getWorkstatusexplain() {
    return workstatusexplain;
  }

  public void setWorkstatusexplain(String workstatusexplain) {
    this.workstatusexplain = workstatusexplain;
  }

  public Applicant studentdepartment(String studentdepartment) {
    this.studentdepartment = studentdepartment;
    return this;
  }

   /**
   * Get studentdepartment
   * @return studentdepartment
  **/
  @ApiModelProperty(required = true, value = "")
  public String getStudentdepartment() {
    return studentdepartment;
  }

  public void setStudentdepartment(String studentdepartment) {
    this.studentdepartment = studentdepartment;
  }

  public Applicant studentdepartmentexplain(String studentdepartmentexplain) {
    this.studentdepartmentexplain = studentdepartmentexplain;
    return this;
  }

   /**
   * Get studentdepartmentexplain
   * @return studentdepartmentexplain
  **/
  @ApiModelProperty(required = true, value = "")
  public String getStudentdepartmentexplain() {
    return studentdepartmentexplain;
  }

  public void setStudentdepartmentexplain(String studentdepartmentexplain) {
    this.studentdepartmentexplain = studentdepartmentexplain;
  }

  public Applicant dateofapplication(String dateofapplication) {
    this.dateofapplication = dateofapplication;
    return this;
  }

   /**
   * Get dateofapplication
   * @return dateofapplication
  **/
  @ApiModelProperty(required = true, value = "")
  public String getDateofapplication() {
    return dateofapplication;
  }

  public void setDateofapplication(String dateofapplication) {
    this.dateofapplication = dateofapplication;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Applicant applicant = (Applicant) o;
    return Objects.equals(this.id, applicant.id) &&
        Objects.equals(this.studentnumber, applicant.studentnumber) &&
        Objects.equals(this.familyname, applicant.familyname) &&
        Objects.equals(this.givenname, applicant.givenname) &&
        Objects.equals(this.program, applicant.program) &&
        Objects.equals(this.year, applicant.year) &&
        Objects.equals(this.tacourses, applicant.tacourses) &&
        Objects.equals(this.courses, applicant.courses) &&
        Objects.equals(this.phonenumber, applicant.phonenumber) &&
        Objects.equals(this.emailaddress, applicant.emailaddress) &&
        Objects.equals(this.workstatus, applicant.workstatus) &&
        Objects.equals(this.workstatusexplain, applicant.workstatusexplain) &&
        Objects.equals(this.studentdepartment, applicant.studentdepartment) &&
        Objects.equals(this.studentdepartmentexplain, applicant.studentdepartmentexplain) &&
        Objects.equals(this.dateofapplication, applicant.dateofapplication);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, studentnumber, familyname, givenname, program, year, tacourses, courses, phonenumber, emailaddress, workstatus, workstatusexplain, studentdepartment, studentdepartmentexplain, dateofapplication);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Applicant {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    studentnumber: ").append(toIndentedString(studentnumber)).append("\n");
    sb.append("    familyname: ").append(toIndentedString(familyname)).append("\n");
    sb.append("    givenname: ").append(toIndentedString(givenname)).append("\n");
    sb.append("    program: ").append(toIndentedString(program)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    tacourses: ").append(toIndentedString(tacourses)).append("\n");
    sb.append("    courses: ").append(toIndentedString(courses)).append("\n");
    sb.append("    phonenumber: ").append(toIndentedString(phonenumber)).append("\n");
    sb.append("    emailaddress: ").append(toIndentedString(emailaddress)).append("\n");
    sb.append("    workstatus: ").append(toIndentedString(workstatus)).append("\n");
    sb.append("    workstatusexplain: ").append(toIndentedString(workstatusexplain)).append("\n");
    sb.append("    studentdepartment: ").append(toIndentedString(studentdepartment)).append("\n");
    sb.append("    studentdepartmentexplain: ").append(toIndentedString(studentdepartmentexplain)).append("\n");
    sb.append("    dateofapplication: ").append(toIndentedString(dateofapplication)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

