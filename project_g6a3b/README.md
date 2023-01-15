# Jinghui's Personal Project

## A Restaurant Queuing Application

### Application Purpose

The restaurant queuing application allows users to view restaurant information, including table size and restaurant type. 
Users can select their favorite restaurants for **remote queuing**. 

Table size can be selected according to the number of diners, for example:
 - *1-2 people can choose a small table*
 - *3-4 people can choose a medium table*
 - *5-6 people can choose a large table*
 - *more than 6 people can choose a extra-large table*
 
After applying for a table, users can view that restaurant's current waiting list through the application. 
The application will give users an approximate wait time and how many tables are waiting in front of them.

When there are fewer than a given number of table waiting in front, application will send users a reminder of an upcoming available table. 

If users miss their waiting number, there is no need to requeue and the reservation will still be at the front of the queue. 
If users miss more than three times, the waiting number will be removed from the line. The application will consider the users to give up the free table.

### Potential Users

- Customers who are too far away from the restaurant to queue
- A popular restaurant with long lines most of the time
- Customers who don't want to wait in line at the restaurant
- Customers who want to know the queues at some restaurants

### Application Design Inspiration

At present, even though most restaurants can make reservations by phone call or mobile phone, due to the flexibility and variability of personal time, the reservation time is not always suitable for customers. Calling to cancel an appointment or change the time is not very convenient. Some people even realize they didn't make a reservation in advance until they want to eat at this restaurant.

Waiting in line for a table at a popular restaurant is a painful process. People often feel hungry and unable to get a table when they arrive. Sometimes the waiters are so busy that they forget the guests waiting at the door.

So having such an application also cuts down on the workload of restaurant staff, eliminating the need for traditional paper-and-pencil registration methods for queuing.

For the guests, the choice is more convenient. They can open the application to see the queue information of each restaurant, to avoid anxiety and boring waiting. It is also more flexible for personal time management. Customers do not need to advance a day or two to reserve the restaurant and time. They just have to queue remotely a few minutes before they want to go.

## User Stories
- As a user, I want to be able to select a restaurant in my collection and view the restaurant in detail
- As a user, I want to be able to add a new customer to the queue of the restaurant with a given table size
- As a user, I want to be able to view the details of waiting time and the number of table in front of me
- As a user, I want to be able to delete my reservation in queue

- As a user, I want to be able to save my queuing list which contains all customers to file
- As a user, I want to be able to reload my queuing list from file when the program starts

## Instructions for Grader
- You can generate the first required event by select the **menu** item labelled **"Customers"**, then click the button labelled **"Add to Queue"**, then input a preferred number and choose a table size, then you have added Customer to Queue.
  (A panel display the adding information after you click the button labelled **"Display Waiting List"**).
- You can generate the second required event by select the **menu** item labelled **"Customers"**, then click the button labelled **"Check Your Waiting Information"**, then input your waiting number and a table size which are added before, then you have got the result after search Customer in Queue.
- You can locate my visual component by select the **menu** item labelled **"Customers"**, there are images added to buttons. 
  Or You can trigger my audio component by select the **menu** item labelled **"Customers"**, then click a button.
- You can save the state of my application by select the **menu** item labelled **"Save To File"**.
- You can reload the state of my application by select the **menu** item labelled **"Reload From File"**, then click the button labelled **"search"** and choose the file (customers.txt as recommended for test). 

## Phase 4: Task 2
- Test and design a class that is robust.  You must have at least one method that throws a checked exception.  You must have one test for the case where the exception is expected and another where the exception is not expected.
