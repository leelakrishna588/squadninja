This File Contains About TeamManagementService 
->Consume data from RabbitMQ queue named idea and store data in mongodb. 
->Create PUT api for updating list of SP selected for particular idea(from auto-generated team) and demo to mentors.
->Create PUT api for updating document with applied users when a SP applies for a particular idea and demo to mentors.
->Create a PUT api to update the document: When IH accepts particular SP from applied list, delete SP from aplied users and updated to selected team list and if IH rejects, delete from applied team list.
->Create a PUT api to update document: When SP joins invited ideas. Delete SP from invited list and add him to selected team list and demo to mentors.
