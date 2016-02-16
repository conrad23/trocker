# trocker
[Academic] Program used to track various information for members of the GVSU rock climbing club.


### Comments:
* Could possibly use Linked List to store Members/Routes
* Should Route be entirely separate object? i.e. should there be a list of Routes for Members to choose from or something else?

#### TrockerFrame:
* main() - displays panels in frame

#### TrockerPanel extends JPanel implements ActionListener:
* TrockerPanel() - constructor to set up buttons, labels, etc. to allow the ability to interact with information
* actionPerformed(ActionEvent e) - allows interaction with buttons

#### Member:
* variables to track: memberID, firstName, lastName, routesClimbed (some sort of list of Routes), totalTimeAtGym, numberOfRoutesAttempted, climberExperience, bestTimeForRoute(perhaps?)
* getters/setters

#### Route:
* variables to track: routeID, routeName, routeExperienceLevel
* getters/setters

#### Trocker:
* insertMember(Member member) - inserts new Member to database
* insertRoute(int memberID, Route route) - inserts new Route for member
* deleteMember(int memberID) - deletes Member from database
* deleteRoute(int memberID, int routeID) - deletes Route from Member
* deleteRoute(int routeID) - deletes Route everywhere
* incRoutesClimbed() - increases routesClimbed by 1
* incNumberOfAttempts() - increases numberOfRoutesAttempted by 1
* saveDB() - save database of Members/Routes
* loadDB() - load database of Members/Routes

#### TrockerTest:
* JUnit tests for Trocker
