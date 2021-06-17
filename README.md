# Student-Maintenance-Application

> Develop an application to store Student information using following services

- Insert a Student data
- Search a Student data
- Remove a Student data
- Update student email Address
- Calculate aggregate marks scored by the Student at the end of academic year
- Retrieve the Grade of the Student on basis of their aggregate marks

### API's Structure

- To Insert a Student Data(path variables = quaterlyMark/halfYearlyMark/AnnualMark) -  `/add/{quaterlyMark}/{halfYearlyMark}/{AnnualMark}`
- To Search a Student Data(path variable = id) - `/search/{id}`
- To Remove a Student Data(path variable = id) - `/remove/{id}`
- To Update student Email Address(request body = StudentInfoBean object contains id and email only) - `/update`
- To return Aggregate Marks(path variable = id) - `/getMark/{id}`
- To retrive Grade of the student(path variable = id) - `/getGrade/{id}`

### Database Structure

<img src="https://user-images.githubusercontent.com/37381228/122375391-cdc5fc00-cf80-11eb-93f0-8b9c04a70410.png"/>

### File Structure 

<img src = "https://user-images.githubusercontent.com/37381228/122375427-d4ed0a00-cf80-11eb-8913-d158645f3ec8.png"/>

### Output
- [Insert a Student Data](https://github.com/Ratheshprabakar/Student-Maintenance-Application/blob/master/Output/Add.png)
- [Search a Student Data](https://github.com/Ratheshprabakar/Student-Maintenance-Application/blob/master/Output/Search.png)
- [Remove a Student Data](https://github.com/Ratheshprabakar/Student-Maintenance-Application/blob/master/Output/Rmove.png)
- [Update Student Email Address](https://github.com/Ratheshprabakar/Student-Maintenance-Application/blob/master/Output/Update.png)
- [Get Aggregate Marks](https://github.com/Ratheshprabakar/Student-Maintenance-Application/blob/master/Output/Get%20Mark.png)
- [Get Grade](https://github.com/Ratheshprabakar/Student-Maintenance-Application/blob/master/Output/Get%20Grade.png)


