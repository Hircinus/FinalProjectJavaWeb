# Bookings Manager

## Description
This project was set out to be a bookings manager for small to medium-sized businesses. It would allow them to register their company, create bookings for clients and view and edit their information and saved bookings from a unified dashboard.

Given some unfortunate time constraints, however, the project is not complete to this standard. All CRUD operations work with both bookings and companies (GET, POST, PUT and DELETE) but they are not all implemented on the front-end.

In its current state, users can create a company and then select any of the created companies to view all of their bookings, add more or delete old ones.

## Construction
The app is built with a Spring Boot backend connected to an H2 database (for a deployed solution, a persistent database would be used). For the front-end, it was built in React.

To run the project, you will first need to unpack and run the Java back-end, then open and run the React front-end, and everything should work from there.

## Challenges
The largest challenge I faced with this project was my underestimation of the difficulty and complexity of creating something as seemingly simple as a bookings manager. For instance, I had to wrestle with my back-end code for almost a whole afternoon since it was not communicating with my front-end (this turned out to be a fairly minor issue of enabling cross-origin access). This doesn't even account for the many hours spent trying to just wrap my head around the best way of going about creating certain features.
In the future, I would like to have a better plan to spend less time trying to iron out what were ultimately minor details.
