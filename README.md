# RestaurantTableReservationService

## Table of Contents
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Configuration](#configuration)
- [Contributing](#contributing)
- [Author](#author)

## Getting Started

To get started with this Spring project, follow these steps:

1. Clone the repository: `git clone https://github.com/woojinpark43/StoreTableReservationService.git`
2. Build the project using Maven: `mvn clean install`
3. Connect the data base appropriately (I used mysql at port 3307 //  change this in application.yml if you need to)
4. Run the application: use intellij :)

## Usage

Here's an example of how to use this Spring project:
-Go to [http://localhost:8080/]http://localhost:8080/ after running the application
-The UI should be easy to follow and guide you through the app (if not my apology)
-Here are some of the main controller apis listed below

@RequestMapping("/login")
- sends you to logging page where spring-security is used.
- cannot access other pages except "/", "/member/register", "/kiosk", "/partner/register", "/partner/index"

@GetMapping("/partner/info")
- displays Restaurant Partner details (that is currently logged in) on a talbe.
- Use cookie to store user name

@GetMapping("/partner/index")
- return HTML for the main page

@GetMapping("/partner/register")
- return HTML for the register page

@PostMapping("/partner/register")
- save the registered partner in db and login

------------------------------------------------------------------------

@GetMapping("/reservation")
- return reservation page HTML

@PostMapping("/reservation")
- save the reserved time, date, user and store name in db

@RequestMapping("/reservation_complete")
- reservation complete HTML

-------------------------------------------------------------------------

@GetMapping("/member/info")
- displays client details (that is currently logged in) on a table.
- Use cookie to store user name

@GetMapping("/member/index")
- return HTML for the main page

@GetMapping("/member/register")
- return HTML for the register page

@PostMapping("/member/register")
- save the registered client in db and login

------------------------------------------------------------------------

@GetMapping("/kiosk")
- returns HTML for Kiosk page

@PostMapping("/kiosk")
- verify the client's input of kiosk number with the number that is stored on db
- if successful moves to a complete kiosk page

-------------------------------------------------------------------------

@GetMapping("/admin/partner/list")
- displays lists of Restaurant Partners that are registered in a table format
- admin can search through partners's attribute (username, storename, location, etc)

@GetMapping("/admin/main")
- returns HTML for admin main page

## Configuration

This project uses the following configurations:

- Java version: 11
- Spring Boot version: 2.7.17
- Database: Mysql (jdbc:mysql://localhost:3307/storereservation)
- Lombok
- Tomcat
- Spring Web
- Spring Boot Security
- JPA
- Maven
- War

## Contributing

I welcome contributions from the community! If you'd like to contribute

## Author

Woojin Park

