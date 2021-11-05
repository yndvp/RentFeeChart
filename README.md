# Rent Fee Report Application

## Overview
This is graphical user interface that allows users to read rent fee of each province from a MySQL database and diplay it is as a chart data
![](images/bookshop-main.png)

## Technologies
- Java
- JavaFX
- MySQL
- MVC Structure

## Features
- **Province class**
  - It's a model class that specifies structure of province object

- **DBUtilities class**
  - This class set a connection with mysql database and execute sql statement

- **SQL Generator class**
  - In this class, we can generate large amount of random rent fee data query for each provinces

- **Chart View**
  - RentFeesView controller takes data from mysql database and display it as a chart through rent-fees-view
![](img/chart-view.png)

- **Table View**
  - RentFeesView controller takes data from mysql database and display it as a table through table-view.fxml
![](img/table-view.png)

