## General vision : </br> 
Simple WebApp for data manipulation and registration of companies. Built with Java Server Faces specification (Mojarra) and PrimeFaces components. </br>

### Requirements to run the project: </br>
- Java 8 </br>
- TomCat Server 9.0 </br>
- MySQL Server </br>

## Instructions : </br>

### Steps:</br>
Install Tomcat Server 9.0 in Eclipse IDE; </br>
Start MySQL Server with the correct configurations, shown below </br>
Create "cursojsfprimefaces" database in MySQL</br>
Import the project on Eclipse IDE</br>
Run on TomCat Container</br>

### In your Web Browser, access:
http://localhost:8080/curso-jsf-primefaces-essencial/

### persistence.xml (Database access configurations)
```
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1"
	xmlns="http://xmlns.jcp.org/xml/ns/persistence" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
	
	<persistence-unit name="AlgaWorksPU">
		<properties>
			<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/cursojsfprimefaces" />
			<property name="javax.persistence.jdbc.user" value="curso-jsf" />
			<property name="javax.persistence.jdbc.password" value="12345" />
			<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />

			<property name="javax.persistence.schema-generation.database.action" value="update" />
      		<property name="javax.persistence.schema-generation.create-source" value="metadata" />
      		<property name="javax.persistence.sql-load-script-source" value="META-INF/sql/dados-iniciais.sql"/>
      		
			<property name="hibernate.show_sql" value="true" />
			<property name="hibernate.format_sql" value="true" />
		</properties>
	</persistence-unit>
</persistence>
```

</br>

![Screenshot from 2023-04-11 13-56-32](https://user-images.githubusercontent.com/101358552/231235372-e6a542ec-a1f2-486f-b244-bad79ad8ebe7.png)

</br>



